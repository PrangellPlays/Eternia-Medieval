package dev.prangellplays.eternia.item.godweapons.event;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dev.prangellplays.eternia.item.util.EterniaArmourMaterials;
import dev.prangellplays.eternia.registry.EterniaItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class TheKingsCrownItem extends ArmorItem implements Equipment {

    private EterniaArmourMaterials material;
    private List<Customizations> customsList;
    public static final UUID MAX_HEALTH_MODIFIER_ID = UUID.fromString("d62908f0-cca1-409d-a3a0-06bbea84bfa2");
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public TheKingsCrownItem(EterniaArmourMaterials material, Type type, Settings settings, List<Customizations> customsList) {
        super(material, type, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(MAX_HEALTH_MODIFIER_ID, "Armour modifier", 30, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
        this.material = material;
        this.customsList = customsList;
    }

    public TheKingsCrownItem(EterniaArmourMaterials material, Type type, Settings settings, Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers) {
        super(material, type, settings);
        this.material = material;
        this.attributeModifiers = attributeModifiers;
        this.customsList = null;
    }
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return this.equipAndSwap(this, world, user, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getEquippedStack(EquipmentSlot.HEAD).isOf(EterniaItems.KINGS_CROWN)) {
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 0, false, false, false));
            ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0, false, false, false));
        }
        else {
            return;
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        stack.addHideFlag(ItemStack.TooltipSection.MODIFIERS);
        stack.addHideFlag(ItemStack.TooltipSection.ENCHANTMENTS);
    }

    public enum Customizations{
        KINGS_CROWN("kings_crown");

        public final String name;
        Customizations(String name){
            this.name = name;
        }
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.HEAD ? attributeModifiers : super.getAttributeModifiers(slot);
    }
}