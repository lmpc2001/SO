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
public class Rolos implements Runnable {
    Util util = new Util();

    public Rolos(Semaphore sem, Util util) {
        this.util = util;
    }

    @Override
    public void run() {
        try {
            int randTime = (int) Math.random() * (8 - 4 + 1) + 4;
            util.writeLogs("Rolos Ativados");

            System.out.println("Rolos Ativados");
            Thread.sleep(randTime * 1000);
            System.out.println("Rolos Desativados");
            util.writeLogs("Rolos Desativados");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
