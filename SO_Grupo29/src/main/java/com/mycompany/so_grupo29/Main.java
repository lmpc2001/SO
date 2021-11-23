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
public class Main {

    private static String state = "Fechado";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
        do {

        } while (state == "Aberto");
    }

    private static void menu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("****************\n");
        System.out.println("Deseja iniciar a lavagem?\n");
        String response = scan.nextLine();
        System.out.println(response);
        System.out.println("****************\n\n");
        if (response.equals("s")) {
            state = "Aberto";
        }
    }
}
