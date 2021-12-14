/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.so_grupo29;

import java.io.IOException;

/**
 *
 * @author luism
 */
public class Aspersores implements Runnable {

    Util util = new Util();

    public enum State {
        Parado,
        Aspiracao,
        Secagem
    };
    private final State state = State.Parado;

    public Aspersores(Util util) {
        this.util = util;
    }

    @Override
    public void run() {
        try {
            int seconds_aspersores = (int) util.getDuracaoAspersores();
            int seconds_secador = (int) util.getDuracaoSecagem();
            //(int) (Math.random() * (6 - 3 + 1)) + 3;
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
