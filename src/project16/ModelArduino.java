/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

import model.bean.*;
import java.io.BufferedReader;
import java.util.Date;

/**
 *
 * @author andre
 */
public class ModelArduino {


    private Date data;
    private String nomeLed;
    private long ledTempo;
    private String DataMarcada;

    public String getDataMarcada() {
        return DataMarcada;
    }

    public void setDataMarcada(String DataMarcada) {
        this.DataMarcada = DataMarcada;
    }
   
    public ModelArduino(String nome, long tempo){
        this.nomeLed = nome;
        this.ledTempo = tempo;
    }
    
    public ModelArduino(){
        
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
