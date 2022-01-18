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
public class Tapete implements Runnable {
    Util util = new Util();

    public Tapete(Util util) {
        this.util = util;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Tapete - O Carro chegou ao ponto de lavagem");
            util.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tapete - O Carro chegou ao Fim");
    }
}
