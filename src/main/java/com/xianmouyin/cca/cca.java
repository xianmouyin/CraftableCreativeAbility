package com.xianmouyin.cca;import com.xianmouyin.cca.items.ItemRegistry;import com.xianmouyin.cca.Config.config;import com.xianmouyin.cca.craft_limiter.limiter;import net.minecraftforge.common.MinecraftForge;import net.minecraftforge.fml.ModLoadingContext;import net.minecraftforge.fml.common.Mod;import net.minecraftforge.fml.config.ModConfig.Type;import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;@Mod(Utils.MOD_ID)public class cca {    public cca() {        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());        ModLoadingContext.get().registerConfig(Type.COMMON, config.COMMON_CONFIG, "craftable_creative_ability.toml");        MinecraftForge.EVENT_BUS.register(limiter.class);    }}