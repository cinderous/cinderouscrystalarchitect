package com.cinderous.crystalarchitect.client.entity.model;

import com.cinderous.crystalarchitect.entities.HyperlanePhantom;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class HyperlanePhantomModel<T extends HyperlanePhantom> extends EntityModel<T> {
    private final ModelRenderer Body;
    private final ModelRenderer Legs;
    private final ModelRenderer Front;
    private final ModelRenderer BackLeftLeg;
    private final ModelRenderer BackRightLeg;
    private final ModelRenderer Back;
    private final ModelRenderer LeftLeg2;
    private final ModelRenderer RightLeg;
    private final ModelRenderer Head;

    public HyperlanePhantomModel() {
        textureWidth = 16;
        textureHeight = 16;

        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, 24.0F, 0.0F);
        Body.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -4.0F, 7.0F, 1.0F, 11.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -5.0F, 5.0F, 1.0F, 12.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-1.0F, -6.0F, -6.0F, 3.0F, 1.0F, 13.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(0.0F, -7.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-4.0F, -9.0F, -1.0F, 9.0F, 9.0F, 7.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, 1.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(5.0F, -8.0F, 1.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, 1.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(6.0F, -6.0F, 1.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(-7.0F, -5.0F, 1.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
        Body.setTextureOffset(0, 0).addBox(7.0F, -5.0F, 1.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);

        Legs = new ModelRenderer(this);
        Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(Legs);


        Front = new ModelRenderer(this);
        Front.setRotationPoint(0.0F, 0.0F, 0.0F);
        Legs.addChild(Front);


        BackLeftLeg = new ModelRenderer(this);
        BackLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        Front.addChild(BackLeftLeg);


        BackRightLeg = new ModelRenderer(this);
        BackRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        Front.addChild(BackRightLeg);


        Back = new ModelRenderer(this);
        Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        Legs.addChild(Back);


        LeftLeg2 = new ModelRenderer(this);
        LeftLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
        Back.addChild(LeftLeg2);


        RightLeg = new ModelRenderer(this);
        RightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        Back.addChild(RightLeg);
        RightLeg.setTextureOffset(0, 0).addBox(-8.0F, -1.0F, -1.0F, 1.0F, 7.0F, 4.0F, 0.0F, false);
        RightLeg.setTextureOffset(0, 0).addBox(8.0F, -1.0F, -1.0F, 1.0F, 7.0F, 4.0F, 0.0F, false);
        RightLeg.setTextureOffset(0, 0).addBox(-8.0F, -2.0F, -3.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
        RightLeg.setTextureOffset(0, 0).addBox(8.0F, -2.0F, -3.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
        RightLeg.setTextureOffset(0, 0).addBox(-8.0F, -3.0F, -5.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        RightLeg.setTextureOffset(0, 0).addBox(8.0F, -3.0F, -5.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(Head);
        Head.setTextureOffset(0, 0).addBox(-2.0F, -6.0F, -10.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

//    @Override
//    public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//        //previously the render function, render code was moved to a method below
//    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
