package net.pizzacrust.concrete;

import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import org.fountainmc.api.BlockType;
import org.fountainmc.api.world.block.BlockState;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;

public class MagicEnum {
    public static BlockState fromBlock(Block block) {
        return new BlockState() {
            @Nonnull
            @Override
            public BlockType getBlockType() {
                Class<?> blocks = Blocks.class;
                for (Field block : blocks.getDeclaredFields()) {
                    try {
                        if (block.get(null) == block) {
                            return getField(block.getName());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return org.fountainmc.api.Blocks.AIR;
            }

            private BlockType getField(String name) {
                Class<?> blockType = org.fountainmc.api.Blocks.class;
                for (Field field : blockType.getDeclaredFields()) {
                    if (field.getName().equals(name)) {
                        try {
                            return (BlockType) field.get(null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }
                return null;
            }
        };
    }
}
