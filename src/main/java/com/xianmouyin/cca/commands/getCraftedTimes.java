package com.xianmouyin.cca.commands;

import com.mojang.brigadier.context.CommandContext;
import com.xianmouyin.cca.craft_limiter.craftTimeSave;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;

public class getCraftedTimes {
    public static getCraftedTimes instance = new getCraftedTimes();

    public int run (CommandContext<CommandSource> context, String slot) {
        craftTimeSave storage = craftTimeSave.get(context.getSource().getEntity().getEntityWorld());
        context.getSource().sendFeedback(new TranslationTextComponent("\u00a7\u00a7lcCrafted times of creative " + slot + " slot: " + storage.getTimes(slot).toString()), false);
        return 0;
    }
}