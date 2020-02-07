package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

/**
 * Classe abstrata do pacote
 * @author Yan
 */
abstract class Packet {
   
    abstract int getId();
    abstract void setId(int id);
    abstract void handle(DatagramPacket datagramPacket);
    
}
