package project16;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.dao.ArduinoDAO;

public class ControlePorta implements SerialPortEventListener {

    private double[] dataLedR = null;
    private double[] dataLedY = null;
    private double[] dataLedG = null;
    
    ArrayList<ModelArduino> tempoLedR = new ArrayList();
    ArrayList<ModelArduino> tempoLedY = new ArrayList();
    ArrayList<ModelArduino> tempoLedG = new ArrayList();

    ArduinoDAO dao;

    SerialPort serialPort;
    private OutputStream serialOut;
    private int taxa;
    private String portaCOM;
    private OutputStream output;

    public ModelArduino ard = new ModelArduino();
        
    //input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
    private BufferedReader input;

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                System.out.println(inputLine);
                MonitoraArduino.getInstance().verificaSeContaTempo(inputLine);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    /**
     * Construtor da classe ControlePorta
     *
     * @param portaCOM - Porta COM que será utilizada para enviar os dados para
     * o arduino
     * @param taxa - Taxa de transferência da porta serial geralmente é 9600
     */
    public ControlePorta(String portaCOM, int taxa) {
        this.portaCOM = portaCOM;
        this.taxa = taxa;
        this.initialize();
    }

    /**
     * Médoto que verifica se a comunicação com a porta serial está ok
     */
    private void initialize() {
        try {
            //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
            CommPortIdentifier portId = null;
            try {
                //Tenta verificar se a porta COM informada existe
                portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
            } catch (NoSuchPortException npe) {
                //Caso a porta COM não exista será exibido um erro 
                JOptionPane.showMessageDialog(null, "Porta COM não encontrada.",
                        "Porta COM", JOptionPane.PLAIN_MESSAGE);
            }
            //Abre a porta COM 
            SerialPort port = (SerialPort) portId.open("Comunicação serial", this.taxa);
            serialOut = port.getOutputStream();
            port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                    SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                    SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                    SerialPort.PARITY_NONE); //receber e enviar dados

            // open the streams
            input = new BufferedReader(new InputStreamReader(port.getInputStream()));
            output = port.getOutputStream();

            // add event listeners
            port.addEventListener(this);
            port.notifyOnDataAvailable(true);

        } catch (Exception e) {
            e.printStackTrace();
//      jlbNotificacao.setText("");
        }
    }

    /**
     * Método que fecha a comunicação com a porta serial
     */
    public void close() {
        try {
            serialOut.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar porta COM.",
                    "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * @param opcao - Valor a ser enviado pela porta serial
     */
    public void enviaDados(int opcao) {
        try {
            serialOut.write(opcao);//escreve o valor na porta serial para ser enviado
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
                    "Enviar dados", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void salvaDadosMemoria() {

    }

    public void acrescentaTempoBD(ModelArduino arduino) {
        //dao = new ArduinoDAO();
        if (arduino.getLedTempo() != 0) {
            //dao.create(arduino);
        } else {

        }
    }

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

//    public double[] getDataLedR() {
//        for (int i = 0; i < listaLedR.size(); i++) {
//            ModelArduino ar = listaLedR.get(i);
//            dataLedR[i] = ar.getLedTempo();
//        }
//
//        return this.dataLedR;
//    }

    public void setDataLedR(double[] dataLedR) {
        this.dataLedR = dataLedR;
    }

//    public double[] getDataLedY() {
//        for (int i = 0; i < listaLedY.size(); i++) {
//            ModelArduino ar = listaLedY.get(i);
//            dataLedR[i] = ar.getLedTempo();
//        }
//        return this.dataLedY;
//    }

    public void setDataLedY(double[] dataLedY) {
        this.dataLedY = dataLedY;
    }

//    public double[] getDataLedG() {
//        for (int i = 0; i < listaLedG.size(); i++) {
//            ModelArduino ar = listaLedG.get(i);
//            dataLedG[i] = ar.getLedTempo();
//        }
//        return dataLedG;
//    }

    public void setDataLedG(double[] dataLedG) {
        this.dataLedG = dataLedG;
    }

}
