package dev.prangellplays.eternia.item.item.upgrade;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnderStarItem extends Item {
    public EnderStarItem(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
