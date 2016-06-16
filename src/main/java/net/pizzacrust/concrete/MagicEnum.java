package net.pizzacrust.concrete;

import net.minecraft.server.*;
import org.fountainmc.api.BlockType;
import org.fountainmc.api.Color;
import org.fountainmc.api.Direction;
import org.fountainmc.api.world.block.BlockState;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;

public class MagicEnum {

    public static Direction fromEnum(EnumDirection enumDirection) {
        for (Direction direction : Direction.values()) {
            if (direction.name().equals(enumDirection.name())) {
                return direction;
            }
        }
        return Direction.NORTH;
    }

    public static Color convert(EnumColor color) {
        for (Color color1 : Color.values()) {
            if (color1.name().equals(color.name())) {
                return color1;
            }
        }
        return Color.WHITE;
    }

    public static EnumColor convert(Color color) {
        for (EnumColor color1 : EnumColor.values()) {
            if (color1.name().equals(color.name())) {
                return color1;
            }
        }
        return EnumColor.WHITE;
    }

    public static EnumDirection toNMS(Direction direction) {
        for (EnumDirection direction1 : EnumDirection.values()) {
            if (direction1.name().equals(direction.name())) {
                return direction1;
            }
        }
        return EnumDirection.NORTH;
    }

    public static BlockState fromBlock(Block block) {
        if (block instanceof BlockChest) {
            return new net.pizzacrust.concrete.block.BlockChest((BlockChest) block);
        }
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
