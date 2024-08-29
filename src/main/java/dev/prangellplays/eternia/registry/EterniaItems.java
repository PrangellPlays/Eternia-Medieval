package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.item.godweapons.event.EnderBladeItem;
import dev.prangellplays.eternia.item.godweapons.event.TheElementalConvergenceItem;
import dev.prangellplays.eternia.item.godweapons.event.SoulstealerItem;
import dev.prangellplays.eternia.item.godweapons.tier1.darkoakforest.WithersEdgeGlaiveItem;
import dev.prangellplays.eternia.item.godweapons.tier1.desert.DesertedExcaliburItem;
import dev.prangellplays.eternia.item.godweapons.tier1.desert.PharaohsStaffItem;
import dev.prangellplays.eternia.item.godweapons.tier1.end.CelestialSpearItem;
import dev.prangellplays.eternia.item.godweapons.event.TheKingsCrownItem;
import dev.prangellplays.eternia.item.godweapons.tier2.jungle.PhoenixSwordItem;
import dev.prangellplays.eternia.item.godweapons.tier2.mushroom.GiantSword;
import dev.prangellplays.eternia.item.godweapons.tier3.jungle.PhoenixBladeItem;
import dev.prangellplays.eternia.item.item.BoneMealerItem;
import dev.prangellplays.eternia.item.item.CoinItem;
import dev.prangellplays.eternia.item.godweapons.tier1.plains.BranchedAxeItem;
import dev.prangellplays.eternia.item.godweapons.tier1.plains.BranchedAxeSwordItem;
import dev.prangellplays.eternia.item.godweapons.tier1.plains.DripstoneDaggerItem;
import dev.prangellplays.eternia.item.godweapons.tier1.plains.WindwalkerBladeItem;
import dev.prangellplays.eternia.item.godweapons.tier1.savanah.GaleSphereItem;
import dev.prangellplays.eternia.item.item.mob_drops.ShulkerDustItem;
import dev.prangellplays.eternia.item.item.spawn.*;
import dev.prangellplays.eternia.item.godweapons.tier1.jungle.NaturesUndergrowthItem;
import dev.prangellplays.eternia.item.godweapons.tier1.jungle.PhoenixClawsShovelItem;
import dev.prangellplays.eternia.item.godweapons.tier1.jungle.PhoenixClawsSwordItem;
import dev.prangellplays.eternia.item.godweapons.tier1.jungle.VineWhipItem;
import dev.prangellplays.eternia.item.godweapons.tier1.mesa.FlamingScytheItem;
import dev.prangellplays.eternia.item.godweapons.tier1.mushroom.FungalGauntletItem;
import dev.prangellplays.eternia.item.godweapons.tier1.nether.CurseboneBowItem;
import dev.prangellplays.eternia.item.godweapons.tier1.nether.CursedArrowItem;
import dev.prangellplays.eternia.item.godweapons.tier1.savanah.GaleSpearItem;
import dev.prangellplays.eternia.item.godweapons.tier1.savanah.PiranhaBladeItem;
import dev.prangellplays.eternia.item.godweapons.tier1.savanah.RootSlicerItem;
import dev.prangellplays.eternia.item.godweapons.tier1.taiga.FrostboundShieldItem;
import dev.prangellplays.eternia.item.godweapons.tier1.taiga.FrostedScytheItem;
import dev.prangellplays.eternia.item.godweapons.tier1.taiga.GlacialDaggerItem;
import dev.prangellplays.eternia.item.item.upgrade.EnderReactorCoreItem;
import dev.prangellplays.eternia.item.item.upgrade.EnderStarItem;
import dev.prangellplays.eternia.item.item.upgrade.NetherReactorCoreItem;
import dev.prangellplays.eternia.item.util.EterniaArmourMaterials;
import dev.prangellplays.eternia.item.util.EterniaToolMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class EterniaItems {
    //GOD WEAPONS
    //Tier 1
    //Jungle
    public static final Item VINE_WHIP = registerItem("vine_whip", new VineWhipItem(EterniaToolMaterials.VINE_WHIP, 7, -2.3f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item NATURES_UNDERGROWTH = registerItem("natures_undergrowth", new NaturesUndergrowthItem(EterniaToolMaterials.NATURES_UNDERGROWTH, 3, 0, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item PHOENIX_CLAWS = registerItem("phoenix_claws_sword", new PhoenixClawsSwordItem(EterniaToolMaterials.PHOENIX_CLAWS, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item PHOENIX_CLAWS_SHOVEL = registerItem("phoenix_claws_shovel", new PhoenixClawsShovelItem(EterniaToolMaterials.PHOENIX_CLAWS, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Desert
    public static final Item PHARAOHS_STAFF = registerItem("pharaohs_staff", new PharaohsStaffItem(new FabricItemSettings().fireproof().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item DESERTED_EXCALIBUR = registerItem("deserted_excalibur", new DesertedExcaliburItem(EterniaToolMaterials.DESERTED_EXCALIBUR, 8, -2.7f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Dark Oak Forest
    public static final Item WITHERS_EDGE_GLAIVE = registerItem("withers_edge_glaive", new WithersEdgeGlaiveItem(EterniaToolMaterials.WITHERS_EDGE_GLAIVE, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Taiga
    public static final Item FROSTED_SCYTHE = registerItem("frosted_scythe", new FrostedScytheItem(EterniaToolMaterials.FROSTED_SCYTHE, 9, -3.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item GLACIAL_DAGGER = registerItem("glacial_dagger", new GlacialDaggerItem(EterniaToolMaterials.GLACIAL_DAGGER, 5, -2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item FROSTBOUND_SHIELD = registerItem("frostbound_shield", new FrostboundShieldItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));

    //Savannah
    public static final Item PIRANHA_BLADE = registerItem("piranha_blade", new PiranhaBladeItem(EterniaToolMaterials.PIRANHA_BLADE, 6, -2.5f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item GALE_SPEAR = registerItem("gale_spear", new GaleSpearItem(EterniaToolMaterials.GALE_SPEAR, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item GALE_SPHERE = registerItem("gale_sphere", new GaleSphereItem(new FabricItemSettings().maxCount(1)));
    public static final Item ROOT_SLICER = registerItem("root_slicer", new RootSlicerItem(EterniaToolMaterials.ROOT_SLICER, 6, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Mesa
    public static final Item FLAMING_SCYTHE = registerItem("flaming_scythe", new FlamingScytheItem(EterniaToolMaterials.FLAMING_SCYTHE, 9, -3.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Mushroom
    public static final Item FUNGAL_GAUNTLET = registerItem("fungal_gauntlet", new FungalGauntletItem(EterniaToolMaterials.FUNGAL_GAUNTLET, 6, -2.1f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Plains
    public static final Item WINDWALKER_BLADE = registerItem("windwalker_blade", new WindwalkerBladeItem(EterniaToolMaterials.WINDWALKER_BLADE, 8, -2.3f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item DRIPSTONE_DAGGER = registerItem("dripstone_dagger", new DripstoneDaggerItem(EterniaToolMaterials.DRIPSTONE_DAGGER, 4, -2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item BRANCHED_AXE_SWORD = registerItem("branched_axe_sword", new BranchedAxeSwordItem(EterniaToolMaterials.BRANCHED_AXE, 11, -3.4f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item BRANCHED_AXE = registerItem("branched_axe", new BranchedAxeItem(EterniaToolMaterials.BRANCHED_AXE, 11, -3.4f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Nether
    public static final Item CURSEBONE_BOW = registerItem("cursebone_bow", new CurseboneBowItem(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item CURSED_ARROW = registerItem("cursed_arrow", new CursedArrowItem(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //End
    public static final Item CELESTIAL_SPEAR = registerItem("celestial_spear", new CelestialSpearItem(EterniaToolMaterials.CELESTIAL_SPEAR, 8, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));



    //Tier 2
    //Jungle
    public static final Item PHOENIX_SWORD = registerItem("phoenix_sword", new PhoenixSwordItem(EterniaToolMaterials.PHOENIX_SWORD, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));


    //Desert


    //Dark Oak Forest


    //Taiga


    //Savannah


    //Mesa


    //Mushroom
    public static final Item GIANT_SWORD = registerItem("giant_sword", new GiantSword(EterniaToolMaterials.GIANT_SWORD, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Plains


    //Nether


    //End




    //Tier 3
    //Jungle
    public static final Item PHOENIX_BLADE = registerItem("phoenix_blade", new PhoenixBladeItem(EterniaToolMaterials.PHOENIX_BLADE, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Desert


    //Dark Oak Forest


    //Taiga


    //Savannah


    //Mesa


    //Mushroom


    //Plains


    //Nether


    //End




    //Event
    public static final Item SOULSTEALER = registerItem("soulstealer", new SoulstealerItem(EterniaToolMaterials.SOULSTEALER, 9, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item ENDER_BLADE = registerItem("ender_blade", new EnderBladeItem(EterniaToolMaterials.ENDERBLADE, 9, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item KINGS_CROWN = registerItem("kings_crown", new TheKingsCrownItem(EterniaArmourMaterials.KINGS_CROWN, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof().maxCount(1), List.of(TheKingsCrownItem.Customizations.KINGS_CROWN)));
    public static final Item ELEMENTAL_CONVERGENCE = registerItem("elemental_convergence", new TheElementalConvergenceItem(EterniaToolMaterials.ELEMENTAL_CONERGENCE, 11, -2.1f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));



    //Items
    public static final Item VILLAGER_SPAWN = registerItem("villager_spawn", new VillagerSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item CHICKEN_SPAWN = registerItem("chicken_spawn", new ChickenSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item COW_SPAWN = registerItem("cow_spawn", new CowSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item SHEEP_SPAWN = registerItem("sheep_spawn", new SheepSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item PIG_SPAWN = registerItem("pig_spawn", new PigSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item HORSE_SPAWN = registerItem("horse_spawn", new HorseSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item COIN = registerItem("coin", new CoinItem(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));
    public static final Item ENDER_STAR = registerItem("ender_star", new EnderStarItem(new FabricItemSettings().fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item NETHER_REACTOR_CORE = registerItem("nether_reactor_core", new NetherReactorCoreItem(new FabricItemSettings().fireproof()));
    public static final Item ENDER_REACTOR_CORE = registerItem("ender_reactor_core", new EnderReactorCoreItem(new FabricItemSettings().fireproof()));
    public static final Item BONE_MEALER = registerItem("bone_mealer", new BoneMealerItem(new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item COOKED_CARROT = registerItem("cooked_carrot", new Item(new FabricItemSettings().food(EterniaFoodComponents.COOKED_CARROT)));
    public static final Item SHULKER_DUST = registerItem("shulker_dust", new ShulkerDustItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new FabricItemSettings().rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Eternia.MOD_ID, name), item);
    }

    public static void init() {
        Eternia.LOGGER.info("Registering Mod Items for " + Eternia.MOD_ID);
    }
}
