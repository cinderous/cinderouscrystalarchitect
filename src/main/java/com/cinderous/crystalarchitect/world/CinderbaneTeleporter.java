package com.cinderous.crystalarchitect.world;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class CinderbaneTeleporter  implements ITeleporter {


    BlockPos pos;
    BlockPos finalpos = new BlockPos(0, 0, 0);


    public CinderbaneTeleporter(BlockPos pos) {

        this.pos = pos;

    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
            CrystalArchitect.LOGGER.info("WTF IS GOING ON");


            int sealevel = destWorld.getSeaLevel();
            int heightlevel = destWorld.getHeight();
            int maxX = 200;
            int maxZ = 200;

            Vec3d loc = new Vec3d(0, 0, 0);

            for (int x = 0; x < maxX; ++x) {
                CrystalArchitect.LOGGER.info("THE X LOOP");
                for (int y = sealevel; y == sealevel; ++y ) {
                    CrystalArchitect.LOGGER.info(" THE Y LOOP");
                    for (int z = 0; z < maxZ; ++z) {
                        CrystalArchitect.LOGGER.info("THE Z LOOP");
                        //int index = y * maxX * maxZ + z * maxX + x;
                        BlockPos pos = new BlockPos(x, y, z);


                        if (destWorld.getBlockState(pos).getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
                            pos.add(0,1,0);
                            CrystalArchitect.LOGGER.info("FOUND AIR AND ADDING to Y");
                            //does not appear to be adding to the vector3 loop endless is stuck at y 63



                            finalpos.add(pos.getX(), pos.getY(), pos.getZ());

                            if(checkForSky(heightlevel, destWorld, pos) == heightlevel) {
                                entity.setPosition(finalpos.getX(), finalpos.getY() + 2, finalpos.getZ());
                            };



                            }


                            }
                        }

                    }return repositionEntity.apply(false);
                }

                public int checkForSky(int skybox, ServerWorld dest, BlockPos skycheckpos) {
                    while( dest.getBlockState(skycheckpos)==Blocks.AIR.getDefaultState() && skycheckpos.getY()<=skybox ){
                        skycheckpos.add(0,1,0);
                        CrystalArchitect.LOGGER.info(skycheckpos.getY());
                        finalpos.add(0, skycheckpos.getY(),0);
                        //does not appear to be adding to the vector3 loop endless is stuck at y 63

                    } return skycheckpos.getY();


                }

        }







