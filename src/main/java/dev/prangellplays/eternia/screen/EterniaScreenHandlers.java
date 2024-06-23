package dev.prangellplays.eternia.screen;

import dev.prangellplays.eternia.Eternia;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class EterniaScreenHandlers {
public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(Eternia.MOD_ID, "pedestal_screen_handler"), new ExtendedScreenHandlerType<>(PedestalScreenHandler::new));
public static final ScreenHandlerType<WeaponPedestalScreenHandler> WEAPON_PEDESTAL_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(Eternia.MOD_ID, "weapon_pedestal_screen_handler"), new ExtendedScreenHandlerType<>(WeaponPedestalScreenHandler::new));


    public static void init() {
        Eternia.LOGGER.info("Registering Screen Handlers for " + Eternia.MOD_ID);
    }
}