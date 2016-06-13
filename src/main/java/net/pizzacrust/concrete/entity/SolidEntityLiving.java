package net.pizzacrust.concrete.entity;

import net.minecraft.server.Entity;
import org.fountainmc.api.entity.EntityLiving;

public class SolidEntityLiving extends SolidEntity implements EntityLiving {
    protected final net.minecraft.server.EntityLiving living = (net.minecraft.server.EntityLiving) entity;

    public SolidEntityLiving(Entity entity) {
        super(entity);
    }

    @Override
    public int getHealth() {
        return (int) living.getHealth();
    }

    @Override
    public void setHealth(int i) {
        living.setHealth(i);
    }
}
