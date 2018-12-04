/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andre
 */
public class ArduinoTableModel extends AbstractTableModel{
     private String[] nomeColunas = {"Led", "Tempo", "Data"};
     
     private List<ModelArduino> arduinos;
     
     public ArduinoTableModel(){
         arduinos = new ArrayList< ModelArduino>();
     }
     
     public ArduinoTableModel(List<ModelArduino> lista){
         this();
         this.arduinos.clear();
         this.arduinos.addAll(lista);
         super.fireTableDataChanged();
     }
     
    @Override
    public int getRowCount() {
        return arduinos.size();
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getColumnCount() {
       return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelArduino ard = arduinos.get(rowIndex);
        switch( columnIndex ) {
             case 0: return ard.getNomeLed();
             case 1: return ard.getLedTempo();
             case 2: return ard.getDataMarcada();
         }
        return null;
    }
    
    public void addRow(ModelArduino a){
        this.arduinos.add(a);
    }
    
    public void clear(){
        arduinos.clear();        
        super.fireTableDataChanged();
        
    }
    
}

