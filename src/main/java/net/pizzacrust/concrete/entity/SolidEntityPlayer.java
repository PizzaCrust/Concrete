package net.pizzacrust.concrete.entity;

import net.minecraft.server.*;
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

    @Override
    public void sendMessage(String s) {
        sendMessages(s);
    }

    @Override
    public void sendMessages(String... messages) {
        for (String message : messages) {
            mpPlayer.sendMessage(new ChatComponentText(message));
        }
    }

    public EntityPlayer getHandle() {
        return mpPlayer;
    }

    @Override
    public void hide(org.fountainmc.api.entity.Entity entity) {
        EntityTracker tracker = ((WorldServer) this.entity.world).tracker;
        EntityPlayer other = ((SolidEntityPlayer) entity).getHandle();
        EntityTrackerEntry entry = tracker.trackedEntities.get(other.getId());
        if (entry != null) {
            entry.clear(getHandle());
        }
        getHandle().playerConnection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, other));
    }
}
