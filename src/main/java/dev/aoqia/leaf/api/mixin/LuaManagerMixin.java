package dev.aoqia.leaf.api.mixin;

import dev.aoqia.leaf.api.extensions.InitExtension;
import dev.aoqia.leaf.loader.api.LeafLoader;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import zombie.Lua.LuaManager;

@Mixin(LuaManager.class)
public class LuaManagerMixin {
    @Inject(method = "init", at = @At("TAIL"))
    private static void init(CallbackInfo ci) {
        final var loader = LeafLoader.getInstance();
        loader.getEntrypoints("main", InitExtension.class)
            .forEach(ModExt::onLuaInitialize);
        loader.getEntrypoints("client", InitExtension.class)
            .forEach(ModExt::onLuaInitialize);
        loader.getEntrypoints("server", InitExtension.class)
            .forEach(ModExt::onLuaInitialize);
    }
}
