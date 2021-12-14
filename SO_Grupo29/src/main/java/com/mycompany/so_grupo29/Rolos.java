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
public class Rolos implements Runnable {
    Util util = new Util();
    public enum State {
        Parado,
        Ativo
    };
    private final State state = State.Parado;

    public Rolos(Util util) {
        this.util = util;
    }

    @Override
    public void run() {
        try {
            int seconds = (int) util.getDuracaoRolos(); 
//            (int) Math.random() * (8 - 4 + 1) + 4;
            util.writeLogs("Rolos Ativados");

            System.out.println("Rolos Ativados");
            Thread.sleep(seconds * 1000);
            System.out.println("Rolos Desativados");
            util.writeLogs("Rolos Desativados");
        } catch (InterruptedException e) {
            System.out.println("Thread "+ Thread.currentThread().getName() + " interrupted");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
