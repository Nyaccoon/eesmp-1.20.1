package com.nyaccoon.eesmp.item.customItems;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShardOfSpace extends Item {
    public ShardOfSpace(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.eesmp.shard_of_space").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFED89D))));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
		
        user.getItemCooldownManager().set(this,200);

		if (!world.isClient) {
			EnderPearlEntity pearl = new EnderPearlEntity(world, user);
            pearl.setItem(itemStack);
            pearl.setVelocity(user,user.getPitch(),user.getYaw(),0.0f,2.25f,0.0f);
            world.spawnEntity(pearl);
		}
 
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		return TypedActionResult.success(itemStack, world.isClient());
	} 
}