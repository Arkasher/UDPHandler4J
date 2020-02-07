package com.yan.udphandler4j.async;

import com.yan.udphandler4j.packets.PacketHandler;
import java.net.DatagramPacket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueuedThread {

    public static BlockingQueue<DatagramPacket> queue = new LinkedBlockingQueue<>();

    public static void startQueue() {
        PacketHandler handler = new PacketHandler();
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    DatagramPacket packet = queue.take();
                    
                    handler.handle(packet);
                }
            } catch (InterruptedException exception) {
                startQueue();
            }
        });
        thread.start();
    }

}