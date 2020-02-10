package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

/**
 * Classe abstrata do pacote
 * @author Yan
 */
abstract class Packet {
   
    /**
     * Retorna o id do pacote
     * @return int
     */
    abstract int getId();
    
    /**
     * Define o id do pacote
     * Não use esse método, apenas se souber o que está fazendo
     * @param id 
     */
    abstract void setId(int id);
    
    /**
     * Trata o pacote
     * @param datagramPacket 
     */
    abstract void handle(DatagramPacket datagramPacket);
    
}
