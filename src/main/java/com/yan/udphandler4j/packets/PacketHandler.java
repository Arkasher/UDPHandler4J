package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

public class PacketHandler {

    public void handle(DatagramPacket datagramPacket) {
        byte[] data = datagramPacket.getData();

        Class handledPacket = getPacketClass(data[0]);
    }

    public Class getPacketClass(byte bit) {
        switch (bit) {
            case 0x00:
                return DefaultPacket.class;
        }
        return Packet.class;
    }

}
