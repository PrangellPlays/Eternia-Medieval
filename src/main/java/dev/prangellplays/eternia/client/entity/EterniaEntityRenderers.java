package dev.prangellplays.eternia.client.entity;

import dev.prangellplays.eternia.registry.EterniaEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class EterniaEntityRenderers {

    public static void init() {
        EntityRendererRegistry.register(EterniaEntityTypes.GALE_SPHERE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EterniaEntityTypes.FROSTED_SCYTHE, FlyingItemEntityRenderer::new);
    }
}
