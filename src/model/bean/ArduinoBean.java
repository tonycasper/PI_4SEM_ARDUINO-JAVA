/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.BufferedReader;
import java.sql.Date;

/**
 *
 * @author andre
 */
public class ArduinoBean {


    private Date data;
    private String nomeLed;
    private long ledTempo;
   
    public ArduinoBean(String nome, long tempo){
        this.nomeLed = nome;
        this.ledTempo = tempo;
    }
    
    public ArduinoBean(){
        
    }
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }   
    
    public String getNomeLed() {
        return nomeLed;
    }

    public void setNomeLed(String nomeLed) {
        this.nomeLed = nomeLed;
    }

    public float getLedTempo() {
        return ledTempo;
    }

    public void setLedTempo(long ledTempo) {
        this.ledTempo = ledTempo;
    }
}
