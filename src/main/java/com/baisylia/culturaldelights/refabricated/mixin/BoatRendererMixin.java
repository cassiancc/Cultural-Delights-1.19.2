package com.baisylia.culturaldelights.refabricated.mixin;

import com.baisylia.culturaldelights.CulturalDelights;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.model.ChestRaftModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.RaftModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatRenderer.class)
public class BoatRendererMixin {

	@WrapOperation(method = "getTextureLocation(Lnet/minecraft/world/entity/vehicle/Boat$Type;Z)Lnet/minecraft/resources/ResourceLocation;", at = @At(value = "INVOKE", target = "Lnet/minecraft/resources/ResourceLocation;withDefaultNamespace(Ljava/lang/String;)Lnet/minecraft/resources/ResourceLocation;"))
	private static ResourceLocation correctTextureLocation(String location, Operation<ResourceLocation> original) {
		var id = original.call(location);
		if (id.getPath().contains(CulturalDelights.MOD_ID)) {
			return ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, location.replace(CulturalDelights.MOD_ID + "_", ""));
		}
		return id;
	}

	@Inject(method = "createBoatModel", at = @At(value = "NEW", target = "(Lnet/minecraft/client/model/geom/ModelPart;)Lnet/minecraft/client/model/BoatModel;"), cancellable = true)
	private static void correctModel(EntityRendererProvider.Context context, Boat.Type type, boolean chestBoat, CallbackInfoReturnable<ListModel<Boat>> cir, @Local ModelPart modelPart) {
		if (type.equals(Boat.Type.CULUTRALDELIGHTS_BEANSTALK)) {
			cir.setReturnValue(new RaftModel(modelPart));
		}
	}

	@Inject(method = "createBoatModel", at = @At(value = "NEW", target = "(Lnet/minecraft/client/model/geom/ModelPart;)Lnet/minecraft/client/model/BoatModel;"), cancellable = true)
	private static void correctChestModel(EntityRendererProvider.Context context, Boat.Type type, boolean chestBoat, CallbackInfoReturnable<ListModel<Boat>> cir, @Local ModelPart modelPart) {
		if (type.equals(Boat.Type.CULUTRALDELIGHTS_BEANSTALK)) {
			cir.setReturnValue(new ChestRaftModel(modelPart));
		}
	}
}
