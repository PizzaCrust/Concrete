package net.pizzacrust.concrete.entity;

import net.pizzacrust.concrete.MagicEnum;
import org.fountainmc.api.Direction;
import org.fountainmc.api.entity.hanging.HangingEntity;

import javax.annotation.Nullable;


public class SolidHanging extends SolidEntity implements HangingEntity {
    public SolidHanging(net.minecraft.server.Entity entity) {
        super(entity);
    }

    @Nullable
    @Override
    public Direction getDirection() {
        return MagicEnum.fromEnum(entity.getDirection());
    }
}
