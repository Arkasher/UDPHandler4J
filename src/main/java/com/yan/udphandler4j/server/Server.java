package com.yan.udphandler4j.server;

import com.yan.udphandler4j.async.QueuedThread;
import com.yan.udphandler4j.models.Preferences;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Instancia do Servidor
 *
 * @author Yan
 */
public class Server {

    private int port;
    private byte[] buffer;

    private Preferences preferences;

    private DatagramSocket datagramSocket;

    /**
     * Construtor
     *
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

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }

    /**
     * Inicia o servidor UDP
     */
    public void startAndListen() {
        try {
            if (!getPreferences().isRandomPort()) {
                datagramSocket = new DatagramSocket(port);
            } else {
                datagramSocket = new DatagramSocket();
            }
            System.out.println("Servidor iniciado na porta " + datagramSocket.getLocalPort());
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(buffer,
                        buffer.length);
                datagramSocket.receive(receivePacket);

                QueuedThread.queue.add(receivePacket);
            }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao iniciar o servidor: " + ex.getLocalizedMessage());
            System.exit(0);
        }
    }

}
