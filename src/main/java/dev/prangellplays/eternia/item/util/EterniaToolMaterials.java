package dev.prangellplays.eternia.item.util;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum EterniaToolMaterials implements ToolMaterial {
    //Tier 1
    VINE_WHIP(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    NATURES_UNDERGROWTH(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    PHOENIX_CLAWS(5, 0, 12.0f, 0, 0,() -> Ingredient.ofItems(Items.AIR)),
    DESERTED_EXCALIBUR(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    WITHERS_EDGE_GLAIVE(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    FROSTED_SCYTHE(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    GLACIAL_DAGGER(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    PIRANHA_BLADE(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    GALE_SPEAR(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    ROOT_SLICER(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    FLAMING_SCYTHE(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    FUNGAL_GAUNTLET(5, 0, 6.5f, 0, 26, () -> Ingredient.ofItems(Items.AIR)),
    WINDWALKER_BLADE(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    DRIPSTONE_DAGGER(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    BRANCHED_AXE(5, 0, 50f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    CELESTIAL_SPEAR(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),

    //Tier 2
    PHOENIX_SWORD(5, 0, 12.0f, 0, 0,() -> Ingredient.ofItems(Items.AIR)),
    GIANT_SWORD(5, 0, 12.0f, 0, 0,() -> Ingredient.ofItems(Items.AIR)),

    //Tier 3
    PHOENIX_BLADE(5, 0, 12.0f, 0, 0,() -> Ingredient.ofItems(Items.AIR)),

    //Event
    SOULSTEALER(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    ENDERBLADE(5, 0, 6.5f, 0, 26,() -> Ingredient.ofItems(Items.AIR)),
    ELEMENTAL_CONERGENCE(5, 0, 6.5f, 0, 26, () -> Ingredient.ofItems(Items.AIR));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    EterniaToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
