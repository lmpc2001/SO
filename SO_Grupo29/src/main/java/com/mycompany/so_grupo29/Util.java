/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.so_grupo29;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author luism
 */
public class Util {

    public String button_state;
    public double price;
    public double money;
    public long duracao_tapete;
    public long duracao_rolos;
    public long duracao_aspersores;
    public long duracao_secagem;

    public void setButton(String value) {
        this.button_state = value;
    }

    public String getButton() {
        return this.button_state;
    }

    public void setMoney(double value) {
        this.money = value;
    }

    public double getMoney() {
        return this.money;
    }

    public void setPrice(double value) {
        this.price = value;
    }

    public double getPrice() {
        return this.price;
    }

    public void setDuracaoTapete(long value) {
        this.duracao_tapete = value;
    }

    public double getDuracaoTapete() {
        return this.duracao_tapete;
    }

    public void setDuracaoRolos(long value) {
        this.duracao_rolos = value;
    }

    public double getDuracaoRolos() {
        return this.duracao_rolos;
    }

    public void setDuracaoAspersores(long value) {
        this.duracao_aspersores = value;
    }

    public double getDuracaoAspersores() {
        return this.duracao_aspersores;
    }

    public void setDuracaoSecagem(long value) {
        this.duracao_secagem = value;
    }

    public double getDuracaoSecagem() {
        return this.duracao_secagem;
    }

    public void writeLogs(String event) throws IOException {
        FileWriter writer = new FileWriter("logs.txt", true);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern(("dd/MM/yyyy - HH:mm:ss"));
        String finalDate = date.format(formatedDate);
        writer.write(finalDate + " : " + event + "\n");
        writer.close();
    }

    public void readConfig() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader("config.json"));
            JSONObject jsonObj = (JSONObject) object;

            setPrice((double) jsonObj.get("custo"));
            setDuracaoTapete((long) jsonObj.get("duracao_tapete"));
            setDuracaoRolos((long) jsonObj.get("duracao_rolos"));
            setDuracaoAspersores((long) jsonObj.get("duracao_aspersores"));
            setDuracaoSecagem((long) jsonObj.get("duracao_secagem"));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}
