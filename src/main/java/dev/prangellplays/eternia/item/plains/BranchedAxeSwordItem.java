package dev.prangellplays.eternia.item.plains;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class BranchedAxeSwordItem extends SwordItem {
    public BranchedAxeSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof PlayerEntity player)) {
            if (player.getEquippedStack(EquipmentSlot.MAINHAND).isOf(EterniaItems.BRANCHED_AXE_SWORD)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2, 0, false, false, false));
            } else {
                return;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random roll = new Random();
        if (attacker instanceof PlayerEntity player) {
            if (roll.nextDouble() < 0.34D && !player.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 600, 3, false, false, true), attacker);
                target.addStatusEffect(new StatusEffectInstance(Eternia.SLAMMED, 100, 1, false, false, true), attacker);
                player.getItemCooldownManager().set(this, 400);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            user.setStackInHand(hand, EterniaItems.BRANCHED_AXE.getDefaultStack());
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            tooltip.add(Text.translatable("tooltip.eternia.branched_axe_sword.swap").formatted(Formatting.GREEN));
        }
    }
}
