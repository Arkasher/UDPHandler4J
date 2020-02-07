package com.yan.udphandler4j.errors;

/**
 *
 * @author ybroe
 */
public class PacketIdAlreadyRegisteredException extends Throwable {

    public PacketIdAlreadyRegisteredException(String errorMessage) {
        super(errorMessage);
    }

}
