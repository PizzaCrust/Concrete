package net.pizzacrust.concrete.entity;

import net.minecraft.server.EntityLeash;
import org.fountainmc.api.entity.Entity;
import org.fountainmc.api.entity.hanging.LeashKnot;

import javax.annotation.Nullable;

public class SolidLeashKnot extends SolidHanging implements LeashKnot {
    private EntityLeash leash = (EntityLeash) entity;

    public SolidLeashKnot(net.minecraft.server.Entity entity) {
        super(entity);
    }

    @Nullable
    @Override
    public Entity getLeashedEntity() {
        throw new RuntimeException("SolidLeachKnot cannot be implemented");
    }
}
