package net.pizzacrust.concrete.entity;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityItemFrame;
import org.fountainmc.api.Material;
import org.fountainmc.api.entity.hanging.ItemFrame;

public class SolidItemFrame extends SolidHanging implements ItemFrame {
    private final EntityItemFrame itemFrame = (EntityItemFrame) this.entity;

    public SolidItemFrame(Entity entity) {
        super(entity);
    }

    @Override
    public boolean containsItem() {
        return itemFrame.getItem() != null;
    }

    @Override
    public Material getMaterial() {
        throw new RuntimeException("no item constants");
    }

    @Override
    public void setMaterial(Material material) {
        getMaterial();
    }
}
