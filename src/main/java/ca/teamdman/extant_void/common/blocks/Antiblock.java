package ca.teamdman.extant_void.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.PushReaction;

public class Antiblock extends Block {
    public Antiblock() {
        super(Properties
                      .of()
                      .forceSolidOff()
                      .strength(0.01F)
                      .sound(SoundType.BIG_DRIPLEAF)
                      .pushReaction(PushReaction.DESTROY)
        );
    }
}
