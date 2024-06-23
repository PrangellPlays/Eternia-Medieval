package dev.prangellplays.eternia.item.nether;

import dev.prangellplays.eternia.entity.projectile.CursedArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CursedArrowItem extends ArrowItem {
    public CursedArrowItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        CursedArrowEntity arrowEntity = new CursedArrowEntity(world, shooter);
        return arrowEntity;
    }
}
