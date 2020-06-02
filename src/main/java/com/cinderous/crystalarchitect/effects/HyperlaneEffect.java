package com.cinderous.crystalarchitect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;

public class HyperlaneEffect  extends Effect {

    public HyperlaneEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);

    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.addPotionEffect(new EffectInstance(Effects.SPEED, 500, 255));
        entityLivingBaseIn.setGlowing(true);

    }


}
