package dev.prangellplays.eternia.entity.client;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.entity.projectile.CursedArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)
public class CursedArrowRenderer extends ProjectileEntityRenderer<CursedArrowEntity> {
    public static final Identifier TEXTURE = new Identifier(Eternia.MOD_ID, "textures/entity/projectiles/cursed_arrow.png");

    public CursedArrowRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(CursedArrowEntity cursedArrowEntity) {
        return TEXTURE;
    }
}
