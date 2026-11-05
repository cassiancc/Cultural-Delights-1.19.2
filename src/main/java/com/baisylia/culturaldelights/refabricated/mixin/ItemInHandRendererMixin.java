package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.item.ModItems;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {
	@WrapOperation(method = "renderArmWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemInHandRenderer;applyItemArmTransform(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/world/entity/HumanoidArm;F)V", ordinal = 2))
	private static void culturalDelights$setupHandCookedFirstPersonAnim(ItemInHandRenderer instance, PoseStack poseStack, HumanoidArm hand, float equippedProg, Operation<Void> original, AbstractClientPlayer player, float partialTicks, float pitch, InteractionHand hand2, float swingProgress, ItemStack stack, float equippedProgress, PoseStack poseStack2, MultiBufferSource buffer, int combinedLight, @Local HumanoidArm arm) {
		if (!(stack.is(ModItems.MARSHMALLOW_ON_A_STICK.get())) || !CulturalDelights.ClientModEvents.applyForgeHandTransform(poseStack, null, arm, stack, partialTicks, equippedProgress, swingProgress)) {
			original.call(instance, poseStack, hand, equippedProg);
		}
	}
}
