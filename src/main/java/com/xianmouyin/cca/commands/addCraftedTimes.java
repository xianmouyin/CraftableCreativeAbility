package com.xianmouyin.cca.commands;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.xianmouyin.cca.craft_limiter.craftTimeSave;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.TranslationTextComponent;

public class addCraftedTimes {
    public static addCraftedTimes instance = new addCraftedTimes();

    public int run (CommandContext<CommandSource> context, String slot){
        craftTimeSave storage = craftTimeSave.get(context.getSource().getEntity().getEntityWorld());
        Integer times = (int)FloatArgumentType.getFloat(context, "times");
        storage.addTimes(slot, times);
        context.getSource().sendFeedback(new TranslationTextComponent("\u00a7\u00a7lcSuccesfully add " + times + " crafted times to creative " + slot + " slot!"), false);

        return 0;
    }
}