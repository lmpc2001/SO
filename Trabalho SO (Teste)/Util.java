/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package com.mycompany.so_grupo29;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author luism
 */
public class Util {
    public String button_state;

    public void setButton(String value){
        this.button_state = value;
    }
    
    public String getButton(){
        return this.button_state;
    }

    public void writeLogs(String event) throws IOException{
        FileWriter writer = new FileWriter("logs.txt", true);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern(("dd/mm/yyyy - HH:mm:ss"));
        String finalDate = date.format(formatedDate);
        writer.write(finalDate + " : " + event + "\n");
        writer.close();
    }
    
}
