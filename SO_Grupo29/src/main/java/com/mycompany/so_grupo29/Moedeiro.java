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
public class Moedeiro implements ActionListener, Runnable {
    private final Semaphore sem;
    Util util = new Util();
    JFrame janela;
    JTextField txtMoney = new JTextField();
    public JLabel labelStateValue = new JLabel();

    public Moedeiro(Semaphore sem, Util util) {
        this.sem = sem;
        this.util = util;
    }

    public void moneyBox() {
        janela = new JFrame("Money Box");

        janela.getContentPane().setLayout(new FlowLayout());

        JButton botaoConfirmar = new JButton("Confirmar");

        botaoConfirmar.addActionListener(this);

        txtMoney.setSize(100, 50);

        janela.add(txtMoney);
        janela.add(botaoConfirmar);

        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void menu() {
        janela = new JFrame("Moedeiro");

        janela.getContentPane().setLayout(new FlowLayout());

        JButton botaoI = new JButton("I");
        JButton botaoC = new JButton("C");
        JButton botaoE = new JButton("E");
        JButton botaoR = new JButton("R");
        JLabel labelI = new JLabel("Iniciar Lavagem");
        JLabel labelC = new JLabel("Cancelar Lavagem");
        JLabel labelE = new JLabel("Emergência");
        JLabel labelR = new JLabel("Reiniciar sistema");

        botaoI.addActionListener(this);
        botaoC.addActionListener(this);
        botaoE.addActionListener(this);
        botaoR.addActionListener(this);

        janela.add(botaoI);
        janela.add(labelI);
        janela.add(botaoC);
        janela.add(labelC);
        janela.add(botaoE);
        janela.add(labelE);
        janela.add(botaoR);
        janela.add(labelR);

        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        switch (action) {
            case "I":
                util.setButton("I");
                sem.release();
                break;
            case "C":
                util.setButton("C");
                sem.release();
                break;
            case "E":
                util.setButton("E");
                sem.release();
                break;
            case "R":
                util.setButton("R");
                sem.release();
                break;
            case "F":
                util.setButton("F");
                sem.release();
                break;
            case "Confirmar":
                util.setMoney(Double.parseDouble(txtMoney.getText()));
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        moneyBox();
        menu();
    }

}
