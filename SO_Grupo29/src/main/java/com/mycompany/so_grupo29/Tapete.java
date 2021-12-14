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
public class Tapete implements Runnable {
    Util util = new Util();
    public enum State {
        Parado,
        Ativo
    };
    private final State state = State.Parado;

    public Tapete(Util util) {
        this.util = util;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Tapete - O Carro chegou ao ponto de lavagem");
            util.writeLogs("Tapete - O Carro chegou ao ponto de lavagem");
            synchronized (util) {
                try {
                    util.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " interrupted");
                    return;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Tapete - O Carro chegou ao Fim");
        try {
            util.writeLogs("Tapete - O Carro chegou ao Fim");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
