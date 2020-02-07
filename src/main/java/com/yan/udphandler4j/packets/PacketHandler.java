package com.yan.udphandler4j.packets;

import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.reflections.Reflections;

/**
 * Classe que gerencia os pacotes
 * @author Yan
 */
public class PacketHandler {

    private static final ArrayList<Packet> packets = new ArrayList<>();

    /**
     * Recebe um DatagramPacket e trata
     * @param datagramPacket 
     */
    public void handle(DatagramPacket datagramPacket) {
        byte[] data = datagramPacket.getData();

        Packet handledPacket = getPacketClass(data[0]);
        handledPacket.handle(datagramPacket);
    }

    /**
     * Retorna o pacote buscando pelo id do mesmo
     * @param bit
     * @return 
     */
    private Packet getPacketClass(byte bit) {
        for (Packet packet1 : packets) {
            if ((byte) packet1.getId() == bit) {
                return packet1;
            }
        }
        return null;
    }

    /**
     * Carrega os pacotes do sistema
     */
    public void loadPackets() {
        System.out.println("Carregando lista de pacotes...");
        packets.addAll(getPacketClasses());
        System.out.println("Lista de pacotes (" + packets.size() + ") carregada com sucesso.");
    }

    /**
     * Retorna a lista de pacotes
     * @return ArrayList<Packet>
     */
    private ArrayList<Packet> getPacketClasses() {
        ArrayList<Packet> packetList = new ArrayList<>();

        Reflections reflections = new Reflections("com.yan.udphandler4j.packets");
        Set<Class<? extends Packet>> classes = reflections.getSubTypesOf(Packet.class);
        classes.stream().map((Class<? extends Packet> aClass) -> {
            return aClass;
        }).forEachOrdered((aClass) -> {
            try {
                Packet packet = aClass.getConstructor().newInstance();
                packet.setId(packetList.size());
                System.out.println("Pacote " + packet.getClass().getName() + " (" + packet.getId() + ") carregado.");
                packetList.add(packet);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(PacketHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return packetList;
    }

}
