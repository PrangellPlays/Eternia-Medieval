package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.item.GodItem.TheKingsCrownItem;
import dev.prangellplays.eternia.item.util.EterniaArmourMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class EterniaArmour {
    public static final Item KINGS_CROWN = registerItem("kings_crown", new TheKingsCrownItem(EterniaArmourMaterials.KINGS_CROWN, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof().maxCount(1), List.of(TheKingsCrownItem.Customizations.KINGS_CROWN)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Eternia.MOD_ID, name), item);
    }

    private static Item registerGeneratedItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Eternia.MOD_ID, name), item);
    }

    public static void init() {
        Eternia.LOGGER.info("Registering Armour for " + Eternia.MOD_ID);
    }
}
