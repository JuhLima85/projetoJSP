package br.com.DAO;

import br.com.Entity.MarcacoesFeitas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Persistence.Conneciton;


public class MarcacoesFeitasDAO {

	private Conneciton conn;
    private List<MarcacoesFeitas> marcacoesFeitasList;

    public MarcacoesFeitasDAO() {
    	this.conn = new Conneciton();
        marcacoesFeitasList = new ArrayList<>();
    }

    public void adicionarMarcacao(MarcacoesFeitas marcacao) {
    	 String sql = "INSERT INTO MarcacoesFeitas (cpf, entrada, inicio_Intervalo, fim_Intervalo, saida) VALUES (?, ?, ?, ?, ?)";

         try (java.sql.Connection con = conn.conectar();
              PreparedStatement stmt = con.prepareStatement(sql)) {

             stmt.setString(1, marcacao.getCpf());
             stmt.setString(2, marcacao.getEntrada());
             stmt.setString(3, marcacao.getIntervaloInicio());
             stmt.setString(4, marcacao.getIntervaloFim());
             stmt.setString(5, marcacao.getSaida());

             stmt.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    
    public List<MarcacoesFeitas> listarTodasMarcacoesFeitas() {
        String sql = "SELECT * FROM MarcacoesFeitas";
        List<MarcacoesFeitas> horarios = new ArrayList<>();

        try (java.sql.Connection con = conn.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {                  
                    
                    MarcacoesFeitas marcacao = new MarcacoesFeitas();
                    marcacao.setId(rs.getLong("id"));
                    marcacao.setCpf(rs.getString("cpf"));
                    marcacao.setEntrada(rs.getString("entrada"));
                    marcacao.setIntervaloInicio(rs.getString("inicio_Intervalo"));
                    marcacao.setIntervaloFim(rs.getString("fim_Intervalo"));
                    marcacao.setSaida(rs.getString("saida"));

                    horarios.add(marcacao);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horarios; 
    }
    
    public MarcacoesFeitas buscarMarcacoesFeitasPorCpf(String cpf) {
        String sql = "SELECT * FROM MarcacoesFeitas WHERE cpf = ?";

        try (java.sql.Connection con = conn.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {      

                if (rs.next()) {                   
                    MarcacoesFeitas marcacao = new MarcacoesFeitas();
                    marcacao.setId(rs.getLong("id"));
                    marcacao.setCpf(rs.getString("cpf"));
                    marcacao.setEntrada(rs.getString("entrada"));
                    marcacao.setIntervaloInicio(rs.getString("inicio_Intervalo"));
                    marcacao.setIntervaloFim(rs.getString("fim_Intervalo"));
                    marcacao.setSaida(rs.getString("saida"));

                    return marcacao;
                }
            }
     
    }catch (SQLException e) {
        e.printStackTrace();
    }
        return null; 
 }
    
    public  List<MarcacoesFeitas> listarMarcacoesFeitasPorCpf(String cpf) {
        String sql = "SELECT * FROM HorarioTrabalho WHERE cpf = ?";
        List<MarcacoesFeitas> horarios = new ArrayList<>();

        try (java.sql.Connection con = conn.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setObject(1, cpf);            

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                	MarcacoesFeitas marcacao = new MarcacoesFeitas();
                	marcacao.setId(rs.getLong("id"));
                	marcacao.setCpf(rs.getString("cpf"));
                	marcacao.setEntrada(rs.getString("entrada"));
                	marcacao.setIntervaloInicio(rs.getString("inicio_Intervalo"));
                	marcacao.setIntervaloFim(rs.getString("fim_Intervalo"));
                	marcacao.setSaida(rs.getString("saida"));
                	horarios.add(marcacao);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horarios; 
    }

    public void removerMarcacoesFeitas(String cpf) {
        String sql = "DELETE FROM MarcacoesFeitas WHERE cpf = ?";

        try (java.sql.Connection con = conn.conectar();
            PreparedStatement stmt = con.prepareStatement(sql)) {
        	
            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

}
