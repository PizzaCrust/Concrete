package net.pizzacrust.concrete.mixin;

import net.minecraft.server.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(value = PlayerConnection.class, remap = false)
public abstract class MixinPlayerConnection implements PacketListenerPlayIn, ITickable {

    @Shadow
    public EntityPlayer player;

    @Inject(method = "a(Lnet/minecraft/server/PacketPlayInUseEntity;)V", at = @At(value = "HEAD", remap = false))
    public void a(PacketPlayInUseEntity var1) {
        PlayerConnectionUtils.ensureMainThread(var1, this, this.player.x());
        if (this.player.dead) return; // CraftBukkit
        if (!this.player.isSpectator()) return; // Spigot
    }
}