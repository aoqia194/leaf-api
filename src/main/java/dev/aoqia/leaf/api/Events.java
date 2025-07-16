package dev.aoqia.leaf.api;

public enum Events {
    CLIENT_CONNECT("OnClientConnect"),
    CLIENT_DISCONNECT("OnClientDisconnect");

    private final String name;

    Events(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
