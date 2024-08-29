package dev.prangellplays.eternia.item.godweapons.tier1.nether;

import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class CurseboneBowItem extends BowItem {
    public static final int TICKS_PER_SECOND = 20;
    public static final int RANGE = 15;
    public static final Predicate<ItemStack> CURSEBONE_BOW_PROJECTILES = (stack) -> {
        return stack.isOf(EterniaItems.CURSED_ARROW.asItem());
    };

    public CurseboneBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        boolean bl2;
        int i;
        float f;
        if (!(user instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity playerEntity = (PlayerEntity)user;
        boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
        ItemStack itemStack = playerEntity.getProjectileType(stack);
        if (itemStack.isEmpty() && !bl) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(EterniaItems.CURSED_ARROW);
        }
        if ((double)(f = BowItem.getPullProgress(i = this.getMaxUseTime(stack) - remainingUseTicks)) < 0.1) {
            return;
        }
        boolean bl3 = bl2 = bl && itemStack.isOf(EterniaItems.CURSED_ARROW);
        if (!world.isClient && !user.isSneaking()) {
            CursedArrowItem arrowItem = (CursedArrowItem) (itemStack.getItem() instanceof CursedArrowItem ? itemStack.getItem() : EterniaItems.CURSED_ARROW);
            PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, itemStack, playerEntity);
            persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 3.0F, 1.0F);
            if (f == 1.0F) {
                persistentProjectileEntity.setCritical(true);
            }

            int j = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
            if (j > 0) {
                persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (double)j * 0.5 + 0.5);
            }

            int k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
            if (k > 0) {
                persistentProjectileEntity.setPunch(k);
            }

            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                persistentProjectileEntity.setOnFireFor(100);
            }

            stack.damage(1, playerEntity, (p) -> {
                p.sendToolBreakStatus(playerEntity.getActiveHand());
            });
            if (bl2 || !playerEntity.getAbilities().creativeMode && itemStack.isOf(EterniaItems.CURSED_ARROW)) {
                persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }

            world.spawnEntity(persistentProjectileEntity);
        } else if (user.isSneaking() && !((PlayerEntity) user).getItemCooldownManager().isCoolingDown(this)) {
            //COLUMN 1
            BlockPos c1pos1 = new BlockPos(-3333, 99, 2766);
            BlockPos c1pos2 = new BlockPos(-3333, 100, 2766);
            BlockPos c1pos3 = new BlockPos(-3333, 101, 2766);
            BlockPos c1pos4 = new BlockPos(-3333, 102, 2766);
            BlockPos c1pos5 = new BlockPos(-3333, 103, 2766);
            BlockPos c1pos6 = new BlockPos(-3333, 104, 2766);
            BlockPos c1pos7 = new BlockPos(-3333, 105, 2766);
            BlockPos c1pos8 = new BlockPos(-3333, 106, 2766);
            BlockPos c1pos9 = new BlockPos(-3333, 107, 2766);
            BlockPos c1pos10 = new BlockPos(-3333, 108, 2766);


            //COLUMN 2
            BlockPos c2pos1 = new BlockPos(-3334, 99, 2766);
            BlockPos c2pos2 = new BlockPos(-3334, 100, 2766);
            BlockPos c2pos3 = new BlockPos(-3334, 101, 2766);
            BlockPos c2pos4 = new BlockPos(-3334, 102, 2766);
            BlockPos c2pos5 = new BlockPos(-3334, 103, 2766);
            BlockPos c2pos6 = new BlockPos(-3334, 104, 2766);
            BlockPos c2pos7 = new BlockPos(-3334, 105, 2766);
            BlockPos c2pos8 = new BlockPos(-3334, 106, 2766);
            BlockPos c2pos9 = new BlockPos(-3334, 107, 2766);
            BlockPos c2pos10 = new BlockPos(-3334, 108, 2766);

            //COLUMN 3
            BlockPos c3pos1 = new BlockPos(-3335, 99, 2766);
            BlockPos c3pos2 = new BlockPos(-3335, 100, 2766);
            BlockPos c3pos3 = new BlockPos(-3335, 101, 2766);
            BlockPos c3pos4 = new BlockPos(-3335, 102, 2766);
            BlockPos c3pos5 = new BlockPos(-3335, 103, 2766);
            BlockPos c3pos6 = new BlockPos(-3335, 104, 2766);
            BlockPos c3pos7 = new BlockPos(-3335, 105, 2766);
            BlockPos c3pos8 = new BlockPos(-3335, 106, 2766);
            BlockPos c3pos9 = new BlockPos(-3335, 107, 2766);
            BlockPos c3pos10 = new BlockPos(-3335, 108, 2766);

            //COLUMN 4
            BlockPos c4pos1 = new BlockPos(-3336, 99, 2766);
            BlockPos c4pos2 = new BlockPos(-3336, 100, 2766);
            BlockPos c4pos3 = new BlockPos(-3336, 101, 2766);
            BlockPos c4pos4 = new BlockPos(-3336, 102, 2766);
            BlockPos c4pos5 = new BlockPos(-3336, 103, 2766);
            BlockPos c4pos6 = new BlockPos(-3336, 104, 2766);
            BlockPos c4pos7 = new BlockPos(-3336, 105, 2766);
            BlockPos c4pos8 = new BlockPos(-3336, 106, 2766);
            BlockPos c4pos9 = new BlockPos(-3336, 107, 2766);
            BlockPos c4pos10 = new BlockPos(-3336, 108, 2766);

            //COLUMN 5
            BlockPos c5pos1 = new BlockPos(-3337, 99, 2766);
            BlockPos c5pos2 = new BlockPos(-3337, 100, 2766);
            BlockPos c5pos3 = new BlockPos(-3337, 101, 2766);
            BlockPos c5pos4 = new BlockPos(-3337, 102, 2766);
            BlockPos c5pos5 = new BlockPos(-3337, 103, 2766);
            BlockPos c5pos6 = new BlockPos(-3337, 104, 2766);
            BlockPos c5pos7 = new BlockPos(-3337, 105, 2766);
            BlockPos c5pos8 = new BlockPos(-3337, 106, 2766);
            BlockPos c5pos9 = new BlockPos(-3337, 107, 2766);
            BlockPos c5pos10 = new BlockPos(-3337, 108, 2766);

            //COLUMN 6
            BlockPos c6pos1 = new BlockPos(-3338, 99, 2766);
            BlockPos c6pos2 = new BlockPos(-3338, 100, 2766);
            BlockPos c6pos3 = new BlockPos(-3338, 101, 2766);
            BlockPos c6pos4 = new BlockPos(-3338, 102, 2766);
            BlockPos c6pos5 = new BlockPos(-3338, 103, 2766);
            BlockPos c6pos6 = new BlockPos(-3338, 104, 2766);
            BlockPos c6pos7 = new BlockPos(-3338, 105, 2766);
            BlockPos c6pos8 = new BlockPos(-3338, 106, 2766);
            BlockPos c6pos9 = new BlockPos(-3338, 107, 2766);
            BlockPos c6pos10 = new BlockPos(-3338, 108, 2766);

            //COLUMN 7
            BlockPos c7pos1 = new BlockPos(-3339, 99, 2766);
            BlockPos c7pos2 = new BlockPos(-3339, 100, 2766);
            BlockPos c7pos3 = new BlockPos(-3339, 101, 2766);
            BlockPos c7pos4 = new BlockPos(-3339, 102, 2766);
            BlockPos c7pos5 = new BlockPos(-3339, 103, 2766);
            BlockPos c7pos6 = new BlockPos(-3339, 104, 2766);
            BlockPos c7pos7 = new BlockPos(-3339, 105, 2766);
            BlockPos c7pos8 = new BlockPos(-3339, 106, 2766);
            BlockPos c7pos9 = new BlockPos(-3339, 107, 2766);
            BlockPos c7pos10 = new BlockPos(-3339, 108, 2766);

            if (world.getBlockState(c4pos6).isOf(Blocks.AIR)) {
                //Column 1
                world.setBlockState(c1pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 2
                world.setBlockState(c2pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 3
                world.setBlockState(c3pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 4
                world.setBlockState(c4pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 5
                world.setBlockState(c5pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 6
                world.setBlockState(c6pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 7
                world.setBlockState(c7pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos10, Blocks.NETHER_PORTAL.getDefaultState());

                if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                    serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("The Nether Has Opened").formatted(Formatting.DARK_RED).formatted(Formatting.UNDERLINE)));
                }
                world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_PORTAL_TRIGGER, SoundCategory.MASTER, 100.0F, (1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
                ((PlayerEntity) user).getItemCooldownManager().set(this, 100);
            } else if (world.getBlockState(c4pos6).isOf(Blocks.NETHER_PORTAL) && !((PlayerEntity) user).getItemCooldownManager().isCoolingDown(this)) {
                //Column 1
                world.setBlockState(c1pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos10, Blocks.AIR.getDefaultState());

                //Column 2
                world.setBlockState(c2pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos10, Blocks.AIR.getDefaultState());

                //Column 3
                world.setBlockState(c3pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos10, Blocks.AIR.getDefaultState());

                //Column 4
                world.setBlockState(c4pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos10, Blocks.AIR.getDefaultState());

                //Column 5
                world.setBlockState(c5pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos10, Blocks.AIR.getDefaultState());

                //Column 6
                world.setBlockState(c6pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos10, Blocks.AIR.getDefaultState());

                //Column 7
                world.setBlockState(c7pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos10, Blocks.AIR.getDefaultState());

                if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                    serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("The Nether Has Locked").formatted(Formatting.DARK_RED).formatted(Formatting.UNDERLINE)));
                }
                world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 100.0F, (-1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
                ((PlayerEntity) user).getItemCooldownManager().set(this, 100);
            }
        }

        world.playSound((PlayerEntity)null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
    }

    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        boolean bl;
        ItemStack itemStack = user.getStackInHand(hand);
        boolean bl2 = bl = !user.getProjectileType(itemStack).isEmpty();
        if (user.getAbilities().creativeMode || bl && !user.isSneaking()) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        } else if (user.isSneaking() && !user.getItemCooldownManager().isCoolingDown(this)) {
            //COLUMN 1
            BlockPos c1pos1 = new BlockPos(-3333, 99, 2766);
            BlockPos c1pos2 = new BlockPos(-3333, 100, 2766);
            BlockPos c1pos3 = new BlockPos(-3333, 101, 2766);
            BlockPos c1pos4 = new BlockPos(-3333, 102, 2766);
            BlockPos c1pos5 = new BlockPos(-3333, 103, 2766);
            BlockPos c1pos6 = new BlockPos(-3333, 104, 2766);
            BlockPos c1pos7 = new BlockPos(-3333, 105, 2766);
            BlockPos c1pos8 = new BlockPos(-3333, 106, 2766);
            BlockPos c1pos9 = new BlockPos(-3333, 107, 2766);
            BlockPos c1pos10 = new BlockPos(-3333, 108, 2766);


            //COLUMN 2
            BlockPos c2pos1 = new BlockPos(-3334, 99, 2766);
            BlockPos c2pos2 = new BlockPos(-3334, 100, 2766);
            BlockPos c2pos3 = new BlockPos(-3334, 101, 2766);
            BlockPos c2pos4 = new BlockPos(-3334, 102, 2766);
            BlockPos c2pos5 = new BlockPos(-3334, 103, 2766);
            BlockPos c2pos6 = new BlockPos(-3334, 104, 2766);
            BlockPos c2pos7 = new BlockPos(-3334, 105, 2766);
            BlockPos c2pos8 = new BlockPos(-3334, 106, 2766);
            BlockPos c2pos9 = new BlockPos(-3334, 107, 2766);
            BlockPos c2pos10 = new BlockPos(-3334, 108, 2766);

            //COLUMN 3
            BlockPos c3pos1 = new BlockPos(-3335, 99, 2766);
            BlockPos c3pos2 = new BlockPos(-3335, 100, 2766);
            BlockPos c3pos3 = new BlockPos(-3335, 101, 2766);
            BlockPos c3pos4 = new BlockPos(-3335, 102, 2766);
            BlockPos c3pos5 = new BlockPos(-3335, 103, 2766);
            BlockPos c3pos6 = new BlockPos(-3335, 104, 2766);
            BlockPos c3pos7 = new BlockPos(-3335, 105, 2766);
            BlockPos c3pos8 = new BlockPos(-3335, 106, 2766);
            BlockPos c3pos9 = new BlockPos(-3335, 107, 2766);
            BlockPos c3pos10 = new BlockPos(-3335, 108, 2766);

            //COLUMN 4
            BlockPos c4pos1 = new BlockPos(-3336, 99, 2766);
            BlockPos c4pos2 = new BlockPos(-3336, 100, 2766);
            BlockPos c4pos3 = new BlockPos(-3336, 101, 2766);
            BlockPos c4pos4 = new BlockPos(-3336, 102, 2766);
            BlockPos c4pos5 = new BlockPos(-3336, 103, 2766);
            BlockPos c4pos6 = new BlockPos(-3336, 104, 2766);
            BlockPos c4pos7 = new BlockPos(-3336, 105, 2766);
            BlockPos c4pos8 = new BlockPos(-3336, 106, 2766);
            BlockPos c4pos9 = new BlockPos(-3336, 107, 2766);
            BlockPos c4pos10 = new BlockPos(-3336, 108, 2766);

            //COLUMN 5
            BlockPos c5pos1 = new BlockPos(-3337, 99, 2766);
            BlockPos c5pos2 = new BlockPos(-3337, 100, 2766);
            BlockPos c5pos3 = new BlockPos(-3337, 101, 2766);
            BlockPos c5pos4 = new BlockPos(-3337, 102, 2766);
            BlockPos c5pos5 = new BlockPos(-3337, 103, 2766);
            BlockPos c5pos6 = new BlockPos(-3337, 104, 2766);
            BlockPos c5pos7 = new BlockPos(-3337, 105, 2766);
            BlockPos c5pos8 = new BlockPos(-3337, 106, 2766);
            BlockPos c5pos9 = new BlockPos(-3337, 107, 2766);
            BlockPos c5pos10 = new BlockPos(-3337, 108, 2766);

            //COLUMN 6
            BlockPos c6pos1 = new BlockPos(-3338, 99, 2766);
            BlockPos c6pos2 = new BlockPos(-3338, 100, 2766);
            BlockPos c6pos3 = new BlockPos(-3338, 101, 2766);
            BlockPos c6pos4 = new BlockPos(-3338, 102, 2766);
            BlockPos c6pos5 = new BlockPos(-3338, 103, 2766);
            BlockPos c6pos6 = new BlockPos(-3338, 104, 2766);
            BlockPos c6pos7 = new BlockPos(-3338, 105, 2766);
            BlockPos c6pos8 = new BlockPos(-3338, 106, 2766);
            BlockPos c6pos9 = new BlockPos(-3338, 107, 2766);
            BlockPos c6pos10 = new BlockPos(-3338, 108, 2766);

            //COLUMN 7
            BlockPos c7pos1 = new BlockPos(-3339, 99, 2766);
            BlockPos c7pos2 = new BlockPos(-3339, 100, 2766);
            BlockPos c7pos3 = new BlockPos(-3339, 101, 2766);
            BlockPos c7pos4 = new BlockPos(-3339, 102, 2766);
            BlockPos c7pos5 = new BlockPos(-3339, 103, 2766);
            BlockPos c7pos6 = new BlockPos(-3339, 104, 2766);
            BlockPos c7pos7 = new BlockPos(-3339, 105, 2766);
            BlockPos c7pos8 = new BlockPos(-3339, 106, 2766);
            BlockPos c7pos9 = new BlockPos(-3339, 107, 2766);
            BlockPos c7pos10 = new BlockPos(-3339, 108, 2766);

            if (world.getBlockState(c4pos6).isOf(Blocks.AIR)) {
                //Column 1
                world.setBlockState(c1pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c1pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 2
                world.setBlockState(c2pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c2pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 3
                world.setBlockState(c3pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c3pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 4
                world.setBlockState(c4pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c4pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 5
                world.setBlockState(c5pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c5pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 6
                world.setBlockState(c6pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c6pos10, Blocks.NETHER_PORTAL.getDefaultState());

                //Column 7
                world.setBlockState(c7pos1, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos2, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos3, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos4, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos5, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos6, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos7, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos8, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos9, Blocks.NETHER_PORTAL.getDefaultState());
                world.setBlockState(c7pos10, Blocks.NETHER_PORTAL.getDefaultState());

                if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                    serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("The Nether Has Opened").formatted(Formatting.DARK_RED).formatted(Formatting.UNDERLINE)));
                }
                world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.MASTER, 100.0F, (1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
                user.getItemCooldownManager().set(this, 100);
            } else if (world.getBlockState(c4pos6).isOf(Blocks.NETHER_PORTAL) && !user.getItemCooldownManager().isCoolingDown(this)) {
                //Column 1
                world.setBlockState(c1pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c1pos10, Blocks.AIR.getDefaultState());

                //Column 2
                world.setBlockState(c2pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c2pos10, Blocks.AIR.getDefaultState());

                //Column 3
                world.setBlockState(c3pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c3pos10, Blocks.AIR.getDefaultState());

                //Column 4
                world.setBlockState(c4pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c4pos10, Blocks.AIR.getDefaultState());

                //Column 5
                world.setBlockState(c5pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c5pos10, Blocks.AIR.getDefaultState());

                //Column 6
                world.setBlockState(c6pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c6pos10, Blocks.AIR.getDefaultState());

                //Column 7
                world.setBlockState(c7pos1, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos2, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos3, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos4, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos5, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos6, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos7, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos8, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos9, Blocks.AIR.getDefaultState());
                world.setBlockState(c7pos10, Blocks.AIR.getDefaultState());

                if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                    serverPlayerEntity.networkHandler.sendPacket(new TitleS2CPacket(Text.literal("The Nether Has Locked").formatted(Formatting.DARK_RED).formatted(Formatting.UNDERLINE)));
                }
                world.playSound(user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 100.0F, (-1.0F + (new Random().nextFloat() - new Random().nextFloat()) * 0.2F) * 0.7F, false);
                user.getItemCooldownManager().set(this, 100);
            }
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public Predicate<ItemStack> getProjectiles() {
        return CURSEBONE_BOW_PROJECTILES;
    }

    @Override
    public int getRange() {
        return 15;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eternia.cursebone_bow.how").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("tooltip.eternia.cursebone_bow.l1").formatted(Formatting.DARK_RED));
        tooltip.add(Text.translatable("tooltip.eternia.cursebone_bow.l2").formatted(Formatting.DARK_RED));
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
