package com.cinderous.crystalarchitect.world;

import com.cinderous.crystalarchitect.CrystalArchitect;
import com.cinderous.crystalarchitect.util.RegistryHandler;
import com.cinderous.crystalarchitect.world.dimensions.CinderbaneDimension;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class CinderbaneTeleporter  implements ITeleporter {


    BlockPos pos;


    public CinderbaneTeleporter(BlockPos pos) {

        this.pos = pos;

    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        if (currentWorld.getDimension() == RegistryHandler.CINDERBANE_DIM.get().getFactory()) {


        int sealevel = destWorld.getSeaLevel();
        int maxX = 200;
        int maxZ = 200;
        Vec3d loc = new Vec3d(0, 0, 0);

        for (int x = 0; x < maxX; ++x) {
            for (int y = sealevel; y == sealevel;) {
                for (int z = 0; z < maxZ; ++z) {
                    int index = y * maxX * maxZ + z * maxX + x;
                    BlockPos pos = new BlockPos(x, y, z);

                    CrystalArchitect.LOGGER.info("BLOCK POS SET WITH CURRENT INDEX");

                    if (destWorld.getBlockState(pos).getBlock() == RegistryHandler.CINDIRT_GRASS.get()) {
                        int i = pos.getY() + 1;
                        BlockPos abovepos = new BlockPos(x, i, z);

                        CrystalArchitect.LOGGER.info("BLOCK ABOVEPOS SET WITH CURRENT INDEX + 1 y");

                        if (destWorld.getBlockState(abovepos).getBlock().getDefaultState().isAir()) {
                            int j = abovepos.getY() + 1;
                            BlockPos finalpos = new BlockPos(x, i, z);

                            CrystalArchitect.LOGGER.info("BLOCK FINALPOS SET WITH CURRENT INDEX + 1 y");

                            if (destWorld.getBlockState(finalpos).getBlock().getDefaultState().isAir()) {
                                entity.setPosition(finalpos.getX(), finalpos.getY() + 2, finalpos.getZ());
                            }
                        }
                    }
                    ;
                }


                // entity.setPosition(pos.getX(), pos.getY(), sealevel);

            }

        }
        }
        return repositionEntity.apply(false);
    }
}
