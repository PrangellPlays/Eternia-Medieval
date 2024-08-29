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
                entries.add(EterniaItems.ENDER_STAR);
                entries.add(EterniaItems.NETHER_REACTOR_CORE);
                entries.add(EterniaItems.ENDER_REACTOR_CORE);
                entries.add(EterniaItems.BONE_MEALER);
                entries.add(EterniaItems.COOKED_CARROT);
                entries.add(EterniaItems.SHULKER_DUST);
                entries.add(EterniaItems.ENDERITE_INGOT);
            }).build());
    public static final ItemGroup ETERNIA_GOD_WEAPONS_T1_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Eternia.MOD_ID, "god_weapons_t1"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eternia.god_weapons_t1")).icon(() -> new ItemStack(EterniaItems.WINDWALKER_BLADE)).entries((displayContext, entries) -> {
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
            }).build());
    public static final ItemGroup ETERNIA_GOD_WEAPONS_T2_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Eternia.MOD_ID, "god_weapons_t2"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eternia.god_weapons_t2")).icon(() -> new ItemStack(EterniaItems.PHOENIX_SWORD)).entries((displayContext, entries) -> {
                //Jungle
                entries.add(EterniaItems.PHOENIX_SWORD);

                //Desert


                //Dark Oak Forest


                //Taiga


                //Savannah


                //Mesa


                //Mushroom
                entries.add(EterniaItems.GIANT_SWORD);

                //Plains


                //Nether


                //End

            }).build());
    public static final ItemGroup ETERNIA_GOD_WEAPONS_T3_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Eternia.MOD_ID, "god_weapons_t3"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eternia.god_weapons_t3")).icon(() -> new ItemStack(EterniaItems.PHOENIX_BLADE)).entries((displayContext, entries) -> {
                //Jungle
                entries.add(EterniaItems.PHOENIX_BLADE);

                //Desert


                //Dark Oak Forest


                //Taiga


                //Savannah


                //Mesa


                //Mushroom


                //Plains


                //Nether


                //End

            }).build());
    public static final ItemGroup ETERNIA_EVENT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Eternia.MOD_ID, "event"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.eternia.event")).icon(() -> new ItemStack(EterniaItems.KINGS_CROWN)).entries((displayContext, entries) -> {
                //Events
                entries.add(EterniaItems.SOULSTEALER);
                entries.add(EterniaItems.ENDER_BLADE);
                entries.add(EterniaItems.KINGS_CROWN);
                entries.add(EterniaItems.ELEMENTAL_CONVERGENCE);
            }).build());


    public static void init() {
        Eternia.LOGGER.info("Registering Item Groups for " + Eternia.MOD_ID);
    }
}
