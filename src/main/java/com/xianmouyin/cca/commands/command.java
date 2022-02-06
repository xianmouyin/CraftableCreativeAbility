package com.xianmouyin.cca.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.xianmouyin.cca.Utils;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class command {
    @SubscribeEvent
    public static void onServerStarting(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
        LiteralCommandNode<CommandSource> cmd = dispatcher.register(
                Commands.literal(Utils.MOD_ID)
                        .then(Commands.literal("get_crafted_times")
                                .then(Commands.literal("abilities")
                                        .executes(context -> getCraftedTimes.instance.run(context, "abilities"))
                                )
                                .then(Commands.literal("upgrades")
                                        .executes(context -> getCraftedTimes.instance.run(context, "upgrades"))
                                )
                                .then(Commands.literal("defense")
                                        .executes(context -> getCraftedTimes.instance.run(context, "defense"))
                                )
                                .then(Commands.literal("soul")
                                        .executes(context -> getCraftedTimes.instance.run(context, "soul"))
                                )
                        )
                        .then(Commands.literal("add_crafted_times")
                                .then(Commands.literal("abilities")
                                    .then(Commands.argument("times", FloatArgumentType.floatArg())
                                            .executes(context -> addCraftedTimes.instance.run(context, "abilities"))))
                                .then(Commands.literal("uprades")
                                        .then(Commands.argument("times", FloatArgumentType.floatArg())
                                                .executes(context -> addCraftedTimes.instance.run(context, "upgrades"))))
                                .then(Commands.literal("defense")
                                        .then(Commands.argument("times", FloatArgumentType.floatArg())
                                                .executes(context -> addCraftedTimes.instance.run(context, "defense"))))
                                .then(Commands.literal("soul")
                                        .then(Commands.argument("times", FloatArgumentType.floatArg())
                                                .executes(context -> addCraftedTimes.instance.run(context, "soul"))))
                        )
        );
    }
}
