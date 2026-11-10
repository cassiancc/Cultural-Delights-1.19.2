package com.baisylia.culturaldelights.refabricated.patch;

import com.baisylia.culturaldelights.refabricated.util.Flammable;

public class LeavesBlock extends net.minecraft.world.level.block.TintedParticleLeavesBlock implements Flammable {
	public LeavesBlock(Properties properties) {
		super(0.01f, properties);
	}
}
