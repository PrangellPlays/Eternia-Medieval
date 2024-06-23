package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.enchantment.CursedEnchantment;
import dev.prangellplays.eternia.enchantment.PhoenixEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EterniaEnchantments {
    public static final Enchantment CURSED = register("cursed", new CursedEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final Enchantment PHOENIX = register("phoenix", new PhoenixEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(Eternia.MOD_ID, name), enchantment);
    }

    public static void init() {
        Eternia.LOGGER.info("Registering ModEnchantments for " + Eternia.MOD_ID);
    }
}
