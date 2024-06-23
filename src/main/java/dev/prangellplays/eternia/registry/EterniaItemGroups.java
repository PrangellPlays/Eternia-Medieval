package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class EterniaItemGroups {
    public static final ItemGroup ETERNIA_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Eternia.MOD_ID, "items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eternia.items")).icon(() -> new ItemStack(EterniaItems.CURSED_ARROW)).entries((displayContext, entries) -> {
                entries.add(EterniaItems.CURSED_ARROW);
                entries.add(EterniaItems.GALE_SPHERE);
                entries.add(EterniaItems.VILLAGER_SPAWN);
                entries.add(EterniaItems.CHICKEN_SPAWN);
                entries.add(EterniaItems.COW_SPAWN);
                entries.add(EterniaItems.SHEEP_SPAWN);
                entries.add(EterniaItems.PIG_SPAWN);
                entries.add(EterniaItems.HORSE_SPAWN);
                entries.add(EterniaItems.COIN);
                entries.add(EterniaBlocks.PEDESTAL);
                entries.add(EterniaBlocks.WEAPON_PEDESTAL);
            }).build());
    public static final ItemGroup ETERNIA_GOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Eternia.MOD_ID, "god_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eternia.god_items")).icon(() -> new ItemStack(EterniaArmour.KINGS_CROWN)).entries((displayContext, entries) -> {
                //Jungle
                entries.add(EterniaItems.VINE_WHIP);
                entries.add(EterniaItems.NATURES_UNDERGROWTH);
                entries.add(EterniaItems.PHOENIX_CLAWS);

                //Desert
                entries.add(EterniaItems.PHARAOHS_STAFF);
                entries.add(EterniaItems.DESERTED_EXCALIBUR);

                //Dark Oak Forest
                entries.add(EterniaItems.WITHERS_EDGE_GLAIVE);

                //Taiga
                entries.add(EterniaItems.FROSTED_SCYTHE);
                entries.add(EterniaItems.GLACIAL_DAGGER);
                entries.add(EterniaItems.FROSTBOUND_SHIELD);

                //Savannah
                entries.add(EterniaItems.PIRANHA_BLADE);
                entries.add(EterniaItems.GALE_SPEAR);
                entries.add(EterniaItems.ROOT_SLICER);

                //Mesa
                entries.add(EterniaItems.FLAMING_SCYTHE);

                //Mushroom
                entries.add(EterniaItems.FUNGAL_GAUNTLET);

                //Plains
                entries.add(EterniaItems.WINDWALKER_BLADE);
                entries.add(EterniaItems.DRIPSTONE_DAGGER);
                entries.add(EterniaItems.BRANCHED_AXE_SWORD);

                //Nether
                entries.add(EterniaItems.CURSEBONE_BOW);

                //End
                entries.add(EterniaItems.CELESTIAL_SPEAR);

                //God Items/ Weapons
                entries.add(EterniaItems.ELEMENTAL_CONVERGENCE);
                entries.add(EterniaArmour.KINGS_CROWN);
            }).build());


    public static void init() {
        Eternia.LOGGER.info("Registering Item Groups for " + Eternia.MOD_ID);
    }
}
