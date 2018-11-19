/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

import java.io.BufferedReader;
import java.util.Date;


/**
 *
 * @author andre
 */
public class ModelArduino {

    private Date data;
    private String nomeLed;
    private float ledTempo;
   
   
    
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

    public void setLedTempo(int ledTempo) {
        this.ledTempo = ledTempo;
    }
    
    
   

    void verificaSeContaTempo(BufferedReader input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
