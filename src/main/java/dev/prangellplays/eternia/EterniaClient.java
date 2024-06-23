package dev.prangellplays.eternia;

import dev.prangellplays.eternia.client.EterniaClientPacketHandler;
import dev.prangellplays.eternia.client.entity.EterniaEntityRenderers;
import dev.prangellplays.eternia.client.models.kings_crown.KingsCrownModel;
import dev.prangellplays.eternia.client.renderer.EterniaRenderer;
import dev.prangellplays.eternia.entity.client.CursedArrowRenderer;
import dev.prangellplays.eternia.item.util.Armour;
import dev.prangellplays.eternia.item.util.EterniaModelPredicateProvider;
import dev.prangellplays.eternia.registry.EterniaBlocks;
import dev.prangellplays.eternia.registry.EterniaEntityTypes;
import dev.prangellplays.eternia.screen.EterniaScreenHandlers;
import dev.prangellplays.eternia.screen.PedestalScreen;
import dev.prangellplays.eternia.screen.WeaponPedestalScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class EterniaClient implements ClientModInitializer {

    public static int tick = 0;

    //Armour
    public static final EntityModelLayer KINGS_CROWN_MODEL_LAYER = new EntityModelLayer(new Identifier(Eternia.MOD_ID, "kings_crown"), "kings_crown");

    @Override
    public void onInitializeClient() {
        EterniaModelPredicateProvider.init();
        EntityRendererRegistry.register(EterniaEntityTypes.CURSED_ARROW, CursedArrowRenderer::new);
        EterniaClientPacketHandler.init();
        EterniaEntityRenderers.init();

        HandledScreens.register(EterniaScreenHandlers.PEDESTAL_SCREEN_HANDLER, PedestalScreen::new);
        HandledScreens.register(EterniaScreenHandlers.WEAPON_PEDESTAL_SCREEN_HANDLER, WeaponPedestalScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(EterniaBlocks.PEDESTAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(EterniaBlocks.WEAPON_PEDESTAL, RenderLayer.getCutout());

        //Armour
        EntityModelLayerRegistry.registerModelLayer(KINGS_CROWN_MODEL_LAYER, KingsCrownModel::getTexturedModelData);
        for (Armour items: Armour.values()) {
            ArmorRenderer.register(new EterniaRenderer(items.getSimpleName(), items.hasVanillaArmorModel(), items.hasKingsCrown(), items.isDyeable()), items.getItems());
        }
    }
    private static float blockingPredicate(ItemStack stack, World level, LivingEntity user, int i) {
        return user != null && user.getActiveItem() == stack ? 1.0f : 0.0f;
    }
}
