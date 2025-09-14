package dev.aoqia.leaf.api;

import dev.aoqia.leaf.api.extensions.InitExtension;

import zombie.Lua.LuaEventManager;
import zombie.debug.DebugLog;

public class LeafApi implements ModInitializer, InitExtension {
    @Override
    public void onInitialize() {}

    @Override
    public void onLuaInitialize() {
        for (var e : Events.values()) {
            LuaEventManager.AddEvent(e.name());
        }
        DebugLog.log("Added leaf-api events");
    }
}
