# Comfortable Campfires

<a href='https://modrinth.com/mod/comfortable-campfires/versions?l=fabric'><img alt="fabric" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/fabric_vector.svg"></a>
<a href='https://modrinth.com/mod/comfortable-campfires/versions?l=forge'><img alt="forge" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/supported/forge_vector.svg"></a>

Sitting by the campfire is now just a little more comfortable. Lit campfires now give nearby players Regeneration or a configured effect.

Since 2.0, Comfortable Campfires can also be used to allow any block to grant effects. Just add a new line under `effects` in the config e.g. `"minecraft:lava" = "wither"`. With QoMC installed, the following command can be used: `/comfortable_campfires_config effects set "minecraft:lava" wither`. If the effect you are trying to set does not exist (for example, if the mod is not loaded, Regeneration will be used instead.)

Comfortable Campfires can either be installed only on the server, or on the client if using the mod in singleplayer.

## Installation

Comfortable Campfires is a serverside mod for Fabric and NeoForge. On 1.20.1, Forge is also supported.
- On Fabric, [Fabric API](https://modrinth.com/mod/fabric-api) is required.
- Since version 1.2.1, the mod can be configured with [QoMC](https://modrinth.com/mod/qomc).

Prior to 2.0, the default effect granted by campfires is Farmer's Delight's Comfort effect. Farmer's Delight is still optional, and Regeneration will be used if it is not installed.

## Credits

This mod was inspired by the Campfire Heal script present in the [Raspberry Flavoured](https://www.curseforge.com/minecraft/modpacks/raspberry-flavoured) modpack, with the added benefit of also working on servers (and on Fabric!)
