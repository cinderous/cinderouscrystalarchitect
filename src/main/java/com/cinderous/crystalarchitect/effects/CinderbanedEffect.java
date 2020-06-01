package com.cinderous.crystalarchitect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class CinderbanedEffect extends Effect {

    public CinderbanedEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);

    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.setHealth(amplifier * 5.0F);
        entityLivingBaseIn.setJumping(true);
        entityLivingBaseIn.setBeeStingCount(5 * amplifier);
    }


}