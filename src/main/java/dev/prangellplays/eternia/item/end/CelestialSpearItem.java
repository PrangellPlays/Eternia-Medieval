package dev.prangellplays.eternia.item.end;

import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class CelestialSpearItem extends SwordItem {
    public CelestialSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient && user instanceof ServerPlayerEntity && !user.isSneaking()) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.NEUTRAL, 0.5F, 0.8F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) user;
            if (serverPlayerEntity.getItemCooldownManager().isCoolingDown(this)) {
                return TypedActionResult.fail(itemStack);
            }

            DragonFireballEntity dragonFireballEntity = new DragonFireballEntity(world, user, 0, 0, 0) {
                @Override
                public void tick() {
                    super.tick();
                    if (this.age >= 1000) {
                        this.remove(RemovalReason.DISCARDED);
                    }
                }

                @Override
                protected void onCollision(HitResult hitResult) {
                    super.onCollision(hitResult);
                    this.remove(RemovalReason.DISCARDED);
                }
            };
            dragonFireballEntity.setPosition(user.getX(), user.getEyeY() - 0.2, user.getZ());
            dragonFireballEntity.setVelocity(user.getRotationVector().multiply(3));
            world.spawnEntity(dragonFireballEntity);

            user.getItemCooldownManager().set(this, 100);
        } else if (user.isSneaking() && !user.getItemCooldownManager().isCoolingDown(this)) {
            //ROW 1
            BlockPos pos1 = new BlockPos(2936, 81, 745);
            BlockPos pos2 = new BlockPos(2937, 81, 745);
            BlockPos pos3 = new BlockPos(2938, 81, 745);

            //ROW 2
            BlockPos pos4 = new BlockPos(2936, 81, 746);
            BlockPos pos5 = new BlockPos(2937, 81, 746);
            BlockPos pos6 = new BlockPos(2938, 81, 746);

            //ROW 3
            BlockPos pos7 = new BlockPos(2936, 81, 747);
            BlockPos pos8 = new BlockPos(2937, 81, 747);
            BlockPos pos9 = new BlockPos(2938, 81, 747);
            if (world.getBlockState(pos5).isOf(Blocks.AIR)) {
                world.setBlockState(pos1, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos2, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos3, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos4, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos5, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos6, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos7, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos8, Blocks.END_PORTAL.getDefaultState());
                world.setBlockState(pos9, Blocks.END_PORTAL.getDefaultState());
                if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                    serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("The End Has Opened").formatted(Formatting.BLUE).formatted(Formatting.UNDERLINE)));
                }
                world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.MASTER, 100.0F, (1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
                user.getItemCooldownManager().set(this, 100);
            } else if (world.getBlockState(pos5).isOf(Blocks.END_PORTAL) && !user.getItemCooldownManager().isCoolingDown(this)) {
                world.setBlockState(pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(pos9, Blocks.AIR.getDefaultState());
                if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                    serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("The End Has Locked").formatted(Formatting.BLUE).formatted(Formatting.UNDERLINE)));
                }
                world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 100.0F, (-1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
                user.getItemCooldownManager().set(this, 100);
            }
        }

        return TypedActionResult.success(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eternia.celestial_spear.how").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.eternia.celestial_spear.l1").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.eternia.celestial_spear.l2").formatted(Formatting.BLUE));
    }

    private BlockPos getDefaultState(BlockPos pos) {
        return pos;
    }
}
