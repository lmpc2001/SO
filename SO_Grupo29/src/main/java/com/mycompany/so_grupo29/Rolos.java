package com.mycompany.so_grupo29;

import java.io.IOException;
/**
 * Classe para ativar e desativar os rolos 
 * @author grupo29
 */
public class Rolos implements Runnable {
    Util util = new Util();
    
    public enum State {
        Parado,
        Ativo
    };
    
    private final State state = State.Parado;

   /**
    * Constrotor da class Rolos 
    * @param util variavel com os valores dos botões
    */
    public Rolos(Util util) {
        this.util = util;
    }

    /**
     * função de execução da thread 
     */
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
