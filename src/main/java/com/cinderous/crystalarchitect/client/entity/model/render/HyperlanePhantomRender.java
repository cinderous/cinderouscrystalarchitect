package com.cinderous.crystalarchitect.client.entity.model.render;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.client.entity.model.CinderlingModel;
import com.cinderous.crystalarchitect.client.entity.model.HyperlanePhantomModel;
import com.cinderous.crystalarchitect.entities.Cinderling;
import com.cinderous.crystalarchitect.entities.HyperlanePhantom;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class HyperlanePhantomRender extends MobRenderer<HyperlanePhantom, HyperlanePhantomModel<HyperlanePhantom>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(CrystalArchitect.MOD_ID,
            "textures/entities/hyperlane_phantom.png");

    public HyperlanePhantomRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HyperlanePhantomModel<HyperlanePhantom>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(HyperlanePhantom entity) {
        return TEXTURE;
    }

}