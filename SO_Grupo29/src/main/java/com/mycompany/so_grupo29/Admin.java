package com.mycompany.so_grupo29;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.Semaphore;

/**
 * Tem a função de abrir as janelas de interação com o utilizador.
 * Atualizar o valor da variavel util dependendo do botão clicado. 
 * @author grupo29
 */
public class Admin implements ActionListener, Runnable {

    private Semaphore sem;
    Util util = new Util();
    JFrame janela;

    /**
     * Construtor da classe Admin
     * @param sem semafro
     * @param util variavel com os valores dos botões
     */
    public Admin(Semaphore sem, Util util) {
        this.sem = sem;
        this.util = util;
    }

    /**
     * Mostra o menu de escolhas ao utilizador
     */
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

    /**
     * Aciona os botões consoante a escolha do utilizador 
     * @param ae ação do botão
     */
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
    
    /**
     * Roda a variavel menu quando ativada a thread
     */
    @Override
    public void run() {
        menu();
    }
}
