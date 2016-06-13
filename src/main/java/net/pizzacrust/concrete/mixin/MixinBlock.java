package net.pizzacrust.concrete.mixin;

import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IBlockData;
import net.minecraft.server.World;
import net.pizzacrust.concrete.MagicEnum;
import net.pizzacrust.concrete.SolidServer;
import net.pizzacrust.concrete.world.SolidWorld;
import org.fountainmc.api.event.world.BlockBreakEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = Block.class, remap = false)
public class MixinBlock {

    @Overwrite
    public void remove(World var1, BlockPosition var2, IBlockData var3) {
        SolidServer.PLUGIN_MANAGER.fireEvent(new BlockBreakEvent(MagicEnum.fromBlock(var3.getBlock()), new org.fountainmc.api.world.BlockPosition(new SolidWorld(var1), var2.getX(), var2.getY(), var2.getZ())));
    }
}
