/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.so_grupo29;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author luism
 */
public class Admin implements ActionListener, Runnable {

    private Semaphore sem;
    Util util = new Util();
    JFrame janela;

    public Admin(Semaphore sem, Util util) {
        this.sem = sem;
        this.util = util;
    }

    public void menu() {
        janela = new JFrame("Admin");

        janela.getContentPane().setLayout(new FlowLayout());

        JButton botaoA = new JButton("A");
        JButton botaoF = new JButton("F");

        botaoA.addActionListener(this);
        botaoF.addActionListener(this);

        janela.add(botaoA);
        janela.add(botaoF);

        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        switch (action) {
            case "A":
                util.setButton("A");
                sem.release();
                break;
            case "F":
                util.setButton("F");
                sem.release();
                break;
        }
    }

    @Override
    public void run() {
        menu();
    }
}
