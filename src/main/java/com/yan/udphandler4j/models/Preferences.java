package com.yan.udphandler4j.models;

/**
 * Classe que armazena as preferencias do servidor iniciado
 * @author Yan
 */
public class Preferences {
    
    private boolean defaultPackets;

    public boolean hasDefaultPackets() {
        return defaultPackets;
    }

    public void setDefaultPackets(boolean defaultPackets) {
        this.defaultPackets = defaultPackets;
    }
    
    
    
    
}
