/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// package com.mycompany.so_grupo29;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author luism
 */
public class Main {

    public static enum State {
        Livre,
        Ocupado,
        Aberto,
        Fechado
    };

    public static State state = State.Fechado;

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        Semaphore sem = new Semaphore(0);
        Util util = new Util();
        List<String> lstClients = new ArrayList<String>();

        Thread th_admin = new Thread(new Admin(sem, util), "TH_Admin");
        Thread th_window = new Thread(new Moedeiro(sem, util), "TH_Moedeiro");
        Thread th_aspressores = new Thread(new Aspersores(sem, util), "TH_Aspersores");
        Thread th_rolos = new Thread(new Rolos(sem, util), "TH_Rolos");
        Thread th_tapete = new Thread(new Tapete(util), "TH_Tapete");
        String button;

        th_admin.start();

        sem.acquire();

        th_window.start();

        while (true) {
            sem.acquire();
            button = util.getButton();

            switch (button) {
                case "I":
                    util.writeLogs("Nova Lavagem Iniciada");
                    System.out.println("I");
                    state = State.Ocupado;

                    double value = 6.0;
                    double change = validateAmount(value);

                    if (change >= 0) {
                        System.out.println("Troco a receber: " + change + " euros");
                        th_tapete.start();
                        th_aspressores.start();
                        th_rolos.start();
                        Thread.sleep(3000);
                        util.notifyAll();
                    } else {
                        System.out.println("Por favor insira um valor suficiente para a realização da tarefa!");
                    }
                    break;

                case "C":
                    System.out.println("C");

                    break;

                case "E":
                    System.out.println("E");

                    break;

                case "R":
                    System.out.println("R");

                    break;

                case "A":
                    System.out.println("A");

                    break;

                case "F":
                    System.out.println("F");

                    break;

                default:
                    break;
            }
        }
    }

    private static double validateAmount(double amount) {
        double priceToPaid = 5;
        if (amount >= priceToPaid) {
            return amount - priceToPaid;
        } else {
            return -1;
        }
    }
}


// https://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
// https://www.geeksforgeeks.org/wait-method-in-java-with-examples/