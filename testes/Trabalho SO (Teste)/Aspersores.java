/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// package com.mycompany.so_grupo29;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author luism
 */
public class Aspersores implements Runnable {
    Util util = new Util();

    public Aspersores(Semaphore sem, Util util) {
        this.util = util;
    }

    @Override
    public void run() {
        try {
            int randTime = (int) (Math.random() * (6 - 3 + 1)) + 3;
            util.writeLogs("Aspersores Ativados");

            System.out.println("Aspersores Ativados");
            Thread.sleep(5000);
            System.out.println("Aspersores Desativados");

            util.writeLogs("Aspersores Desativados");
            util.writeLogs("Secador Ativados");
            
            System.out.println("Secador Ativado");
            Thread.sleep(randTime * 1000);
            System.out.println("Secador Desativado");

            util.writeLogs("Secador Desativados");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
