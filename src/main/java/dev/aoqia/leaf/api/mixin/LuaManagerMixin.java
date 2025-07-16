package dev.aoqia.leaf.api.mixin;

import dev.aoqia.leaf.api.extensions.InitExtension;
import dev.aoqia.leaf.loader.api.LeafLoader;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import zombie.Lua.LuaManager;

import static dev.aoqia.leaf.api.LeafApi.LOGGER;

@Mixin(LuaManager.class)
public class LuaManagerMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private static void init(CallbackInfo ci) {
        var entrypoints = LeafLoader.getInstance().getEntrypoints("main", InitExtension.class);
        for (var e : entrypoints) {
            if (e instanceof InitExtension) {
                LOGGER.debugln("Calling onLuaInitialize for class " + e.getClass().getName());
                e.onLuaInitialize();
            }
        }
    }
}
