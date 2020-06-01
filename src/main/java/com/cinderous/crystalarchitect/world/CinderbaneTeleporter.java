package com.cinderous.crystalarchitect.world;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class CinderbaneTeleporter  implements ITeleporter {


    BlockPos pos;

    int test = 10;


    public CinderbaneTeleporter(BlockPos pos) {

        this.pos = pos;


    }


    //public BlockPos finalpos = new BlockPos(0, 0, 0);

    public BlockPos testpos;

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
            CrystalArchitect.LOGGER.info("WTF IS GOING ON");


            int sealevel = destWorld.getSeaLevel();
            int heightlevel = destWorld.getHeight();
            int maxX = 200;
            int maxZ = 200;
            BlockPos startpos = new BlockPos(0,0,0);

            Vec3d loc = new Vec3d(0, 0, 0);

            for (int x = 0; x < maxX; ++x) {
                CrystalArchitect.LOGGER.info("THE X LOOP");
                for (int y = sealevel; y == sealevel; ++y ) {
                    CrystalArchitect.LOGGER.info(" THE Y LOOP");
                        for (int z = 0; z < maxZ; ++z) {
                            CrystalArchitect.LOGGER.info("THE Z LOOP");
                            CrystalArchitect.LOGGER.info(startpos);
                            int i = startpos.getY() + 1;
                            BlockPos freshpos = new BlockPos(x, y, z);

                            CrystalArchitect.LOGGER.info(freshpos);
                            //CrystalArchitect.LOGGER.info(z);



                            if (destWorld.getBlockState(freshpos).getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
                                int ii = freshpos.getY() + 1;
                                BlockPos airpos = new BlockPos(x, ii, z);

                                //CrystalArchitect.LOGGER.info("test","airpos.toString()", "test");

                               CrystalArchitect.LOGGER.info("FOUND AIR AND ADDING to Y");
                                //does not appear to be adding to the vector3 loop endless is stuck at y 63
                                //CrystalArchitect.LOGGER.info(airpos.getY());
                                CrystalArchitect.LOGGER.info(airpos);

                                BlockPos finalpos = new BlockPos(x, airpos.getY(), z);

                                checkForSkyAndTeleport(heightlevel, destWorld, freshpos, finalpos, entity) ;
                            }
                        }
                    }

                }return repositionEntity.apply(false);
    }

    public boolean checkForSkyAndTeleport(int skybox, ServerWorld dest, BlockPos skycheckpos, BlockPos finalpos, Entity entity) {
        while( dest.getBlockState(skycheckpos)==Blocks.AIR.getDefaultState() && skycheckpos.getY()<=skybox ){
            int ii = skycheckpos.getY() + 1;
            BlockPos upwardspos = new BlockPos(skycheckpos.getX(), ii, skycheckpos.getZ());

            CrystalArchitect.LOGGER.info(skycheckpos.getY());

            int iii = finalpos.getY() + 1;
            BlockPos readypos = new BlockPos(finalpos.getX(), iii,finalpos.getZ());

            entity.setPosition(readypos.getX(), readypos.getY() + 2, readypos.getZ());

        } return true;


    }

}







