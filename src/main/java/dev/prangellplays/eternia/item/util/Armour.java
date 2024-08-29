package dev.prangellplays.eternia.item.util;

import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.item.ItemConvertible;

public enum Armour {

    KINGS_CROWN("kings_crown", false, true, false, EterniaItems.KINGS_CROWN);

    private final String name;
    private final ItemConvertible[] items;
    private final boolean hasVanillaArmorModel;
    private final boolean hasKingsCrown;
    private final boolean dyeable;

    Armour(String name, boolean hasVanillaArmorModel, boolean hasKingsCrown, boolean dyeable, ItemConvertible... items) {
        this.name = name;
        this.hasVanillaArmorModel = hasVanillaArmorModel;
        this.hasKingsCrown = hasKingsCrown;
        this.dyeable = dyeable;
        this.items = items;
    }

    public String getSimpleName() {
        return this.name;
    }

    public ItemConvertible[] getItems(){
        return this.items;
    }

    public boolean hasVanillaArmorModel() {
        return hasVanillaArmorModel;
    }

    public boolean hasKingsCrown(){
        return this.hasKingsCrown;
    }

    public boolean isDyeable(){
        return this.dyeable;
    }
}
