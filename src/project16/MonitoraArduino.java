/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import model.dao.ArduinoDAO;

/**
 *
 * @author andre
 */
public class MonitoraArduino {

    private boolean contantoTempoG = false;
    private boolean contandoTempoY = false;
    private boolean contantoTempoR = false;

    private double[] dataLedR = null;
    private double[] dataLedY = null;
    private double[] dataLedG = null;

    static ArrayList<ModelArduino> listaLedR = new ArrayList();
    static ArrayList<ModelArduino> listaLedY = new ArrayList();
    static ArrayList<ModelArduino> listaLedG = new ArrayList();

    ArrayList<ModelArduino> tempoLedR = new ArrayList();
    ArrayList<ModelArduino> tempoLedY = new ArrayList();
    ArrayList<ModelArduino> tempoLedG = new ArrayList();
    
    ArduinoDAO dao = new ArduinoDAO();
    
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

    //implementando o singleton
    public static synchronized MonitoraArduino getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MonitoraArduino();
        }
        return INSTANCE;
    }

    void verificaSeContaTempo(String in) throws ParseException {
        //arduino que vai receber os parametros
        ModelArduino arduino = new ModelArduino();
        //verifica se esta vindo sinal de ligado e se esta contanto o tempo do led
        if (in.equals("ledGStart") && !contantoTempoG) {
            Date data = new Date();
            arduino.setData(data);
            arduino.setNomeLed("LED VERDE");
            listaLedG.add(arduino);
            contantoTempoG = true;
            
        } else if (in.equals("ledRStart") && !contantoTempoR) {
            Date data = new Date();
            arduino.setData(data);
            listaLedR.add(arduino);
            arduino.setNomeLed("LED VERMELHO");
            contantoTempoR = true;
        } else if (in.equals("ledYStart") && !contandoTempoY) {
            Date data = new Date();
            arduino.setData(data);
            arduino.setNomeLed("LED AMARELO");
            listaLedY.add(arduino);
            contandoTempoY = true;
        } else //verifica se esta vindo sinal de desligar do led e se esta contando tempo
        if (in.equals("ledGStop") && contantoTempoG) {
            Date data = new Date();
            arduino.setData(data);
            contantoTempoG = false;
            arduino.setNomeLed("LED VERDE");
            verificaTempo(arduino);
        } else if (in.equals("ledYStop") && contandoTempoY) {
            Date data = new Date();
            arduino.setData(data);
            listaLedY.add(arduino);
            arduino.setNomeLed("LED AMARELO");
            contandoTempoY = false;
            verificaTempo(arduino);
        } else if (in.equals("ledRStop") && contantoTempoR) {
            Date data = new Date();
            arduino.setData(data);
            contantoTempoR = false;
            arduino.setNomeLed("LED VERMELHO");
            verificaTempo(arduino);

        }
    }

    public void verificaTempo(ModelArduino ar) throws ParseException {
        //modelo do objeto que vai receber o metodo
        ModelArduino arduino;
        long tempo = 0;
        //verifica o nome do led e se a possui um led na lista para nao dar exception
        if (ar.getNomeLed().equals("LED VERMELHO") && listaLedR.get(0) != null) {
            //seta que o arduino é o primeiro da lista 
            arduino = listaLedR.get(0);
            //compara o tempo dos dois arduinos
            tempo = ar.getData().getTime() - arduino.getData().getTime();
            ar.setLedTempo(tempo);
            tempoLedR.add(ar);
            listaLedR.clear();
            //acrescentaTempoBD(ar);
            //salvaDadosMemoria();
            dao.create(ar);
            MonitoraArduino.getInstance().setDataLedY(this.getDataLedY());
            MonitoraArduino.getInstance().setTempoLedG(tempoLedR);
            System.out.println(ar.getNomeLed() + "Ligado as " + ar.getData().toString());
            System.out.println("com o total de tempo de " + ar.getLedTempo() + "Milisegundos");

        } else if (ar.getNomeLed().equals("LED AMARELO") && listaLedY.get(0) != null) {
            arduino = listaLedY.get(0);
            tempo = ar.getData().getTime() - arduino.getData().getTime();
            ar.setLedTempo(tempo);
            listaLedY.clear();
            tempoLedY.add(ar);
            //acrescentaTempoBD(ar);
            //salvaDadosMemoria();
            dao.create(ar);
            MonitoraArduino.getInstance().setTempoLedY(tempoLedY);
            MonitoraArduino.getInstance().setDataLedY(this.getDataLedY());
            System.out.println(ar.getNomeLed() + "Ligado as " + ar.getData().toString());
            System.out.println("com o total de tempo de " + ar.getLedTempo() + "Milisegundos");
        }
        if (ar.getNomeLed().equals("LED VERDE") && listaLedG.get(0) != null) {
            arduino = listaLedG.get(0);
            tempo = ar.getData().getTime() - arduino.getData().getTime();
            ar.setLedTempo(tempo);
            listaLedG.clear();
            tempoLedG.add(ar);
            //acrescentaTempoBD(ar);
            //salva dados em memoria
            //salvaDadosMemoria();
            dao.create(ar);
            MonitoraArduino.getInstance().setTempoLedG(tempoLedG);
            MonitoraArduino.getInstance().setDataLedG(this.getDataLedG());
            System.out.println(ar.getNomeLed() + "Ligado as " + ar.getData().toString());
            System.out.println("com o total de tempo de " + ar.getLedTempo() + "Milisegundos");
        }

    }

}
