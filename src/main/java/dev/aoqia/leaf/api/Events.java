package dev.aoqia.leaf.api;

public enum Events {
    CLIENT_CONNECT("OnClientConnect"),
    CLIENT_DISCONNECT("OnClientDisconnect"),
    PRE_SANDBOX_OPTIONS_LOAD("OnPreSandboxOptionsLoad"),
    POST_SANDBOX_OPTIONS_LOAD("OnPostSandboxOptionsLoad");

    private final String name;

    Events(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
