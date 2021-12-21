package com.mycompany.so_grupo29;

import java.io.IOException;

/**
 * Classe com a funcionalidade de ligar e ligar os aspersores e os secadores
 * @author grupo29
 */
public class Aspersores implements Runnable {

    Util util = new Util();

    public enum State {
        Parado,
        Aspiracao,
        Secagem
    };
    private final State state = State.Parado;

    /**
     * Construtor da Classe Aspersores
     * @param util variavel com os valores dos botões
     */
    public Aspersores(Util util) {
        this.util = util;
    }

    /**
     * Função que executa os aspersores e os secadores
     */
    @Override
    public void run() {
        try {
            int seconds_aspersores = (int) util.getDuracaoAspersores();
            int seconds_secador = (int) util.getDuracaoSecagem();
            util.writeLogs("Aspersores Ativados");

            System.out.println("Aspersores Ativados");
            Thread.sleep(seconds_aspersores * 1000);
            System.out.println("Aspersores Desativados");

            util.writeLogs("Aspersores Desativados");
            util.writeLogs("Secador Ativados");

            System.out.println("Secador Ativado");
            Thread.sleep(seconds_secador * 1000);
            System.out.println("Secador Desativado");

            util.writeLogs("Secador Desativados");

        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
