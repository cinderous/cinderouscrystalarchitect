package com.cinderous.crystalarchitect.client.entity.model.render;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.client.entity.model.CinderlingModel;
import com.cinderous.crystalarchitect.entities.Cinderling;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CinderlingRender extends MobRenderer<Cinderling, CinderlingModel<Cinderling>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(CrystalArchitect.MOD_ID,
            "textures/entity/example_entity.png");

    public CinderlingRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CinderlingModel<Cinderling>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(Cinderling entity) {
        return TEXTURE;
    }
}
