package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

/**
 *
 * @author ybroe
 */
abstract class Packet {
   
    abstract int getId();
    abstract void setId(int id);
    abstract void handle(DatagramPacket datagramPacket);
    
}
