package br.com.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Entity.HorarioDeTrabalho;
import br.com.Persistence.Conneciton;

public class HoraDeTrabalhoDAO {

	private Conneciton conn;
	private List<HorarioDeTrabalho> horarios;

	public HoraDeTrabalhoDAO() {
		this.conn = new Conneciton();
		horarios = new ArrayList<>(3);
	}

	public void adicionarHorarioDeTrabalho(HorarioDeTrabalho horario) {
		String sql = "INSERT INTO HorarioTrabalho (cpf, entrada, inicio_Intervalo, fim_Intervalo, saida) VALUES (?, ?, ?, ?, ?)";

		try (java.sql.Connection con = conn.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, horario.getCpf());
			stmt.setString(2, horario.getEntrada());
			stmt.setString(3, horario.getIntervaloInicio());
			stmt.setString(4, horario.getIntervaloFim());
			stmt.setString(5, horario.getSaida());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<HorarioDeTrabalho> listarTodosHorariosDeTrabalho() {
		String sql = "SELECT * FROM HorarioTrabalho";
		List<HorarioDeTrabalho> horarios = new ArrayList<>();

		try (java.sql.Connection con = conn.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					HorarioDeTrabalho horario = new HorarioDeTrabalho();
					horario.setId(rs.getLong("id"));
					horario.setCpf(rs.getString("cpf"));
					horario.setEntrada(rs.getString("entrada"));
					horario.setIntervaloInicio(rs.getString("inicio_Intervalo"));
					horario.setIntervaloFim(rs.getString("fim_Intervalo"));
					horario.setSaida(rs.getString("saida"));

					horarios.add(horario);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return horarios;
	}

	public HorarioDeTrabalho buscarHorarioDeTrabalhoPorCpf(String cpf) {
		String sql = "SELECT * FROM HorarioTrabalho WHERE cpf = ?";

		try (java.sql.Connection con = conn.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setObject(1, cpf);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					HorarioDeTrabalho horario = new HorarioDeTrabalho();
					horario.setId(rs.getLong("id"));
					horario.setCpf(rs.getString("cpf"));
					horario.setEntrada(rs.getString("entrada"));
					horario.setIntervaloInicio(rs.getString("inicio_Intervalo"));
					horario.setIntervaloFim(rs.getString("fim_Intervalo"));
					horario.setSaida(rs.getString("saida"));

					return horario;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; // Retorna null se nenhum HorarioDeTrabalho for encontrado com o cpf fornecido
	}

	public void removerHorarioDeTrabalho(String cpf) {
		String sql = "DELETE FROM HorarioTrabalho WHERE cpf = ?";

		try (java.sql.Connection con = conn.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, cpf);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removerHoraio(Long id) {
		String sql = "DELETE FROM HorarioTrabalho WHERE id = ?";

		try (java.sql.Connection con = conn.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setLong(1, id);
			stmt.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 public void selecionarHorario( HorarioDeTrabalho horario) {
	        String sql = "SELECT * FROM HorarioTrabalho WHERE id = ?";
	        
	        try (java.sql.Connection con = conn.conectar(); PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setLong(1, horario.getId());
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	horario.setId(rs.getLong("id"));
	            	horario.setCpf(rs.getString("cpf"));
					horario.setEntrada(rs.getString("entrada"));
					horario.setIntervaloInicio(rs.getString("inicio_Intervalo"));
					horario.setIntervaloFim(rs.getString("fim_Intervalo"));
					horario.setSaida(rs.getString("saida"));
	        }
	           	            
	        }catch (SQLException e) {
				e.printStackTrace();
			}     	       
	    }
	 
	 public void atualizarHorario(HorarioDeTrabalho horario) {
		    String sql = "UPDATE HorarioTrabalho SET entrada = ?, saida = ? WHERE id = ?";
		    try (java.sql.Connection con = conn.conectar();
		            PreparedStatement stmt = con.prepareStatement(sql)) {
		        stmt.setString(1, horario.getEntrada());
		        stmt.setString(2, horario.getSaida());
		        stmt.setLong(3, horario.getId());
		        stmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}


}
