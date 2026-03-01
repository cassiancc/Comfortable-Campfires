# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased

## [2.0.0]

### Added

- Comfortable Campfires can now be used to allow any block to grant effects.
    - Just add a new line under `effects` in the config e.g.
      [effects]
      `"minecraft:lava" = "wither"`
    - With QoMC installed the following command can be used: `/comfortable_campfires_config effects set "minecraft:lava" wither`.
    - If the effect you are trying to set does not exist (for example, if the mod is not loaded, Regeneration will be used instead.)
- QoMC based config is now available for all versions between 1.20.1 and 26.1.

### Changed
- Default campfires now grant Nourishment rather than Comfort, as Comfort will be removed in Farmer's Delight v1.3.

### Removed
- Config options to switch between Comfort and Regeneration, as it has been replaced by this new system.


## [1.2.2]

- Port to 26.1-snapshot-2.
- Fix warning from removed Mod Menu entrypoint.

## [1.2.1]

- Internal rewrite to use Kaleido Config instead of Cloth Config.

## [1.2.0]

### Added
- Config to set amplifier of effect.
- Support for 1.21.4 and above.

## [1.1.2]

- Fixed an incompatibility with Lithium.

## [1.1.1] - 2024-01-06

### Added
- Config options to adjust distance, duration, and whether to use Regeneration or Comfort.

### Changed
- Lowered default duration from 90 seconds to 5 seconds.

### Fixed
- Campfire Y distance is now properly capped.

## [1.0.0] - 2024-01-05

Initial release.
