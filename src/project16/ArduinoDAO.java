/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

import project16.ModelArduino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;



/**
 *
 * @author andre
 */
public class ArduinoDAO {
    public void inserirTempo(ModelArduino arduino) {
		String sqlInsert = "INSERT INTO arduino(nome_led, tempo_consumo) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, arduino.getNomeLed());
			stm.setFloat(2, arduino.getLedTempo());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					//arduino.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        }
    
//public void atualizar(ModelArduino arduino) {
//		String sqlUpdate = "UPDATE arduino SET nome=?, fone=?, email=? WHERE id=?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
//			stm.setString(1, arduino.getNome());
//			stm.setString(2, arduino.getFone());
//			stm.setString(3, arduino.getEmail());
//			stm.setInt(4, arduino.getId());
//			stm.execute();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void excluir(int id) {
//		String sqlDelete = "DELETE FROM arduino WHERE id = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
//			stm.setInt(1, id);
//			stm.execute();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public ModelArduino carregar(int id) {
//		ModelArduino arduino = new ModelArduino();
//		arduino.setId(id);
//		String sqlSelect = "SELECT nome, fone, email FROM arduino WHERE arduino.id = ?";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
//			stm.setInt(1, arduino.getId());
//			try (ResultSet rs = stm.executeQuery();) {
//				if (rs.next()) {
//					arduino.setNome(rs.getString("nome"));
//					arduino.setFone(rs.getString("fone"));
//					arduino.setEmail(rs.getString("email"));
//				} else {
//					arduino.setId(-1);
//					arduino.setNome(null);
//					arduino.setFone(null);
//					arduino.setEmail(null);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			System.out.print(e1.getStackTrace());
//		}
//		return arduino;
//	}
}