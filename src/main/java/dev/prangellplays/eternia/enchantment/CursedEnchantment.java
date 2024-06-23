package dev.prangellplays.eternia.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.EquipmentSlot;

public class CursedEnchantment extends Enchantment {
    public CursedEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    public int getMinPower(int level) {
        return 1;
    }

    public int getMaxPower(int level) {
        return 1;
    }

    public boolean canAccept(Enchantment other) {
        return other instanceof InfinityEnchantment ? false : super.canAccept(other);
    }

    public boolean isTreasure() {
        return true;
    }

    public boolean isCursed() {
        return true;
    }
}
