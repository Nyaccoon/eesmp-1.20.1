package com.nyaccoon.eesmp.item.customItems;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.world.World;

public class ShardOfTime extends Item {
    public ShardOfTime(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eesmp.shard_of_time").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFED89D))));
    }
    @Override 
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if( entity.isPlayer()){

           PlayerEntity player = (PlayerEntity)entity;
            if(selected || player.getOffHandStack().isOf(this)) player.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(1),1,1), player);
        }    
    }
   }