/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class MonitoraArduino {

    private double[] dataLedR = null;
    private double[] dataLedY = null;
    private double[] dataLedG = null;

    ArrayList<ModelArduino> tempoLedR = new ArrayList();
    ArrayList<ModelArduino> tempoLedY = new ArrayList();
    ArrayList<ModelArduino> tempoLedG = new ArrayList();

    public ArrayList<ModelArduino> getTempoLedR() {
        return tempoLedR;
    }

    public void setTempoLedR(ArrayList<ModelArduino> tempoLedR) {
        this.tempoLedR = tempoLedR;
    }

    public ArrayList<ModelArduino> getTempoLedY() {
        return tempoLedY;
    }

    public void setTempoLedY(ArrayList<ModelArduino> tempoLedY) {
        this.tempoLedY = tempoLedY;
    }

    public ArrayList<ModelArduino> getTempoLedG() {
        return tempoLedG;
    }

    public void setTempoLedG(ArrayList<ModelArduino> tempoLedG) {
        this.tempoLedG = tempoLedG;
    }

  
    public double[] getDataLedR() {
        return dataLedR;
    }

    public void setDataLedR(double[] dataLedR) {
        this.dataLedR = dataLedR;
    }

    public double[] getDataLedY() {
        return dataLedY;
    }

    public void setDataLedY(double[] dataLedY) {
        this.dataLedY = dataLedY;
    }

    public double[] getDataLedG() {
        return dataLedG;
    }

    public void setDataLedG(double[] dataLedG) {
        this.dataLedG = dataLedG;
    }

    //atributos nao visiveis fora da classe
    private static MonitoraArduino INSTANCE = new MonitoraArduino();

    public static synchronized MonitoraArduino getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MonitoraArduino();
        }
        return INSTANCE;
    }
    
    
    private MonitoraArduino() {

    }

}
