package dev.prangellplays.eternia.client;

import dev.prangellplays.eternia.entity.projectile.GaleSphereEntity;
import dev.prangellplays.eternia.networking.GaleSphereLaunchPacketS2C;
import dev.prangellplays.eternia.registry.EterniaEntityTypes;
import dev.prangellplays.eternia.registry.EterniaPacketTypes;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;

public class EterniaClientPacketHandler {

    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(EterniaPacketTypes.GALE_SPHERE_LAUNCH_PACKET_S2C, EterniaClientPacketHandler::onLuminaChargeLaunch);
    }

    public static void onLuminaChargeLaunch(GaleSphereLaunchPacketS2C packet, ClientPlayerEntity player, PacketSender responseSender) {
        Entity except = null;
        if(packet.exceptExists) {
            Entity e = player.getWorld().getEntityById(packet.exceptId);
            if(e != null) {
                except = e;
            }
        }
        GaleSphereEntity.doRepulsion(packet.pos, packet.radius, packet.maxAddedSpeed, player.getWorld(), except);
    }
}
