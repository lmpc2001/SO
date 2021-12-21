package com.mycompany.so_grupo29;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Fiunção principal, tem como funcionalidade ativar todas as threads e retorna o troco ao cliente
 * @author grupo29
 */
public class Main implements Runnable {

    private static final Semaphore sem = new Semaphore(0, true);
    private static Util util = new Util();
    private static List<String> lstClients = new ArrayList<String>();
    private static int clientCounter = 0;
    private static double money;
    private static double price;
    private static String button;
    private static Thread th_main;
    private static final ThreadGroup thg_Washing = new ThreadGroup("Washing Group");
    private static boolean emergency = false;

    
    public static enum State {
        Livre,
        Ocupado,
        Fechado
    };

    public static State state = State.Fechado;

    /**
     * construtor da class main
     * @param util variavel com os valores dos botões
     * @param lstclients lista com os clientes por lavar 
     */
    public Main(Util util, List<String> lstclients) {
        Main.util = util;
        Main.lstClients = lstclients;
    }

    /**
     * Ativa as threads necessarias e retorna o troco ao utilizador
     * @param args command line argumentos
     * @throws java.lang.InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        Thread th_admin = new Thread(new Admin(sem, util), "TH_Admin");
        Thread th_window = new Thread(new Moedeiro(sem, util), "TH_Moedeiro");
        util.readConfig();

        th_admin.start();
        sem.acquire();

        validateButton();

        th_window.start();
        while (true) {
            sem.acquire();
            validateButton();
        }
    }

    /**
     * Função de troco 
     * @param price preco da lavagem
     * @param amount montante recebido pelo cliente
     * @return 
     */
    private static double validateAmount(double price, double amount) {
        if (amount >= price) {
            return amount - price;
        } else {
            return -1;
        }
    }

    /**
     * Inicializa a lavagem dos carros
     * @throws IOException
     * @throws InterruptedException 
     */
    private static void inicializeWash() throws IOException, InterruptedException {
        Thread th_aspressores = new Thread(thg_Washing, new Aspersores(util), "TH_Aspersores");
        Thread th_rolos = new Thread(thg_Washing, new Rolos(util), "TH_Rolos");
        Thread th_tapete = new Thread(thg_Washing, new Tapete(util), "TH_Tapete");

        util.setMoney(0);

        util.writeLogs("Lavagem do cliente " + lstClients.get(0) + " iniciada");

        if (state != State.Fechado) {
            state = State.Ocupado;
        }

        th_tapete.start();
        th_tapete.join(2000);

        th_aspressores.start();
        th_aspressores.join();

        th_rolos.start();
        th_rolos.join();

        Thread.sleep(3000);
        synchronized (util) {
            util.notifyAll();
        }

        lstClients.remove(0);

        if (state == State.Ocupado) {
            state = State.Livre;
        }
    }

    /**
     * Valida o valor do botão e executa as ações coorespondentes a cada um
     * @throws IOException
     * @throws InterruptedException 
     */
    private static void validateButton() throws IOException, InterruptedException {
        button = util.getButton();

        switch (button) {
            case "I":
                if (state != State.Fechado) {
                    price = util.getPrice();
                    money = util.getMoney();
                    double change = validateAmount(price, money);

                    if (state != State.Ocupado) {

                        if (change >= 0) {
                            System.out.println("Troco a receber: " + change + " euros");
                            clientCounter++;
                            lstClients.add("Cliente " + clientCounter);
                            th_main = new Thread(thg_Washing, new Main(util, lstClients), "TH_Main");
                            th_main.start();
                        } else {
                            System.out.println("Por favor insira um valor suficiente para a realização da tarefa!");
                            return;
                        }
                    } else {
                        if (change >= 0) {
                            System.out.println("entrei no estado ocupado");
                            System.out.println("Troco a receber: " + change + " euros");
                            clientCounter++;
                            lstClients.add("Cliente " + clientCounter);
                        } else {
                            System.out.println("Por favor insira um valor suficiente para a realização da tarefa!");
                            return;
                        }
                    }

                    System.out.println("Contador de clientes: " + clientCounter);
                } else {
                    System.out.println("O sistema encontra-se fechado!\nPor favor, aguarde.");
                }
                break;

            case "C":
                if (state == State.Ocupado) {
                    System.out.println("O sistema já se encontra em funcionamento!\nPor favor, agurde!");
                } else {
                    money = util.getMoney();
                    System.out.println("Valor devolvido: " + money);
                }
                break;

            case "E":
                if (!emergency) {
                    System.out.println("PARAGEM DE EMERGÊNCIA ACIONADO!");
                    util.writeLogs("Paragem de emergencia");
                    emergency = true;
                    thg_Washing.suspend();
                } else {
                    System.out.println("A retomar o normal funcionamento do sistema!");
                    util.writeLogs("Emergencia Resolvida");
                    emergency = false;
                    thg_Washing.resume();
                }

                break;

            case "R":
                System.out.println("R");

                break;

            case "A":
                System.out.println("Sistema Aberto");
                util.writeLogs("Sistema aberto");
                state = State.Livre;
                break;

            case "F":
                System.out.println("Sistema encerrado");
                util.writeLogs("Sistema encerrado");
                state = State.Fechado;
                break;
        }
    }

    /**
     * Função de execução para a thread
     */
    @Override
    public void run() {
        while (lstClients.size() > 0) {
            try {
                inicializeWash();
            } catch (IOException | InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " interrupted");
                return;
            }
        }
    }
}

// https://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
// https://www.geeksforgeeks.org/wait-method-in-java-with-examples/
