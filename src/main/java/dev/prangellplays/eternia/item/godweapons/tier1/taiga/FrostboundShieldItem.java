package dev.prangellplays.eternia.item.godweapons.tier1.taiga;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class FrostboundShieldItem extends ShieldItem {
    private static final UUID MODIIFER_UUID = UUID.fromString("8b128327-f878-4e94-ada2-707cd81b13af");
    private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;

    public FrostboundShieldItem(Settings settings) {
        super(settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(FrostboundShieldItem.MODIIFER_UUID, "Shield modifier", 0.1d, EntityAttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.OFFHAND) {
            return this.defaultModifiers;
        }
        if (slot == EquipmentSlot.MAINHAND) {
            return this.defaultModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        {
            stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);
            tooltip.add(Text.translatable("tooltip.eternia.frostbound_shield.l1").formatted(Formatting.AQUA));
            tooltip.add(Text.translatable("tooltip.eternia.frostbound_shield.l2").formatted(Formatting.AQUA));
            tooltip.add(Text.literal(" ").formatted(Formatting.RESET));
            tooltip.add(Text.translatable("tooltip.eternia.frostbound_shield.slot_use").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("tooltip.eternia.frostbound_shield.ability").formatted(Formatting.DARK_GREEN));
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
