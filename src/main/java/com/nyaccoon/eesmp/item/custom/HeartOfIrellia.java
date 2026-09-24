package com.nyaccoon.eesmp.item.custom;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class HeartOfIrellia extends Item {
    public HeartOfIrellia(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eesmp.heart_of_irellia").formatted(Formatting.RED));
    }
}