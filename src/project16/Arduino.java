///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package project16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

// DocumentaÃ§Ã£o: https://playground.arduino.cc/Interfacing/Java
/**
 * Classe que le do Arduino dados enviados pelo USB
 *
 */
public class Arduino implements SerialPortEventListener {
    private ControlePorta arduino;

    //construtor da classe arduino
    
    public Arduino(){
        arduino = new ControlePorta("COM3",9600);
    }

    private BufferedReader input;


    @Override
    public void serialEvent(SerialPortEvent spe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
