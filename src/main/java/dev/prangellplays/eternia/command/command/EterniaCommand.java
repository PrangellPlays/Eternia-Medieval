package dev.prangellplays.eternia.command.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class EterniaCommand {
    public EterniaCommand() {
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("all").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startall))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("PrangellPlays").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startprangellplays))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("Radiation_69420").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startradiation_69420))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("Blimp_Tyler").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startblimp_tyler))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("Skynovic").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startskynovic))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("danipadipa").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startdanipadipa))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("Semmpie").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startsemmpie))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("samyoool").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startsamyoool))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("PotatoBoy24").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startpotatoboy24))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("alopeciagaming").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::startalopeciagaming))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("crown").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("start").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::crownstart))))));

        dispatcher.register((LiteralArgumentBuilder) ((LiteralArgumentBuilder) CommandManager.literal("eternia").then(((LiteralArgumentBuilder) CommandManager.literal("crown").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        }).then(((LiteralArgumentBuilder) CommandManager.literal("end").requires((commandSourceStack) -> {
            return commandSourceStack.hasPermissionLevel(2);
        })).executes(EterniaCommand::crownend))))));
    }

    private static int startall(CommandContext<ServerCommandSource> context) {
        //Server
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "gamerule doDaylightCycle true");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "gamerule doWeatherCycle true");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "gamerule doMobSpawning true");
        //context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "gamerule pvp true");

        //PrangellPlays
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp PrangellPlays 2947 78 -815");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint PrangellPlays 2947 78 -815");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set PrangellPlays origins:origin medieval:jungle_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays armor.feet with minecraft:leather_boots");

        //Radiation_69420
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Radiation_69420 -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Radiation_69420 -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Radiation_69420 origins:origin medieval:taiga_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 armor.feet with minecraft:leather_boots");

        //Blimp_Tyler
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Blimp_Tyler 1128 73 1638");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Blimp_Tyler 1128 73 1638");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Blimp_Tyler origins:origin medieval:mushroom_island_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler armor.feet with minecraft:leather_boots");

        //Skynovic
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Skynovic -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Skynovic -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Skynovic origins:origin medieval:desert_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.5 with minecraft:sand");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic armor.feet with minecraft:leather_boots");

        //danipadipa
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp danipadipa -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint danipadipa -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set danipadipa origins:origin medieval:taiga_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa armor.feet with minecraft:leather_boots");

        //Semmpie
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Semmpie -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Semmpie -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Semmpie origins:origin medieval:desert_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.5 with minecraft:sand");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie armor.feet with minecraft:leather_boots");

        //samyoool
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp samyoool 306 85 1204");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint samyoool 306 85 1204");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set samyoool origins:origin medieval:plains_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool armor.feet with minecraft:leather_boots");

        //PotatoBoy24
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp PotatoBoy24 -679 72 -1564");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint PotatoBoy24 -679 72 -1564");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set PotatoBoy24 origins:origin medieval:dark_oak_forest_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 armor.feet with minecraft:leather_boots");

        //alopeciagaming
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp alopeciagaming -2749 82 2269");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint alopeciagaming -2749 82 2269");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set alopeciagaming origins:origin medieval:mesa_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.5 with minecraft:sand");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming armor.feet with minecraft:leather_boots");

        return 1;
    }

    private static int startprangellplays(CommandContext<ServerCommandSource> context) {
        //PrangellPlays
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp PrangellPlays 2947 78 -815");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint PrangellPlays 2947 78 -815");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set PrangellPlays origins:origin medieval:jungle_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PrangellPlays armor.feet with minecraft:leather_boots");
        return 1;
    }

    private static int startradiation_69420(CommandContext<ServerCommandSource> context) {
        //Radiation_69420
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Radiation_69420 -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Radiation_69420 -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Radiation_69420 origins:origin medieval:taiga_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Radiation_69420 armor.feet with minecraft:leather_boots");
        return 1;
    }

    private static int startblimp_tyler(CommandContext<ServerCommandSource> context) {
        //Blimp_Tyler
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Blimp_Tyler 1128 73 1638");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Blimp_Tyler 1128 73 1638");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Blimp_Tyler origins:origin medieval:mushroom_island_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Blimp_Tyler armor.feet with minecraft:leather_boots");
        return 1;
    }

    private static int startskynovic(CommandContext<ServerCommandSource> context) {
        //Skynovic
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Skynovic -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Skynovic -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Skynovic origins:origin medieval:desert_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.5 with minecraft:sand");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Skynovic armor.feet with minecraft:leather_boots");
        return 1;
    }

    private static int startdanipadipa(CommandContext<ServerCommandSource> context) {
        //danipadipa
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp danipadipa -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint danipadipa -2114 79 -707");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set danipadipa origins:origin medieval:taiga_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity danipadipa armor.feet with minecraft:leather_boots");

        return 1;
    }

    private static int startsemmpie(CommandContext<ServerCommandSource> context) {
        //Semmpie
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp Semmpie -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint Semmpie -1145 80 1990");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set Semmpie origins:origin medieval:desert_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.5 with minecraft:sand");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity Semmpie armor.feet with minecraft:leather_boots");
        return 1;
    }

    private static int startsamyoool(CommandContext<ServerCommandSource> context) {
        //samyoool
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp samyoool 306 85 1204");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint samyoool 306 85 1204");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set samyoool origins:origin medieval:plains_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity samyoool armor.feet with minecraft:leather_boots");
        return 1;
    }

    private static int startpotatoboy24(CommandContext<ServerCommandSource> context) {
        //PotatoBoy24
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp PotatoBoy24 -679 72 -1564");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint PotatoBoy24 -679 72 -1564");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set PotatoBoy24 origins:origin medieval:dark_oak_forest_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity PotatoBoy24 armor.feet with minecraft:leather_boots");
        return 1;
    }

    private static int startalopeciagaming(CommandContext<ServerCommandSource> context) {
        //alopeciagaming
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "tp alopeciagaming -2749 82 2269");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "spawnpoint alopeciagaming -2749 82 2269");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "origin set alopeciagaming origins:origin medieval:mesa_inhabitant");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.0 with medievalweapons:iron_long_sword");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.1 with minecraft:stone_pickaxe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.2 with minecraft:stone_axe");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.3 with minecraft:stone_shovel");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.4 with minecraft:oak_sapling");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.5 with minecraft:sand");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.7 with dehydration:diamond_leather_flask");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming hotbar.8 with minecraft:bread 16");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming armor.head with minecraft:leather_helmet");
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "item replace entity alopeciagaming armor.feet with minecraft:leather_boots");
        return 1;
    }

    //Radiation_69420 - Taiga
    //Blimp_Tyler - Mushroom
    //Skynovic - Desert
    //PrangellPlays - Jungle
    //samyoool - Plains
    //PotatoBoy24 - Dark Oak Forest
    //alopeciagaming - Mesa
    //Semmpie - Desert
    //danipadipa - Taiga

    //Desert: -1145 80 1990
    //Jungle: 2947 78 -815
    //Mushroom: 1128 73 1638
    //Savannah: -592 77 2142
    //Mesa: -2749 82 2269
    //Taiga: -2114 79 -707
    //Plains: 306 85 1204
    //Dark Oak Forest: -679 72 -1564

    //Starter Kit - Full diamond water flask
    //Starter Kit - Iron Halberd
    //Starter Kit - Stone axe, pick, shovel, hoe
    //Starter Kit - 16 bread
    //Starter Kit - leather boots, helmet

    //Starter Kit - Desert/Mesa & Mushroom 1 oak sapling

    private static int crownstart(CommandContext<ServerCommandSource> context) {
        context.getSource().getServer().sendMessage(Text.literal("The Crown Event Has Started"));
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "setblock -47 96 1866 eternia:pedestal{Items:[{Slot:0,id:\"eternia:kings_crown\",Count:1}]} replace");
        return 1;
    }

    private static int crownend(CommandContext<ServerCommandSource> context) {
        context.getSource().getServer().sendMessage(Text.literal("The Crown Event Has Ended"));
        context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource(), "setblock -47 96 1866 air replace");
        return 1;
    }
}
