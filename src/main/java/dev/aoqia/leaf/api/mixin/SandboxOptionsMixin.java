package dev.aoqia.leaf.api.mixin;

import dev.aoqia.leaf.api.Events;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import zombie.Lua.LuaEventManager;
import zombie.SandboxOptions;
import zombie.debug.DebugLog;

@Mixin(SandboxOptions.class)
public class SandboxOptionsMixin {
    @Inject(method = "load()V", at = @At("HEAD"))
    private void preLoad(CallbackInfo ci) {
        LuaEventManager.triggerEvent(Events.PRE_SANDBOX_OPTIONS_LOAD.name());
        DebugLog.log("PRE_SANDBOX_OPTIONS_LOAD event triggered");
    }

    @Inject(method = "load()V", at = @At("TAIL"))
    private void postLoad(CallbackInfo ci) {
        LuaEventManager.triggerEvent(Events.POST_SANDBOX_OPTIONS_LOAD.name());
        DebugLog.log("POST_SANDBOX_OPTIONS_LOAD event triggered");
    }
}
