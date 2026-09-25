package com.nyaccoon.eesmp.item.customItems;

import java.util.List;

import com.nyaccoon.eesmp.item.ModItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HeartOfReality extends Item {
    public HeartOfReality(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eesmp.heart_of_reality").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFED89D))));
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this,600);
        ItemStack tempItem = new ItemStack(Registries.ITEM.get(Identifier.of("origins","orb_of_origin")));
        user.getInventory().insertStack(tempItem);
        return TypedActionResult.success(new ItemStack(ModItems.HEART_OF_REALITY),world.isClient());
    }
}