package com.baisylia.culturaldelights.refabricated.event;

import net.minecraft.client.Camera;

public class ViewportEvent {
	public static class ComputeCameraAngles {
		private final Camera camera;
		private final float partialTicks;
		private float pitch;
		private float yaw;
		private float roll;

		public ComputeCameraAngles(Camera camera, float partialTicks, float yRot, float xRot) {
			this.camera = camera;
			this.partialTicks = partialTicks;
			this.yaw = yRot;
			this.pitch = xRot;
		}

		public Camera getCamera() {
			return camera;
		}

		public float getPartialTick() {
			return partialTicks;
		}

		public float getPitch() {
			return pitch;
		}

		public void setPitch(float pitch) {
			this.pitch = pitch;
		}

		public float getYaw() {
			return yaw;
		}

		public void setYaw(float yaw) {
			this.yaw = yaw;
		}

		public float getRoll() {
			return roll;
		}

		public void setRoll(float roll) {
			this.roll = roll;
		}
	}
}
