
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
 * Classe responsavel por toda a leitura dos settings pelo ficheiro json, escrita de logs, 
 * atriduição de variaveis aos botões   
 * @author grupo29
 */
public class Util {

    public String button_state;
    public double price;
    public double money;
    public long duracao_tapete;
    public long duracao_rolos;
    public long duracao_aspersores;
    public long duracao_secagem;

    /**
     * Atribui um valor ao botão
     * @param value valor do botão
     */
    public void setButton(String value) {
        this.button_state = value;
    }

    /**
     * retorna o valor do botão
     * @return 
     */
    public String getButton() {
        return this.button_state;
    }

    /**
     * Atribui o valor recebido do cliente
     * @param value valor do cliente
     */
    public void setMoney(double value) {
        this.money = value;
    }

    /**
     * retorna o valor recebido do cliente 
     * @return valor do cliente
     */
    public double getMoney() {
        return this.money;
    }

    /**
     * Atribui um valor à lavagem
     * @param value valor da lavagem
     */
    public void setPrice(double value) {
        this.price = value;
    }
    
    /**
     * retorna o valor da lavagem
     * @return valor da lavagem
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Atribui o tempo de duração do tapete
     * @param value tempo do tapete
     */
    public void setDuracaoTapete(long value) {
        this.duracao_tapete = value;
    }

    /**
     * retorna o tempo de açáo do tapete
     * @return tempo do tapete
     */
    public double getDuracaoTapete() {
        return this.duracao_tapete;
    }

    /**
     * Atribui o tempo de duração dos rolos
     * @param value 
     */
    public void setDuracaoRolos(long value) {
        this.duracao_rolos = value;
    }

    /**
     * retorna o tempo de duração dos rolos
     * @return duração dos rolos
     */
    public double getDuracaoRolos() {
        return this.duracao_rolos;
    }

    /**
     * Atribui o tempo de duração dos aspersores
     * @param value duração dos aspersores
     */
    public void setDuracaoAspersores(long value) {
        this.duracao_aspersores = value;
    }

    /**
     * 
     * @return 
     */
    public double getDuracaoAspersores() {
        return this.duracao_aspersores;
    }

    /**
     * Atribui o tempo de duração da secagem
     * @param value tempo da secagem
     */
    public void setDuracaoSecagem(long value) {
        this.duracao_secagem = value;
    }
    
    /**
     * retorna o valor da duração da secagem
     * @return duração da secagem
     */
    public double getDuracaoSecagem() {
        return this.duracao_secagem;
    }

    /**
     * Função que escreve os logs 
     * @param event evento a escrever no ficheiro
     * @throws IOException 
     */
    public void writeLogs(String event) throws IOException {
        FileWriter writer = new FileWriter("logs.txt", true);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern(("dd/MM/yyyy - HH:mm:ss"));
        String finalDate = date.format(formatedDate);
        writer.write(finalDate + " : " + event + "\n");
        writer.close();
    }
    
    /**
     * le o ficheiro de cofigurações 
     * @throws IOException 
     */
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
