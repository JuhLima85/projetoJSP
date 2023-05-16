package br.com.DAO;

import br.com.Entity.CalculoAtraso;
import br.com.Entity.CodigoErro;
import br.com.Entity.HorarioDeTrabalho;
import br.com.Entity.MarcacoesFeitas;
import br.com.Persistence.Conneciton;
import br.com.erro.ResultadoCalculoAtraso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CalculoAtrasoDAO {
	
	private Conneciton conn; 

    public CalculoAtrasoDAO() {
    	this.conn = new Conneciton();      
    }

	// Fun��o que converte a string de tempo para LocalTime
	private static LocalTime stringToTime(String timeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return LocalTime.parse(timeString, formatter);
	}

	// Fun��o para calcular a diferen�a entre dois hor�rios
	public String calcularDiferenca(HorarioDeTrabalho ht, MarcacoesFeitas mf) {
		// Convertendo as strings para LocalTime
		LocalTime entradaTime = stringToTime(ht.getEntrada());
		LocalTime saidaTime = stringToTime(ht.getSaida());
		LocalTime marcacaoEntradaTime = stringToTime(mf.getEntrada());
		LocalTime marcacaoSaidaTime = stringToTime(mf.getSaida());

		// Se a marca��o de entrada � depois do hor�rio de entrada, o atraso � a
		// diferen�a
		if (marcacaoEntradaTime.isAfter(entradaTime)) {
			long minutosAtraso = ChronoUnit.MINUTES.between(entradaTime, marcacaoEntradaTime);
			return String.format("Atraso de %d minutos na entrada.", minutosAtraso);
		}

		// Se a marca��o de sa�da � antes do hor�rio de sa�da, o atraso � a diferen�a
		if (marcacaoSaidaTime.isBefore(saidaTime)) {
			long minutosAtraso = ChronoUnit.MINUTES.between(marcacaoSaidaTime, saidaTime);
			return String.format("Atraso de %d minutos na sa�da.", minutosAtraso);
		}

		// Se n�o houve atraso
		return "Sem atraso.";
	}
	
	public ResultadoCalculoAtraso calculoDeHorasExtras(String cpf) {
	    MarcacoesFeitasDAO mfdao = new MarcacoesFeitasDAO();
	    MarcacoesFeitas mf = mfdao.buscarMarcacoesFeitasPorCpf(cpf);
	    HoraDeTrabalhoDAO hdtdao = new HoraDeTrabalhoDAO();
	    HorarioDeTrabalho hdt = hdtdao.buscarHorarioDeTrabalhoPorCpf(cpf);

	    if (mf != null && hdt != null) {
	        LocalTime timeMf = LocalTime.parse(mf.getEntrada());
	        LocalTime timeHdt = LocalTime.parse(hdt.getEntrada());

	        long minutesBetween = ChronoUnit.MINUTES.between(timeMf, timeHdt);
	        long hours = minutesBetween / 60; // get the number of hours
	        long minutes = minutesBetween % 60; // get the remaining minutes

	        if (minutesBetween == 0) {
	            return new ResultadoCalculoAtraso("O horário está igual", null);
	        } else {
	            LocalTime periodoInicio = timeHdt.minusMinutes(minutesBetween);
	            String periodoAtraso = periodoInicio.toString() + " às " + timeHdt.toString();
	            return new ResultadoCalculoAtraso(hours + " horas e " + minutes + " minutos", periodoAtraso);
	        }
	    }

	    return new ResultadoCalculoAtraso(CodigoErro.INFORMACAO_INCOMPLETA, "Informação de horário incompleta");
	}

	    // Supondo que voc� esteja usando um Connection pool ou similar
	    public void inserirAtraso(CalculoAtraso calc ) {
	        String sql = "INSERT INTO Atraso (cpf, entrada, saida, periodoAtraso) VALUES (?, ?, ?, ?)";

	        try (java.sql.Connection con = conn.conectar();
	             PreparedStatement stmt = con.prepareStatement(sql)) {

	            stmt.setString(1, calc.getCpf());
	            stmt.setString(2, calc.getEntrada());
	            stmt.setString(3, calc.getSaida());
	            stmt.setString(4, calc.getPeriodoAtraso());
	            stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void calcularEInserirAtraso(String cpf) {
	        ResultadoCalculoAtraso resultado = calculoDeHorasExtras(cpf);
	        
	        String atraso = resultado.getDiferenca();
	        // Remova a parte inicial da string para ficar apenas com "X horas e Y minutos"
	        atraso = atraso.replace("A diferenca e: ", "");
	        
	        // Agora podemos dividir a string em horas e minutos
	        String[] partes = atraso.split(" e ");
	        String horas = partes[0].replace(" horas", "");
	        String minutos = partes[1].replace(" minutos", "");
	        
	        // Obtenha o período de atraso do objeto ResultadoCalculoAtraso
	        String periodoAtraso = resultado.getPeriodoAtraso();
	        
	        // Agora temos as horas e os minutos como strings. Podemos criar uma string no formato TIME do SQL
	        String timeSql = horas + ":" + minutos + ":00";
	        
	        // Agora podemos criar um novo objeto CalculoAtraso e inseri-lo no banco de dados
	        CalculoAtraso calculoAtraso = new CalculoAtraso();
	        calculoAtraso.setCpf(cpf);
	        calculoAtraso.setEntrada(timeSql);
	        calculoAtraso.setSaida(timeSql);
	        
	        // Defina o campo 'periodoAtraso' do objeto CalculoAtraso com o valor adequado
	        calculoAtraso.setPeriodoAtraso(periodoAtraso);
	        
	        // Inserimos o atraso no banco de dados
	        CalculoAtrasoDAO atrasoDAO = new CalculoAtrasoDAO();
	        atrasoDAO.inserirAtraso(calculoAtraso);
	    }	   
	    
	    //Metodo para listar todos
	    public List<CalculoAtraso> listarTodosCalculoAtraso() {
	        String sql = "SELECT * FROM atraso";
	        List<CalculoAtraso> horarios = new ArrayList<>();

	        try (java.sql.Connection con = conn.conectar();
	             PreparedStatement stmt = con.prepareStatement(sql)) {

	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {	                 	                    
	                    CalculoAtraso horario = new CalculoAtraso();
	                    horario.setId(rs.getLong("id"));
						horario.setCpf(rs.getString("cpf"));
						horario.setEntrada(rs.getString("entrada"));                    
						horario.setSaida(rs.getString("saida"));

	                    horarios.add(horario);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return horarios; 
	    }

	    //busca por cpf
	    public CalculoAtraso buscarCalculoAtrasoPorCpf(String cpf) {
	        String sql = "SELECT cpf, entrada, saida FROM atraso WHERE cpf = ?";

	        try (java.sql.Connection con = conn.conectar();
	             PreparedStatement stmt = con.prepareStatement(sql)) {

	            stmt.setString(1, cpf);            

	            try (ResultSet rs = stmt.executeQuery()) {

	                if (rs.next()) {
	                	String  cpfResult = rs.getString("cpf");
	                    String entrada = rs.getString("entrada");	                  
	                    String saida = rs.getString("saida");

	                    CalculoAtraso atraso = new CalculoAtraso();
	                    atraso.setCpf(cpfResult);
	                    atraso.setEntrada(entrada);	                    
	                    atraso.setSaida(saida);

	                    return atraso;
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null; 
	    }

	   



}