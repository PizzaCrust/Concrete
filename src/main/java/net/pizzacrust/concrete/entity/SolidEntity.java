package net.pizzacrust.concrete.entity;

import net.pizzacrust.concrete.world.SolidWorld;
import org.fountainmc.api.entity.Entity;
import org.fountainmc.api.world.Location;

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
    public boolean isOnGround() {
        return entity.onGround;
    }
}
