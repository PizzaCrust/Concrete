package net.pizzacrust.concrete.api;

import net.minecraft.server.*;
import net.pizzacrust.concrete.entity.SolidEntity;
import net.pizzacrust.concrete.entity.SolidEntityPlayer;
import org.fountainmc.api.Fountain;
import org.fountainmc.api.event.entity.EntityRemovedEvent;
import org.fountainmc.api.event.entity.EntitySpawnEvent;

import javax.annotation.Nullable;

public class WorldAccessor implements IWorldAccess {
    @Override
    public void a(World world, BlockPosition blockPosition, IBlockData iBlockData, IBlockData iBlockData1, int i) {

    }

    @Override
    public void a(BlockPosition blockPosition) {

    }

    @Override
    public void a(int i, int i1, int i2, int i3, int i4, int i5) {

    }

    @Override
    public void a(@Nullable EntityHuman entityHuman, SoundEffect soundEffect, SoundCategory soundCategory, double v, double v1, double v2, float v3, float v4) {

    }

    @Override
    public void a(SoundEffect soundEffect, BlockPosition blockPosition) {

    }

    @Override
    public void a(int i, boolean b, double v, double v1, double v2, double v3, double v4, double v5, int... ints) {

    }

    @Override
    public void a(Entity entity) {
        SolidEntity solidEntity = new SolidEntity(entity);
        if (entity instanceof EntityPlayer) {
            solidEntity = new SolidEntityPlayer(entity);
        }
        Fountain.getServer().getPluginManager().fireEvent(new EntitySpawnEvent(solidEntity, solidEntity.getLocation()));
    }

    @Override
    public void b(Entity entity) {
        SolidEntity solidEntity = new SolidEntity(entity);
        if (entity instanceof EntityPlayer) {
            solidEntity = new SolidEntityPlayer(entity);
        }
        Fountain.getServer().getPluginManager().fireEvent(new EntityRemovedEvent(solidEntity, solidEntity.getLocation()));
    }

    @Override
    public void a(int i, BlockPosition blockPosition, int i1) {

    }

    @Override
    public void a(EntityHuman entityHuman, int i, BlockPosition blockPosition, int i1) {

    }

    @Override
    public void b(int i, BlockPosition blockPosition, int i1) {

    }
}
