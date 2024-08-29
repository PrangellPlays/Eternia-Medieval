package dev.prangellplays.eternia.item.godweapons.tier1.savanah;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.entity.projectile.GaleSphereEntity;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GaleSpearItem extends SwordItem {
    public GaleSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.GALE_SPEAR)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2, 0, false, false, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 0, false, false, false));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && !user.getItemCooldownManager().isCoolingDown(this)) {
            GaleSphereEntity entity = new GaleSphereEntity(world, user);
            entity.setItem(EterniaItems.GALE_SPHERE.getDefaultStack());
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F);
            world.spawnEntity(entity);
            user.addStatusEffect(new StatusEffectInstance(Eternia.GALE, 50, 0, false, false), user);
            user.getItemCooldownManager().set(this, 60);
        }
        return super.use(world, user, hand);
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
