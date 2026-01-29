@file:Suppress("UnstableApiUsage")

plugins {
    id("net.fabricmc.fabric-loom")
    id("dev.kikugie.postprocess.jsonlang")
    id("me.modmuss50.mod-publish-plugin")
    id("maven-publish")
}

val minecraft = stonecutter.current.version
val mcVersion = stonecutter.current.project.substringBeforeLast('-')

tasks.named<ProcessResources>("processResources") {
    fun prop(name: String) = project.property(name) as String

    val props = HashMap<String, String>().apply {
        this["version"] = prop("mod.version") + "+" + prop("deps.minecraft")
        this["minecraft"] = ">26 <27"
    }

    filesMatching(listOf("fabric.mod.json", "META-INF/neoforge.mods.toml", "META-INF/mods.toml")) {
        expand(props)
    }

}

tasks.named("processResources") {
    dependsOn(":${stonecutter.current.project}:stonecutterGenerate")
}

version = "${property("mod.version")}+${property("deps.minecraft")}-fabric"
base.archivesName = property("mod.id") as String

//loom {
//    accessWidenerPath = rootProject.file("src/main/resources/${property("mod.id")}.accesswidener")
//}

jsonlang {
    languageDirectories = listOf("assets/${property("mod.id")}/lang")
    prettyPrint = true
}

repositories {
    mavenLocal()
    exclusiveContent {
        forRepository {
            maven {
                name = "shedaniel (Cloth Config)"
                url = uri("https://maven.shedaniel.me/")
            }
        }
        filter {
            includeGroupAndSubgroups("me.shedaniel")

        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Terraformers (Mod Menu)"
                url = uri("https://maven.terraformersmc.com/releases/")
            }
        }
        filter {
            includeGroupAndSubgroups("com.terraformersmc")
            includeGroupAndSubgroups("dev.emi")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Sisby Maven"
                url = uri("https://repo.sleeping.town/")
            }
        }
        filter {
            includeGroupAndSubgroups("folk.sisby")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Xander Maven"
                url = uri("https://maven.isxander.dev/releases")
            }
        }
        filter {
            includeGroupAndSubgroups("dev.isxander")
            includeGroupAndSubgroups("org.quiltmc.parsers")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "REI Maven"
                url = uri("https://maven.architectury.dev")
            }
        }
        filter {
            includeGroupAndSubgroups("dev.architectury")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Fuzs Mod Resources"
                url = uri("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/")
            }
        }
        filter {
            includeGroupAndSubgroups("fuzs")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Modrinth"
                url = uri("https://api.modrinth.com/maven")
            }
        }
        filter {
            includeGroupAndSubgroups("maven.modrinth")
        }
    }
    maven {
        name = "JEI - Jared's maven"
        url = uri("https://maven.blamejared.com/")
        content {
            includeGroup("mezz.jei")
        }
    }
    maven {
        name = "JEI - fallback maven"
        url = uri("https://modmaven.dev/")
        content {
            includeGroup("mezz.jei")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Greenhouse Maven"
                url = uri("https://maven.greenhouse.lgbt/releases/")
            }
        }
        filter {
            includeGroup("vectorwing")
        }
    }
    exclusiveContent {
        forRepository {
            maven {
                name = "Greenhouse Maven"
                url = uri("https://jitpack.io")
            }
        }
        filter {
            includeGroup("com.github.Chocohead")
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${property("deps.minecraft")}")
    implementation("net.fabricmc:fabric-loader:${property("deps.fabric_loader")}")

    implementation("folk.sisby:kaleido-config:${property("deps.kaleido")}")
    include("folk.sisby:kaleido-config:${property("deps.kaleido")}")
    compileOnly("maven.modrinth:farmers-delight:${property("deps.fd")}")


}

configurations.all {
    resolutionStrategy {
        force("net.fabricmc:fabric-loader:${property("deps.fabric_loader")}")
    }
}

stonecutter {
    replacements.string {
        direction = eval(current.version, ">1.21")
        replace("ResourceLocation", "Identifier")
    }
}

tasks {
    processResources {
        exclude("**/neoforge.mods.toml", "**/mods.toml")
    }

    register<Copy>("buildAndCollect") {
        group = "build"
        from(jar.map { it.archiveFile })
        into(rootProject.layout.buildDirectory.file("libs/${project.property("mod.version")}"))
        dependsOn("build")
    }
}

loom.runs.named("server") {
    isIdeConfigGenerated = false
}

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

val additionalVersionsStr = findProperty("publish.additionalVersions") as String?
val additionalVersions: List<String> = additionalVersionsStr
    ?.split(",")
    ?.map { it.trim() }
    ?.filter { it.isNotEmpty() }
    ?: emptyList()

publishMods {
    file = tasks.jar.map { it.archiveFile.get() }
    additionalFiles.from(tasks.named<org.gradle.jvm.tasks.Jar>("sourcesJar").map { it.archiveFile.get() })

    // one of BETA, ALPHA, STABLE
    type = BETA
    displayName = "${property("mod.name")} ${property("mod.version")} for ${stonecutter.current.version} Fabric"
    version = "${property("mod.version")}+${property("deps.minecraft")}-fabric"
    changelog = provider { rootProject.file("CHANGELOG-LATEST.md").readText() }
    modLoaders.add("fabric")

    modrinth {
        projectId = property("publish.modrinth") as String
        accessToken = env.MODRINTH_API_KEY.orNull()
        minecraftVersions.add(property("deps.minecraft").toString())
        minecraftVersions.addAll(additionalVersions)
        requires("fabric-api")
        optional("farmers-delight-refabricated")
        optional("mcqoy")
    }

    curseforge {
        projectId = property("publish.curseforge") as String
        accessToken = env.CURSEFORGE_API_KEY.orNull()
        minecraftVersions.add(stonecutter.current.version)
        minecraftVersions.addAll(additionalVersions)
        requires("fabric-api")
    }
}
