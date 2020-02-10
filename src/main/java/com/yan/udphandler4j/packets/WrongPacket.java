package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

/**
 * Pacote chamado quando o id do pacote recebido é inválido ou não existe
 *
 * @author Yan
 */
public class WrongPacket extends Packet {

    private int id;

    @Override
    public void handle(DatagramPacket datagramPacket) {
        System.out.println("Pacote " + datagramPacket.getData()[0] + " incorreto");
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
