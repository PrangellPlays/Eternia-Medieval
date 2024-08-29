package dev.prangellplays.eternia.item.godweapons.event;

import dev.prangellplays.eternia.Eternia;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class EnderBladeItem extends SwordItem {
    public EnderBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        Vec3d startPos = player.getEyePos();
        Vec3d endPos = startPos.add(player.getRotationVector().multiply(10));
        BlockHitResult hitResult = world.raycast(new RaycastContext(startPos, endPos, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));
        player.getItemCooldownManager().set(this, 120);
        if(world.getBlockState(hitResult.getBlockPos().up(1)).isAir())
            world.getBlockState(hitResult.getBlockPos().up(1)).getBlock(); {
            player.teleport(hitResult.getBlockPos().getX()+0.5, hitResult.getBlockPos().getY() + 1, hitResult.getBlockPos().getZ()+0.5);
            world.playSound(player, player.getBlockPos(), SoundEvent.of(SoundEvents.ENTITY_SHULKER_TELEPORT.getId()), SoundCategory.MASTER);
            player.addStatusEffect(new StatusEffectInstance(Eternia.ENDER, 30, 0, false, false), player);
            return TypedActionResult.success(player.getStackInHand(hand));
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
