package com.cinderous.crystalarchitect.world;

import com.cinderous.crystalarchitect.CrystalArchitect;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.Random;
import java.util.function.Function;

public class CinderousTeleporter  implements ITeleporter {


    BlockPos pos;

    public CinderousTeleporter(BlockPos pos) {

        this.pos = pos;


    }


    //public BlockPos finalpos = new BlockPos(0, 0, 0);




    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {

        int sealevel = destWorld.getSeaLevel();
        int heightlevel = destWorld.getHeight();
        int maxX = 200;
        int maxZ = 200;
        int maxY = heightlevel;
        boolean foundair = false;
        //boolean foundground = false;
        Vec3i startposvec = new Vec3i(0,1,0);
        Random rand = new Random();

        BlockPos startpos = new BlockPos(rand.nextInt(500),heightlevel,rand.nextInt(500));

        for (int x = 0; x < maxX; --x) {
            CrystalArchitect.LOGGER.info("THE X LOOP");
            for (int y = 0; y < maxY; --y ) {
                CrystalArchitect.LOGGER.info(" THE Y LOOP");
                for (int z = 0; z < maxZ; --z) {
                    CrystalArchitect.LOGGER.info("THE Z LOOP");
                    CrystalArchitect.LOGGER.info("STARTPOS" + startpos);

                    startpos.subtract(startposvec);
                    //startpos.add(x,-1,z);
                    CrystalArchitect.LOGGER.info("STARTPOS AFTER ADDING NEGATIVE ONE AIR FOUND" + startpos);
////                    int i = startpos.getY() + 1;
//                    BlockPos freshpos = new BlockPos(x, y, z);

                    //CrystalArchitect.LOGGER.info(z);

                    if (destWorld.getBlockState(startpos).getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
                        startpos.subtract(startposvec);
                        CrystalArchitect.LOGGER.info("STARTPOS AFTER ADDING NEGATIVE ONE BEFORE !!!!AFTER!!! FOUND" + startpos);


                       // BlockPos finalpos = new BlockPos(x, airpos.getY(), z);

                        foundair = true;

                        for(int yy = startpos.getY() ;destWorld.getBlockState(startpos)==Blocks.AIR.getDefaultState() && foundair; --yy ) {
                            startpos.subtract(startposvec);

                            if (destWorld.getBlockState(startpos) != Blocks.AIR.getDefaultState()) {
                                entity.setPosition(startpos.getX(), startpos.getY() + 2, startpos.getZ());
                            }
                        }

                    } else if (destWorld.getBlockState(startpos) != Blocks.AIR.getDefaultState()) {
                        foundair = false;
                    }

                }
            }

        }return repositionEntity.apply(false);
    }
}








