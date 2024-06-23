package dev.prangellplays.eternia.registry;

import dev.prangellplays.eternia.Eternia;
import dev.prangellplays.eternia.networking.GaleSphereLaunchPacketS2C;
import net.fabricmc.fabric.api.networking.v1.PacketType;

public class EterniaPacketTypes {
    public static final PacketType<GaleSphereLaunchPacketS2C> GALE_SPHERE_LAUNCH_PACKET_S2C = PacketType.create(Eternia.id("gale_sphere_launch_packet"), GaleSphereLaunchPacketS2C::new);
    public static void init() {
    }
}
