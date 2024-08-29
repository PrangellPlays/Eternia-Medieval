package dev.prangellplays.eternia.item.godweapons.event;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class TheElementalConvergenceItem extends SwordItem {
    public TheElementalConvergenceItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
