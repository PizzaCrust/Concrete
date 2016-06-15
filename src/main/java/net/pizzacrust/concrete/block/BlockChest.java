package net.pizzacrust.concrete.block;

import net.pizzacrust.concrete.MagicEnum;
import org.fountainmc.api.BlockType;
import org.fountainmc.api.Blocks;
import org.fountainmc.api.Direction;
import org.fountainmc.api.world.block.Chest;

import javax.annotation.Nonnull;

public class BlockChest extends AbstractBlockState implements Chest {
    private final net.minecraft.server.BlockChest chest;

    public BlockChest(net.minecraft.server.BlockChest chest) {
        this.chest = chest;
    }

    @Override
    public Direction getDirection() {
        return MagicEnum.fromEnum(chest.getBlockData().get(net.minecraft.server.BlockChest.FACING));
    }

    @Override
    public Chest withDirection(Direction direction) {
        chest.getBlockData().set(net.minecraft.server.BlockChest.FACING, MagicEnum.toNMS(direction));
        return this;
    }

    @Nonnull
    @Override
    public BlockType getBlockType() {
        return Blocks.CHEST;
    }
}
