package net.pizzacrust.concrete.entity;

import net.minecraft.server.DamageSource;
import net.minecraft.server.EntityDamageSource;
import net.pizzacrust.concrete.world.SolidWorld;
import org.fountainmc.api.entity.Entity;
import org.fountainmc.api.world.Location;

import javax.annotation.Nullable;
import java.util.Collection;

public class SolidEntity implements Entity {
    protected final net.minecraft.server.Entity entity;

    public SolidEntity(net.minecraft.server.Entity entity) {
        this.entity = entity;
    }

    @Override
    public Location getLocation() {
        return new Location(new SolidWorld(entity.getWorld()), entity.locX, entity.locY, entity.locZ);
    }

    @Override
    public void setLocation(Location location) {
        entity.setPosition(location.getX(), location.getY(), location.getZ());
    }

    @Override
    public float getPitch() {
        return entity.pitch;
    }

    @Override
    public void setPitch(float v) {
        entity.pitch = v;
    }

    @Override
    public float getYaw() {
        return entity.yaw;
    }

    @Override
    public void setYaw(float v) {
        entity.yaw = v;
    }

    @Override
    public boolean isOnGround() {
        return entity.onGround;
    }

    @Nullable
    @Override
    public Entity getPassenger() {
        return new SolidEntity(this.entity.passengers.get(0));
    }

    @Override
    public void setPassenger(@Nullable Entity entity) {
        if (this.equals(entity)) {
            throw new RuntimeException("what are you trying to do");
        }
        setVehicle(null);
        ((SolidEntity) entity).entity.startRiding(this.entity);
    }

    @Nullable
    @Override
    public Entity getVehicle() {
        return new SolidEntity(this.entity.getVehicle());
    }

    @Override
    public void setVehicle(@Nullable Entity entity) {
        if (entity == null) {
            this.entity.passengers.get(0).stopRiding();
            return;
        }
        this.entity.startRiding(((SolidEntity) entity).entity);
    }

    @Override
    public Entity getBottomVehicle() {
        return getVehicle();
    }

    @Override
    public Collection<Entity> getNearbyEntities(double v) {
        throw new RuntimeException("i dont know");
    }

    @Override
    public void damage(int i) {
        this.entity.damageEntity(new DamageSource(""){}, i);
    }
}
