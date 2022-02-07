package com.xianmouyin.cca.commands;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.xianmouyin.cca.craft_limiter.craftTimeSave;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TranslatableComponent;

public class addCraftedTimes {
    public static addCraftedTimes instance = new addCraftedTimes();

    public int run (CommandContext<CommandSourceStack> context, String slot){
        craftTimeSave storage = craftTimeSave.get(context.getSource().getLevel());
        Integer times = (int)FloatArgumentType.getFloat(context, "times");
        storage.addTimes(slot, times);
        context.getSource().sendSuccess(new TranslatableComponent("\u00a7c\u00a7lSuccesfully add " + times + " crafted times to creative " + slot + " slot!"), false);

        return 0;
    }
}