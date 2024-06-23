package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.item.GodItem.TheElementalConvergenceItem;
import dev.prangellplays.eternia.item.darkoakforest.WithersEdgeGlaiveItem;
import dev.prangellplays.eternia.item.desert.DesertedExcaliburItem;
import dev.prangellplays.eternia.item.desert.PharaohsStaffItem;
import dev.prangellplays.eternia.item.end.CelestialSpearItem;
import dev.prangellplays.eternia.item.item.CoinItem;
import dev.prangellplays.eternia.item.plains.BranchedAxeItem;
import dev.prangellplays.eternia.item.plains.BranchedAxeSwordItem;
import dev.prangellplays.eternia.item.plains.DripstoneDaggerItem;
import dev.prangellplays.eternia.item.plains.WindwalkerBladeItem;
import dev.prangellplays.eternia.item.savanah.GaleSphereItem;
import dev.prangellplays.eternia.item.item.spawn.*;
import dev.prangellplays.eternia.item.jungle.NaturesUndergrowthItem;
import dev.prangellplays.eternia.item.jungle.PhoenixClawsShovelItem;
import dev.prangellplays.eternia.item.jungle.PhoenixClawsSwordItem;
import dev.prangellplays.eternia.item.jungle.VineWhipItem;
import dev.prangellplays.eternia.item.mesa.FlamingScytheItem;
import dev.prangellplays.eternia.item.mushroom.FungalGauntletItem;
import dev.prangellplays.eternia.item.nether.CurseboneBowItem;
import dev.prangellplays.eternia.item.nether.CursedArrowItem;
import dev.prangellplays.eternia.item.savanah.GaleSpearItem;
import dev.prangellplays.eternia.item.savanah.PiranhaBladeItem;
import dev.prangellplays.eternia.item.savanah.RootSlicerItem;
import dev.prangellplays.eternia.item.taiga.FrostboundShieldItem;
import dev.prangellplays.eternia.item.taiga.FrostedScytheItem;
import dev.prangellplays.eternia.item.taiga.GlacialDaggerItem;
import dev.prangellplays.eternia.item.util.EterniaToolMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class EterniaItems {

    //GOD WEAPONS
    //Jungle
    public static final Item VINE_WHIP = registerItem("vine_whip", new VineWhipItem(EterniaToolMaterials.VINE_WHIP, 7, -2.3f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item NATURES_UNDERGROWTH = registerItem("natures_undergrowth", new NaturesUndergrowthItem(EterniaToolMaterials.NATURES_UNDERGROWTH, 3, 0, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item PHOENIX_CLAWS = registerItem("phoenix_claws_sword", new PhoenixClawsSwordItem(EterniaToolMaterials.PHOENIX_CLAWS, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
    public static final Item PHOENIX_CLAWS_SHOVEL = registerItem("phoenix_claws_shovel", new PhoenixClawsShovelItem(EterniaToolMaterials.PHOENIX_CLAWS, 7, -2.2f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Desert
    public static final Item PHARAOHS_STAFF = registerItem("pharaohs_staff", new PharaohsStaffItem(new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));
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

    //GOD ITEMS
    public static final Item ELEMENTAL_CONVERGENCE = registerItem("elemental_convergence", new TheElementalConvergenceItem(EterniaToolMaterials.ELEMENTAL_CONERGENCE, 11, -2.1f, new FabricItemSettings().fireproof().rarity(Rarity.EPIC)));

    //Items
    public static final Item VILLAGER_SPAWN = registerItem("villager_spawn", new VillagerSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item CHICKEN_SPAWN = registerItem("chicken_spawn", new ChickenSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item COW_SPAWN = registerItem("cow_spawn", new CowSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item SHEEP_SPAWN = registerItem("sheep_spawn", new SheepSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item PIG_SPAWN = registerItem("pig_spawn", new PigSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item HORSE_SPAWN = registerItem("horse_spawn", new HorseSpawnItem(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item COIN = registerItem("coin", new CoinItem(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Eternia.MOD_ID, name), item);
    }

    public static void init() {
        Eternia.LOGGER.info("Registering Mod Items for " + Eternia.MOD_ID);
    }
}
