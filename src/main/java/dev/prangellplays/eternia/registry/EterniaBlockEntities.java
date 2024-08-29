package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.block.WeaponPedestalBlock;
import dev.prangellplays.eternia.block.entity.WeaponPedestalBlockEntity;
import dev.prangellplays.eternia.registry.EterniaBlocks;
import dev.prangellplays.eternia.block.entity.PedestalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EterniaBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Eternia.MOD_ID, "pedestal_block_entity"), FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new, EterniaBlocks.PEDESTAL).build());
    public static final BlockEntityType<WeaponPedestalBlockEntity> WEAPON_PEDESTAL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Eternia.MOD_ID, "weapon_pedestal_block_entity"), FabricBlockEntityTypeBuilder.create(WeaponPedestalBlockEntity::new, EterniaBlocks.WEAPON_PEDESTAL).build());

    public static void init() {
        Eternia.LOGGER.info("Registering Block Entities for " + Eternia.MOD_ID);
    }
}
