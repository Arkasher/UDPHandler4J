package com.yan.udphandler4j.packets;

import java.net.DatagramPacket;

/**
 * Classe abstrata de um pacote
 * Caso seja necessário, deixe o setId hard-coded, inserindo manualmente o id do pacote;
 * Isso irá evitar alterações futuras em id's de pacotes
 * @author Yan
 */
public abstract class Packet {
   
    /**
     * Retorna o id do pacote
     * @return int
     */
    public abstract int getId();
    
    /**
     * Define o id do pacote
     * Não use esse método, apenas se souber o que está fazendo
     * @param id 
     */
    public abstract void setId(int id);
    
    /**
     * Trata o pacote
     * @param datagramPacket 
     */
    public abstract void handle(DatagramPacket datagramPacket);
    
}
