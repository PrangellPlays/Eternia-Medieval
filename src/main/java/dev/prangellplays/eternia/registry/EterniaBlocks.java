package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.block.PedestalBlock;
import dev.prangellplays.eternia.block.WeaponPedestalBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class EterniaBlocks {
    public static final Block PEDESTAL = registerBlock("pedestal", new PedestalBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(2.0f, 6.0f).requiresTool().nonOpaque().notSolid().sounds(BlockSoundGroup.STONE)));
    public static final Block WEAPON_PEDESTAL = registerBlock("weapon_pedestal", new WeaponPedestalBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(2.0f, 6.0f).requiresTool().nonOpaque().notSolid().sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Eternia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Eternia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void init() {
        Eternia.LOGGER.info("Registering ModBlocks for " + Eternia.MOD_ID);
    }
}
