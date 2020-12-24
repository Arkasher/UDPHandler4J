package com.yan.udphandler4j.utils;

/**
 *
 * Classe que contém funções que não necessitam de uma classe especifica
 *
 * @author Yan
 */
public class Utils {

    /**
     * Retorna um argumento (booleano) buscado
     *
     * @param args
     * @param argument
     * @param defaultReturn
     * @return boolean
     */
    public static boolean getArg(String[] args, String argument, boolean defaultReturn) {
        for (String value : args) {
            String valueNoValue = value.split("=")[0];
            if (valueNoValue.equalsIgnoreCase(argument)) {
                return Boolean.parseBoolean(value.split("=")[1]);
            }
        }
        return defaultReturn;
    }

    /**
     * Retorna um argumento (inteiro) buscado
     *
     * @param args
     * @param argument
     * @param defaultReturn
     * @return int
     */
    public static int getArg(String[] args, String argument, int defaultReturn) {
        for (String value : args) {
            String valueNoValue = value.split("=")[0];
            if (valueNoValue.equalsIgnoreCase(argument)) {
                return Integer.parseInt(value.split("=")[1]);
            }
        }
        return defaultReturn;
    }

}
