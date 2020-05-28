
package com.cinderous.crystalarchitect.items;

        import com.cinderous.crystalarchitect.CrystalArchitect;
        import net.minecraft.entity.Entity;
        import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.item.Item;
        import net.minecraft.item.ItemStack;
        import net.minecraft.potion.EffectInstance;
        import net.minecraft.potion.Effects;
        import net.minecraft.util.ActionResult;
        import net.minecraft.util.Hand;
        import net.minecraft.world.World;

        import javax.annotation.Nullable;

public class SharpenedCinderiteRock extends Item {

    public SharpenedCinderiteRock() {
        super(new Item.Properties().group(CrystalArchitect.TAB));
    }



//throw rock later...
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION,500,255));
//        worldIn.setRainStrength(1.0f);
//        return super.onItemRightClick(worldIn, playerIn, handIn);
//    }
}
