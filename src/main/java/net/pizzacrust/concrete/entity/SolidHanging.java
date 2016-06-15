package net.pizzacrust.concrete.entity;

import org.fountainmc.api.Direction;
import org.fountainmc.api.entity.Entity;
import org.fountainmc.api.entity.hanging.HangingEntity;
import org.fountainmc.api.world.Location;

import javax.annotation.Nullable;
import java.util.Collection;

public class SolidHanging extends SolidEntity implements HangingEntity {
    public SolidHanging(net.minecraft.server.Entity entity) {
        super(entity);
    }

    @Nullable
    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void setLocation(Location location) {

    }

    @Override
    public float getPitch() {
        return 0;
    }

    @Override
    public void setPitch(float v) {

    }

    @Override
    public float getYaw() {
        return 0;
    }

    @Override
    public void setYaw(float v) {

    }

    @Nullable
    @Override
    public Entity getPassenger() {
        return null;
    }

    @Override
    public void setPassenger(@Nullable Entity entity) {

    }

    @Nullable
    @Override
    public Entity getVehicle() {
        return null;
    }

    @Override
    public void setVehicle(@Nullable Entity entity) {

    }

    @Override
    public Entity getBottomVehicle() {
        return null;
    }

    @Override
    public Collection<Entity> getNearbyEntities(double v) {
        return null;
    }

    @Override
    public void damage(int i) {

    }
}
