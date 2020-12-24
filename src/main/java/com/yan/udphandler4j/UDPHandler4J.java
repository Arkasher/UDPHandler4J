package com.yan.udphandler4j;

import com.yan.udphandler4j.async.QueuedThread;
import com.yan.udphandler4j.models.Preferences;
import com.yan.udphandler4j.packets.PacketHandler;
import com.yan.udphandler4j.server.Server;
import com.yan.udphandler4j.utils.Utils;

/**
 * Classe principal do gerenciador
 *
 * @author Yan
 */
public class UDPHandler4J {

    private static Server server;
    private static PacketHandler packetHandler;

    /**
     * Inicia a fila dos pacotes, inicia o servidor UDP e carrega os pacotes
     *
     * @param args
     */
    public static void run(String[] args) {

        /*
          Carrega a lista de argumentos
         */
        boolean defaultPackets = Utils.getArg(args, "--default_packets", true);
        boolean randomPort = Utils.getArg(args, "--random_port", false);
        int port = Utils.getArg(args, "--port", 15500);
        int buffer = Utils.getArg(args, "--buffer", 1024);

        /*
          Carrega as preferencias
         */
        Preferences preferences = new Preferences();
        preferences.setDefaultPackets(defaultPackets);
        preferences.setRandomPort(randomPort);

        /*
          Instancia o servidor e define as preferencias para o servidor
         */
        server = new Server(port, buffer);
        server.setPreferences(preferences);

        /*
          Carrega os pacotes
         */
        packetHandler = new PacketHandler();
        packetHandler.loadPackets();

        /*
          Inicia a fila de pacotes
         */
        QueuedThread.startQueue();

        /*
          Inicia o servidor
         */
        server.startAndListen();
    }

    public static Server getServer() {
        return server;
    }
    
    public static PacketHandler getPacketHandler() {
        return packetHandler;
    }
}
