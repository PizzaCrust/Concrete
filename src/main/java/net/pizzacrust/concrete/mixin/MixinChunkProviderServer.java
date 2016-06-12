package net.pizzacrust.concrete.mixin;

import net.minecraft.server.Chunk;
import net.minecraft.server.ChunkProviderServer;
import net.minecraft.server.IChunkProvider;
import net.pizzacrust.concrete.world.SolidChunk;
import org.fountainmc.api.Fountain;
import org.fountainmc.api.event.world.ChunkUnloadEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ChunkProviderServer.class, remap = false)
public abstract class MixinChunkProviderServer implements IChunkProvider {

    @Inject(method = "unload(Lnet/minecraft/server/Chunk;)V", at = @At(value = "RETURN", remap = false))
    public void onChunkUnloaded(Chunk chunk, CallbackInfo ci) {
        Fountain.getServer().getPluginManager().fireEvent(new ChunkUnloadEvent(new SolidChunk(chunk)));
    }
}
