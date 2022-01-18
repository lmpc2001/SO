/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// package com.mycompany.so_grupo29;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author luism
 */
public class Moedeiro implements ActionListener, Runnable {
    private Semaphore sem;
    Util util = new Util();
    JFrame janela;

    public Moedeiro(Semaphore sem, Util util) {
        this.sem = sem;
        this.util = util;
    }

    public void menu() {
        janela = new JFrame("Moedeiro");

        // define layout para janela
        janela.getContentPane().setLayout(new FlowLayout());

        JButton botaoI = new JButton("I");
        JButton botaoC = new JButton("C");
        JButton botaoE = new JButton("E");
        JButton botaoR = new JButton("R");
        JLabel labelI = new JLabel("Iniciar Lavagem");
        JLabel labelC = new JLabel("Cancelar Lavagem");
        JLabel labelE = new JLabel("Emergência");
        JLabel labelR = new JLabel("Reiniciar sistema");

        // define listeners para botões
        botaoI.addActionListener(this);
        botaoC.addActionListener(this);
        botaoE.addActionListener(this);
        botaoR.addActionListener(this);

        // adiciona botões à janela
        janela.add(botaoI);
        janela.add(labelI);
        janela.add(botaoC);
        janela.add(labelC);
        janela.add(botaoE);
        janela.add(labelE);
        janela.add(botaoR);
        janela.add(labelR);

        janela.setSize(300, 400);
        // janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        // este código pode ser melhorado
        if (action.equals("I")) {
            util.setButton("I");
            sem.release();
        } else if (action.equals("C")) {
            util.setButton("C");
            sem.release();
        } else if (action.equals("E")) {
            util.setButton("E");
            sem.release();
        } else if (action.equals("R")) {
            util.setButton("R");
            sem.release();
        }
    }

    @Override
    public void run() {
        menu();
    }

}
