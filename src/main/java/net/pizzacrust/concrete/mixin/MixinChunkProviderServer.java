package net.pizzacrust.concrete.mixin;

import net.minecraft.server.Chunk;
import net.minecraft.server.ChunkProviderServer;
import net.minecraft.server.IChunkProvider;
import net.pizzacrust.concrete.world.SolidChunk;
import org.fountainmc.api.Fountain;
import org.fountainmc.api.event.world.ChunkLoadEvent;
import org.fountainmc.api.event.world.ChunkUnloadEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ChunkProviderServer.class, remap = false)
public abstract class MixinChunkProviderServer implements IChunkProvider {

    @Inject(method = "unload(Lnet/minecraft/server/Chunk;)V", at = @At(value = "RETURN", remap = false))
    public void onChunkUnloaded(Chunk chunk, CallbackInfo ci) {
        Fountain.getServer().getPluginManager().fireEvent(new ChunkUnloadEvent(new SolidChunk(chunk)));
    }

    @Shadow
    abstract Chunk getOrLoadChunkAt(int var1, int var2);

    @Inject(method = "getChunkAt(II)Lnet/minecraft/server/Chunk;", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/Chunk;addEntities()V"))
    public void onChunkLoaded(int x, int z, CallbackInfoReturnable<Chunk> returnVal) {
        Chunk chunk = getOrLoadChunkAt(x, z);
        Fountain.getServer().getPluginManager().fireEvent(new ChunkLoadEvent(new SolidChunk(chunk)));
    }
}
