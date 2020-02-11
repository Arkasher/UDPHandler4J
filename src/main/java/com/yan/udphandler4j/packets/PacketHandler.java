package com.yan.udphandler4j.packets;

import com.yan.udphandler4j.UDPHandler4J;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.Set;
import org.reflections.Reflections;

/**
 * Classe que gerencia os pacotes
 *
 * @author Yan
 */
public class PacketHandler {

    /**
     * Array de de pacotes que heram a classe Packet para o sistema tratar
     */
    private static final ArrayList<Packet> packets = new ArrayList<>();

    /**
     * Array de Strings para o sistema procurar por classes que herdam a classe
     * Packet
     */
    private static final ArrayList<Package> registeredPackages = new ArrayList<>();

    /**
     * Recebe um DatagramPacket e trata
     *
     * @param datagramPacket
     */
    public void handle(DatagramPacket datagramPacket) {
        byte[] data = datagramPacket.getData();

        Packet receivedPacket = getPacketClass(data[0]);
        receivedPacket.handle(datagramPacket);
    }

    /**
     * Retorna o pacote buscando pelo id do mesmo
     *
     * @param bit
     * @return
     */
    private Packet getPacketClass(byte bit) {
        for (Packet packet1 : packets) {
            if (packet1.getId() == bit) {
                return packet1;
            }
        }
        return new WrongPacket();
    }

    /**
     * Carrega os pacotes do sistema
     */
    public void loadPackets() {
        loadDefaultPackets();

        System.out.println("Carregando lista de pacotes...");
        registeredPackages.forEach((javaPackage) -> {
            packets.addAll(getPacketClasses(javaPackage));
        });
        System.out.println("Lista de pacotes (" + packets.size() + ") carregada com sucesso.");
    }

    /**
     * Retorna a lista de pacotes
     *
     * @return ArrayList<Packet>
     */
    private ArrayList<Packet> getPacketClasses(Package javaPackage) {
        ArrayList<Packet> packetList = new ArrayList<>();

        /**
         * Identifica todas as classes do pacote que extende um Packet, e
         * carrega.
         */
        Reflections reflections = new Reflections(javaPackage.getName());
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
                System.out.println("Erro ao carregar um pacote. Erro: " + ex.getLocalizedMessage());
            }
        });
        return packetList;
    }

    /**
     * Adiciona um pacote de classes Java para o sistema buscar por pacotes.
     *
     * @param javaPacket
     */
    public static void registerJavaPackage(Package javaPackage) {
        registeredPackages.add(javaPackage);
        System.out.println("Pacote de classes Java " + javaPackage.getName() + " adicionado.");
    }

    /**
     * Carrega os pacotes padrões do sistema
     */
    private void loadDefaultPackets() {
        if (UDPHandler4J.getServer().getPreferences().hasDefaultPackets()) {
            registerJavaPackage(Package.getPackage("com.yan.udphandler4j"));
        }
    }
}
