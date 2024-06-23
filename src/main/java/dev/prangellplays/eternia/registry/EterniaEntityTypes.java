package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.entity.projectile.CursedArrowEntity;
import dev.prangellplays.eternia.entity.projectile.FrostedScytheEntity;
import dev.prangellplays.eternia.entity.projectile.GaleSphereEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EterniaEntityTypes {
    public static final EntityType<GaleSphereEntity> GALE_SPHERE = Registry.register(Registries.ENTITY_TYPE, Eternia.id("gale_sphere"), FabricEntityTypeBuilder.<GaleSphereEntity>create(SpawnGroup.MISC, GaleSphereEntity::new).dimensions(new EntityDimensions(0.25F, 0.25F, true)).trackRangeChunks(4).trackedUpdateRate(10).build());
    public static final EntityType<FrostedScytheEntity> FROSTED_SCYTHE = Registry.register(Registries.ENTITY_TYPE, Eternia.id("frosted_scythe"), FabricEntityTypeBuilder.<FrostedScytheEntity>create(SpawnGroup.MISC, FrostedScytheEntity::new).dimensions(new EntityDimensions(0.25F, 0.25F, true)).trackRangeChunks(4).trackedUpdateRate(10).build());
    public static final EntityType<CursedArrowEntity> CURSED_ARROW = Registry.register(Registries.ENTITY_TYPE, Eternia.id("cursed_arrow"), FabricEntityTypeBuilder.<CursedArrowEntity>create(SpawnGroup.MISC, CursedArrowEntity::new).dimensions(new EntityDimensions(0.25F, 0.25F, true)).trackRangeChunks(4).trackedUpdateRate(20).build());

    public static void init() {
    }
}
