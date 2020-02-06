package com.yan.udphandler4j.server;

import com.yan.udphandler4j.async.QueuedThreads;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ybroe
 */
public class Server {

    private int port;
    private byte[] buffer;

    private DatagramSocket datagramSocket;
    
    /**
     * Construtor
     * @param port
     * @param bufferSize 
     */
    public Server(int port, int bufferSize) {
        this.port = port;
        this.buffer = new byte[bufferSize];
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    /**
     * Inicia o servidor UDP
     */
    public void startAndListen() {
        try {
            datagramSocket = new DatagramSocket(port);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(buffer,
                        buffer.length);
                datagramSocket.receive(receivePacket);

                QueuedThreads.queue.add(receivePacket);
            }
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
