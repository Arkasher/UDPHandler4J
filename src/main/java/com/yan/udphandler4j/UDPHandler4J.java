package com.yan.udphandler4j;

import com.yan.udphandler4j.async.QueuedThreads;
import com.yan.udphandler4j.server.Server;

public class UDPHandler4J {

    /**
     * Inicia a fila dos pacotes e inicia o servidor UDP
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) {

        QueuedThreads.startQueue();

        Server server = new Server(9876, 1024);
        server.startAndListen();
    }
}
