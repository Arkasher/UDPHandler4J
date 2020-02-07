package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

/**
 *
 * @author ybroe
 */
public class DefaultPacket extends Packet {
    
    private int id;
    
    @Override
    void handle(DatagramPacket datagramPacket) {
        System.out.println(getName() + " executado com sucesso.");
    }

    @Override
    String getName() {
        return "DefaultPacket";
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
