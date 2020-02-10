package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

/**
 * Pacote de exemplo
 * @author Yan
 */
public class ExamplePacket extends Packet {
    
    private int id;
    
    @Override
    public void handle(DatagramPacket datagramPacket) {
        System.out.println(getClass().getName()+ " executado com sucesso.");
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
