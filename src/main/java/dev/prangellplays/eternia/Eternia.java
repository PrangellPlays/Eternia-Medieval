package dev.prangellplays.eternia;

import com.mojang.brigadier.CommandDispatcher;
import dev.prangellplays.eternia.command.command.EterniaCommand;
import dev.prangellplays.eternia.effect.*;
import dev.prangellplays.eternia.registry.*;
import dev.prangellplays.eternia.screen.EterniaScreenHandlers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Eternia implements ModInitializer {
	public static final String MOD_ID = "eternia";
	public static final Logger LOGGER = LoggerFactory.getLogger("eternia");

	public static final StatusEffect BLEED = registerStatusEffect("bleed", new EmptyStatusEffect(StatusEffectCategory.HARMFUL, 13458603));
	public static final StatusEffect POISON_IVY = registerStatusEffect("poison_ivy", new EmptyStatusEffect(StatusEffectCategory.HARMFUL, 5882118));
	public static final StatusEffect CURSED = registerStatusEffect("cursed", new CursedStatusEffect(StatusEffectCategory.HARMFUL, 13458603, -0.4500000179f).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7cd4a1f4-61ba-4dba-a569-08fb9be88f94", -0.4500000179f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
	public static final StatusEffect PHOENIXS_GRACE = registerStatusEffect("phoenixs_grace", new FallResistanceStatusEffect(StatusEffectCategory.BENEFICIAL, 16750848));
	public static final StatusEffect CALL_OF_THE_JUNGLE = registerStatusEffect("call_of_the_jungle", new CallOfTheJungleEffect(StatusEffectCategory.BENEFICIAL, 5882118, 0.04).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "d95a7607-9d01-4426-8ab7-1bd02e3e70b7", 0.04, EntityAttributeModifier.Operation.ADDITION));
	public static final StatusEffect WINDSWEPT = registerStatusEffect("windswept", new WindsweptEffect(StatusEffectCategory.BENEFICIAL, 5882118, 0.04).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "8c06ade6-ead8-4ab3-92a4-a76a61bbc3b6", 0.04, EntityAttributeModifier.Operation.ADDITION));
	public static final StatusEffect FREEZING = registerStatusEffect("freezing", new FreezingEffect(StatusEffectCategory.HARMFUL, 13458603, -0.4500000179f).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7cd4a1f4-61ba-4dba-a569-08fb9be88f94", -0.4500000179f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
	public static final StatusEffect FROZEN = registerStatusEffect("frozen", new EmptyStatusEffect(StatusEffectCategory.HARMFUL, 3402751));
	public static final StatusEffect STRANGLED = registerStatusEffect("strangled", new StrangledEffect(StatusEffectCategory.HARMFUL, 13458603, -5f).addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "1a191271-0239-4263-a9de-b92d64f17f9a", -5f, EntityAttributeModifier.Operation.ADDITION));
	public static final StatusEffect WIND_WALKER = registerStatusEffect("wind_walker", new FallResistanceStatusEffect(StatusEffectCategory.BENEFICIAL, 15978425));
	public static final StatusEffect DRIPSTONE = registerStatusEffect("dripstone", new FallResistanceStatusEffect(StatusEffectCategory.BENEFICIAL, 15978425));
	public static final StatusEffect SLAMMED = registerStatusEffect("slammed", new EmptyStatusEffect(StatusEffectCategory.HARMFUL, 5882118));
	public static final StatusEffect GALE = registerStatusEffect("gale", new FallResistanceStatusEffect(StatusEffectCategory.BENEFICIAL, 5882118));
	public static final StatusEffect ENDER = registerStatusEffect("ender", new FallResistanceStatusEffect(StatusEffectCategory.BENEFICIAL, 9520880));

	@Override
	public void onInitialize() {
		EterniaItems.init();
		EterniaItemGroups.init();
		EterniaEnchantments.init();
		EterniaCallbacks.init();
		CommandRegistrationCallback.EVENT.register(this::registerCommands);
		EterniaPacketTypes.init();
		EterniaEntityTypes.init();
		EterniaBlockEntities.init();
		EterniaBlocks.init();
		EterniaScreenHandlers.init();
	}

	private static <T extends StatusEffect> T registerStatusEffect(String name, T effect) {
		Registry.register(Registries.STATUS_EFFECT, id(name), effect);
		return effect;
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	private void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandBuildContext, CommandManager.RegistrationEnvironment commandSelection) {
		EterniaCommand.register(dispatcher);
	}

	public static boolean isFrozen(@Nullable LivingEntity entity) {
		return entity != null && entity.hasStatusEffect(Eternia.FROZEN) && !entity.isSpectator() && !(entity instanceof PlayerEntity player && player.isCreative());
	}

}