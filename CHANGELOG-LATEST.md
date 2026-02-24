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
