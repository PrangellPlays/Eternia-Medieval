package dev.prangellplays.eternia.utils;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static Map<BlockPos, ItemStack> pedestals = new HashMap<BlockPos, ItemStack>();
    public static BlockPos lastOpened = null;
    public static ItemStack lastItemStack = null;

    public static ItemStack getMostCommonItemStack(Inventory inventory){
        ItemStack displayStack = new ItemStack(Items.AIR);
        int itemCount = 0;

        if(inventory.isEmpty()) return displayStack;

        for (int i = 0; i<inventory.size(); i++) {
            ItemStack itemStack = inventory.getStack(i);
            if(!itemStack.isEmpty()){
                if(itemCount < inventory.count(itemStack.getItem())){
                    displayStack = itemStack;
                    itemCount = inventory.count(itemStack.getItem());
                }
            }
        }

        return displayStack;
    }
}