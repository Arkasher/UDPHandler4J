package com.yan.udphandler4j;

import com.yan.udphandler4j.async.QueuedThread;
import com.yan.udphandler4j.packets.PacketHandler;
import com.yan.udphandler4j.server.Server;

/**
 * Classe principal do gerenciador
 * @author Yan
 */
public class UDPHandler4J {

    /**
     * Inicia a fila dos pacotes, inicia o servidor UDP e carrega os pacotes
     *
     * @param args
     */
    public static void main(String args[]) {
        PacketHandler packetHandler = new PacketHandler();
        packetHandler.loadPackets();
        
        QueuedThread.startQueue();

        Server server = new Server(9876, 1024);
        server.startAndListen();
    }
}
