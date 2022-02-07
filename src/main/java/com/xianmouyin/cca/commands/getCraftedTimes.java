package com.xianmouyin.cca.commands;

import com.mojang.brigadier.context.CommandContext;
import com.xianmouyin.cca.craft_limiter.craftTimeSave;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TranslatableComponent;

public class getCraftedTimes {
    public static getCraftedTimes instance = new getCraftedTimes();

    public int run (CommandContext<CommandSourceStack> context, String slot) {
        craftTimeSave storage = craftTimeSave.get(context.getSource().getLevel());
        context.getSource().sendSuccess(new TranslatableComponent("\u00a7c\u00a7lCrafted times of creative " + slot + " slot: " + storage.getTimes(slot).toString()), false);
        return 0;
    }
}