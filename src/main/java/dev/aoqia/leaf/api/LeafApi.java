package dev.aoqia.leaf.api;

import dev.aoqia.leaf.api.extensions.InitExtension;

import zombie.debug.DebugLog;
import zombie.debug.DebugLogStream;

public class LeafApi implements ModInitializer, InitExtension {
    public static final String MOD_ID = "leafapi";
    public static final DebugLogStream LOGGER = DebugLog.Mod;

    @Override
    public void onInitialize() {
        LOGGER.debugln("[%s] %s", MOD_ID, "Hello Leaf World!!! >w<");
    }

    @Override
    public void onLuaInitialize() {
        LOGGER.debugln("[%s] %s", MOD_ID, "Hi Leaf World! Lua is init!!!");
    }
}
