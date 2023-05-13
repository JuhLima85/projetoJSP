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
                    String cpf = rs.getString("cpf");
                    String entrada = rs.getString("entrada");
                    String inicio_Intervalo = rs.getString("inicio_Intervalo");
                    String fim_Intervalo = rs.getString("fim_Intervalo");
                    String saida = rs.getString("saida");
                    
                    MarcacoesFeitas horario = new MarcacoesFeitas();
                    horario.setCpf(cpf);
                    horario.setEntrada(entrada);
                    horario.setIntervaloInicio(inicio_Intervalo);
                    horario.setIntervaloFim(fim_Intervalo);
                    horario.setSaida(saida);

                    horarios.add(horario);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horarios; 
    }
    
    public MarcacoesFeitas listarMarcacoesFeitasPorCpf(MarcacoesFeitas cpf) {
        String sql = "SELECT cpf, entrada, inicio_Intervalo, fim_Intervalo, saida FROM HorarioTrabalho WHERE cpf = ?";

        try (java.sql.Connection con = conn.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setObject(1, cpf.getCpf());            

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                	String  cpfResult = rs.getString("cpf");
                    String entrada = rs.getString("entrada");
                    String inicio_Intervalo = rs.getString("inicio_Intervalo");
                    String fim_Intervalo = rs.getString("fim_Intervalo");
                    String saida = rs.getString("saida");

                    MarcacoesFeitas horario = new MarcacoesFeitas();
                    horario.setCpf(cpfResult);
                    horario.setEntrada(entrada);
                    horario.setIntervaloInicio(inicio_Intervalo);
                    horario.setIntervaloFim(fim_Intervalo);
                    horario.setSaida(saida);

                    return horario;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; 
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
