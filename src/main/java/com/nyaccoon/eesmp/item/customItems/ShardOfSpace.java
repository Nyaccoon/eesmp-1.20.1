package com.nyaccoon.eesmp.item.customItems;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.world.World;

public class ShardOfSpace extends Item {
    public ShardOfSpace(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eesmp.shard_of_space").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFED89D))));
    }
}