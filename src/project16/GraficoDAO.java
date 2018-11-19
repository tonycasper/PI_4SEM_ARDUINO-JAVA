/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author andre
 */
public class GraficoDAO {
//    public int criar(Arduino arduino) {
//		String sqlInsert = "INSERT INTO arduino(nome, fone, email) VALUES (?, ?, ?)";
//		// usando o try with resources do Java 7, que fecha o que abriu
//		try (Connection conn = ConnectionFactory.obtemConexao();
//				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
//			stm.setString(1, arduino.getNome());
//			stm.setString(2, arduino.getFone());
//			stm.setString(3, arduino.getEmail());
//			stm.execute();
//			String sqlQuery = "SELECT LAST_INSERT_ID()";
//			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
//					ResultSet rs = stm2.executeQuery();) {
//				if (rs.next()) {
//					arduino.setId(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return arduino.getId();
//	}
//}
//public void atualizar(Arduino arduino) {
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

	public ModelArduino carregar(String nomeLed) {
		ModelArduino arduino = new ModelArduino();
                 int tempo = 0;
		arduino.setNomeLed(nomeLed);
		String sqlSelect = "SELECT tempo_consumo FROM tbl_monitoracao WHERE tbl_monitoracao.nome_led = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, arduino.getNomeLed());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					arduino.setLedTempo(rs.getInt("tempo_consumo"));
                                        tempo += arduino.getLedTempo();
                                        arduino.setLedTempo(tempo);
				} else {
					arduino.setLedTempo(tempo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return arduino;
	}
}