/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.ArduinoBean;
import connection.ConnectionFacotory;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import project16.ModelArduino;

/**
 *
 * @author andre
 */
public class ArduinoDAO {

    public void create(ArduinoBean a) throws SQLException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
        PreparedStatement stmt = null;
        Connection con = ConnectionFacotory.getConnection();
        Date data = format.parse((a.getData().toString()));
        try {
            stmt = con.prepareStatement("INSERT INTO tbl_monitoracao (nome_led, tempo_consumo,data_marcacao VALUES (?,?,?)");
            stmt.setString(1, a.getNomeLed());
            stmt.setFloat(2, a.getLedTempo());
            stmt.setString(3, data.toString());

            stmt.executeUpdate();
            stmt = con.prepareStatement("");
            System.out.println("salvou");
        } catch (SQLException ex) {
            Logger.getLogger(ArduinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFacotory.closeConnection(con, stmt);
        }
    }

    public void create(ModelArduino a) throws ParseException {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(data);

        PreparedStatement stmt = null;
        Connection con = ConnectionFacotory.getConnection();

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_monitoracao (nome_led, tempo_consumo,data_marcacao) VALUES (?,?,?)");
            stmt.setString(1, a.getNomeLed());
            stmt.setFloat(2, a.getLedTempo());
            stmt.setString(3, dataFormatada);

            stmt.executeUpdate();
            stmt = con.prepareStatement("");
            System.out.println("salvou");
        } catch (SQLException ex) {
            Logger.getLogger(ArduinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFacotory.closeConnection(con, stmt);
        }
    }

    public List<ModelArduino> read() {

        Connection con = ConnectionFacotory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelArduino> arduinos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_monitoracao");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ModelArduino ar = new ModelArduino();

                ar.setDataMarcada(rs.getString("data_marcacao"));
                ar.setLedTempo((long) rs.getFloat("tempo_consumo"));
                ar.setNomeLed(rs.getString("nome_led"));
                arduinos.add(ar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArduinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFacotory.closeConnection(con, stmt, rs);
        }

        return arduinos;

    }

    public List<ModelArduino> readLedData(String nomeLed) {

        Connection con = ConnectionFacotory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelArduino> arduinos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_monitoracao WHERE tbl_monitoracao.nome_led = ?");
            stmt.setString(1, nomeLed);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ModelArduino ar = new ModelArduino();

                ar.setDataMarcada(rs.getString("data_marcacao"));
                ar.setLedTempo((long) rs.getFloat("tempo_consumo"));
                ar.setNomeLed(rs.getString("nome_led"));
                arduinos.add(ar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArduinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFacotory.closeConnection(con, stmt, rs);
        }

        return arduinos;

    }

    public List<ModelArduino> loadFromData(String data1, String data2) {
        Connection con = ConnectionFacotory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelArduino> arduinos = new ArrayList<>();

        try {
         stmt = con.prepareStatement("SELECT * FROM tbl_monitoracao WHERE tbl_monitoracao.data_marcacao BETWEEN ? and ?");
            stmt.setString(1, data1);
            stmt.setString(2, data2);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ModelArduino ar = new ModelArduino();

                ar.setDataMarcada(rs.getString("data_marcacao"));
                ar.setLedTempo((long) rs.getFloat("tempo_consumo"));
                ar.setNomeLed(rs.getString("nome_led"));
                arduinos.add(ar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArduinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFacotory.closeConnection(con, stmt, rs);
        }

        return arduinos;

    }

   

}
