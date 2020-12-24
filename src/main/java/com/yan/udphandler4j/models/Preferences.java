package com.yan.udphandler4j.models;

/**
 * Classe que armazena as preferencias do servidor iniciado
 * @author Yan
 */
public class Preferences {
    
    private boolean defaultPackets, randomPort;

    public boolean hasDefaultPackets() {
        return defaultPackets;
    }

    public void setDefaultPackets(boolean defaultPackets) {
        this.defaultPackets = defaultPackets;
    }

    public boolean isRandomPort() {
        return randomPort;
    }

    public void setRandomPort(boolean randomPort) {
        this.randomPort = randomPort;
    }
    
    
    
    
    
    
}
