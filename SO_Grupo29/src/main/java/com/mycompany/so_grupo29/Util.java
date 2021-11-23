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
 * @param <T>
 */
public class Util<T> {
    
    public Util (){
        
    }
    
    public <T> T getDataFromUser(){
        Scanner scan = new Scanner(System.in);
        T result = (T) scan.nextLine();
        return result;
    }
    
    
}
