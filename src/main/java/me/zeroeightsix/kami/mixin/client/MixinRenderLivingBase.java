package me.zeroeightsix.kami.mixin.client;

import me.zeroeightsix.kami.util.Wrapper;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderLivingBase.class)
public class MixinRenderLivingBase<T extends EntityLivingBase> {

    @Inject(method = "renderName", at = @At("HEAD"), cancellable = true)
    public void renderName(T entity, double x, double y, double z, CallbackInfo ci) {
        if (Wrapper.getPlayer() == null || Wrapper.getWorld() == null) {
            ci.cancel();
        }
    }
}
