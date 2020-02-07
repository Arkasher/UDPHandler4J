package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

public class ExamplePacket extends Packet {
    
    private int id;
    
    @Override
    void handle(DatagramPacket datagramPacket) {
        System.out.println(getClass().getName()+ " executado com sucesso.");
    }

    @Override
    int getId() {
        return id;
    }

    @Override
    void setId(int id) {
        this.id = id;
    }

}
