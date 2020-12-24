package com.yan.udphandler4j.async;

import com.yan.udphandler4j.UDPHandler4J;
import com.yan.udphandler4j.packets.PacketHandler;
import java.net.DatagramPacket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Classe gerenciadora da fila de pacotes
 * @author Yan
 */
public class QueuedThread {

    public static BlockingQueue<DatagramPacket> queue = new LinkedBlockingQueue<>();

    /**
     * Inicia a fila de pacotes
     */
    public static void startQueue() {
        PacketHandler handler = UDPHandler4J.getPacketHandler();
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    DatagramPacket packet = queue.take();
                    
                    handler.handle(packet);
                }
            } catch (InterruptedException exception) {
                /*
                  Se ocorrer algum erro, reinicia a fila
                 */
                startQueue();
            }
        });
        thread.start();
    }

}
