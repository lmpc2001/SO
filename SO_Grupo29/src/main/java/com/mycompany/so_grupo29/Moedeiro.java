/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.so_grupo29;

import java.util.Scanner;

/**
 *
 * @author luism
 */
public class Moedeiro {

    private final double amount = 5.00;
    private String system_state = "Fechado";

    public Moedeiro(String state) {
        this.system_state = state;
    }

    public void setMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o valor da lavagem (5.00): ");
        int value = Integer scan.nextLine(); 

    }

    public void Menu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("****************\n");
        System.out.println("I - Iniciar Lavagem\n");
        System.out.println("C - Cancelar Lavagem\n");
        System.out.println("E - Botão de Emergencia\n");
        System.out.println("R - Reset do Sistema\n");
        System.out.println("A/F - Aberto/Fechado\n");
        String response = scan.nextLine();
        System.out.println(response);
        System.out.println("****************\n\n");
    }
}
