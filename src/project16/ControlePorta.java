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

public class ControlePorta implements SerialPortEventListener {
    
    private static ControlePorta INSTANCE;
    private double[] dataLedR = null;
    private double[] dataLedY = null;
    private double[] dataLedG = null;

    private boolean contantoTempoG = false;
    private boolean contandoTempoY = false;
    private boolean contantoTempoR = false;

    static ArrayList<ModelArduino> listaLedR = new ArrayList();
    static ArrayList<ModelArduino> listaLedY = new ArrayList();
    static ArrayList<ModelArduino> listaLedG = new ArrayList();

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
    
    public static synchronized ControlePorta getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ControlePorta(String portaCOM, int taxa)
        }
        return INSTANCE;
    }
    
    //input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
    private BufferedReader input;

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                System.out.println(inputLine);
                verificaSeContaTempo(inputLine);
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

    void verificaSeContaTempo(String in) {
        //arduino que vai receber os parametros
        ModelArduino arduino = new ModelArduino();
        //verifica se esta vindo sinal de ligado e se esta contanto o tempo do led
        if (in.equals("ledGStart") && !contantoTempoG) {
            Date data = new Date();
            arduino.setData(data);
            arduino.setNomeLed("ledG");
            listaLedG.add(arduino);
            contantoTempoG = true;
        } else if (in.equals("ledRStart") && !contantoTempoR) {
            Date data = new Date();
            arduino.setData(data);
            listaLedR.add(arduino);
            arduino.setNomeLed("ledR");
            contantoTempoR = true;
        } else if (in.equals("ledYStart") && !contandoTempoY) {
            Date data = new Date();
            arduino.setData(data);
            arduino.setNomeLed("ledY");
            listaLedY.add(arduino);
            contandoTempoY = true;
        } else //verifica se esta vindo sinal de desligar do led e se esta contando tempo
        if (in.equals("ledGStop") && contantoTempoG) {
            Date data = new Date();
            arduino.setData(data);
            contantoTempoG = false;
            arduino.setNomeLed("ledG");
            verificaTempo(arduino);
        } else if (in.equals("ledYStop") && contandoTempoY) {
            Date data = new Date();
            arduino.setData(data);
            listaLedY.add(arduino);
            arduino.setNomeLed("ledY");
            contandoTempoY = false;
            verificaTempo(arduino);
        } else if (in.equals("ledRStop") && contantoTempoR) {
            Date data = new Date();
            arduino.setData(data);
            contantoTempoR = false;
            arduino.setNomeLed("ledR");
            verificaTempo(arduino);

        }
    }

    public void verificaTempo(ModelArduino ar) {
        //modelo do objeto que vai receber o metodo
        ModelArduino arduino;
        long tempo = 0;
        //verifica o nome do led e se a possui um led na lista para nao dar exception
        if (ar.getNomeLed().equals("ledR") && listaLedR.get(0) != null) {
            //seta que o arduino é o primeiro da lista 
            arduino = listaLedR.get(0);
            //compara o tempo dos dois arduinos
            tempo = ar.getData().getTime() - arduino.getData().getTime();
            
            ar.setLedTempo(tempo);
            tempoLedR.add(ar);
            listaLedR.clear();
            //acrescentaTempoBD(ar);
            //salvaDadosMemoria();
            MonitoraArduino.getInstance().setDataLedY(this.getDataLedY());            
            MonitoraArduino.getInstance().setTempoLedG(tempoLedR);
            
        } else if (ar.getNomeLed().equals("ledY") && listaLedY.get(0) != null) {
            arduino = listaLedY.get(0);
            tempo = ar.getData().getTime() - arduino.getData().getTime();
            ar.setLedTempo(tempo);
            listaLedY.clear();
            tempoLedY.add(ar);
            //acrescentaTempoBD(ar);
            //salvaDadosMemoria();
            MonitoraArduino.getInstance().setTempoLedG(tempoLedY);
            MonitoraArduino.getInstance().setDataLedY(this.getDataLedY());
        }
        if (ar.getNomeLed().equals("ledG") && listaLedG.get(0) != null) {
            arduino = listaLedG.get(0);
            tempo = ar.getData().getTime() - arduino.getData().getTime();
            ar.setLedTempo(tempo);
            listaLedG.clear();
            tempoLedG.add(ar);
            //acrescentaTempoBD(ar);
            //salva dados em memoria
            //salvaDadosMemoria();
            MonitoraArduino.getInstance().setTempoLedG(tempoLedG);
            MonitoraArduino.getInstance().setDataLedG(this.getDataLedG());
        }

    }

    public void salvaDadosMemoria() {

    }

    public void acrescentaTempoBD(ModelArduino arduino) {
        dao = new ArduinoDAO();
        if (arduino.getLedTempo() != 0) {
            dao.inserirTempo(arduino);
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

    public double[] getDataLedR() {
        for (int i = 0; i < listaLedR.size(); i++) {
            ModelArduino ar = listaLedR.get(i);
            dataLedR[i] = ar.getLedTempo();
        }

        return this.dataLedR;
    }

    public void setDataLedR(double[] dataLedR) {
        this.dataLedR = dataLedR;
    }

    public double[] getDataLedY() {
        for (int i = 0; i < listaLedY.size(); i++) {
            ModelArduino ar = listaLedY.get(i);
            dataLedR[i] = ar.getLedTempo();
        }
        return this.dataLedY;
    }

    public void setDataLedY(double[] dataLedY) {
        this.dataLedY = dataLedY;
    }

    public double[] getDataLedG() {
        for (int i = 0; i < listaLedG.size(); i++) {
            ModelArduino ar = listaLedG.get(i);
            dataLedG[i] = ar.getLedTempo();
        }
        return dataLedG;
    }

    public void setDataLedG(double[] dataLedG) {
        this.dataLedG = dataLedG;
    }

}
