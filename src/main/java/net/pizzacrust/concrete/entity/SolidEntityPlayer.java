package net.pizzacrust.concrete.entity;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityPlayer;
import org.fountainmc.api.entity.Player;

import java.util.UUID;

public class SolidEntityPlayer extends SolidEntityLiving implements Player {
    protected final EntityPlayer mpPlayer = (EntityPlayer) living;

    public SolidEntityPlayer(Entity entity) {
        super(entity);
    }

    @Override
    public String getName() {
        return mpPlayer.getName();
    }

    @Override
    public UUID getUUID() {
        return mpPlayer.getUniqueID();
    }
}
