package com.xianmouyin.cca.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import com.xianmouyin.cca.CraftableCreativeAbilityModElements;

@CraftableCreativeAbilityModElements.ModElement.Tag
public class AbilitycoreItem extends CraftableCreativeAbilityModElements.ModElement {
	@ObjectHolder("craftable_creative_ability:ability_core")
	public static final Item block = null;
	public AbilitycoreItem(CraftableCreativeAbilityModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("ability_core");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
