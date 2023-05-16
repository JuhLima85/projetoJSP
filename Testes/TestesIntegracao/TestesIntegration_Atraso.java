package TestesIntegracao;

import java.util.List;

import br.com.DAO.CalculoAtrasoDAO;
import br.com.Entity.CalculoAtraso;
import br.com.erro.ResultadoCalculoAtraso;

public class TestesIntegration_Atraso {

	public static void main(String[] args) {
		CalculoAtraso cca2 = new CalculoAtraso();
		CalculoAtrasoDAO ccaDao = new CalculoAtrasoDAO();
		ResultadoCalculoAtraso marcacoesParaCalculo = new ResultadoCalculoAtraso();
		marcacoesParaCalculo.setCpf("01439869103");
		marcacoesParaCalculo.setEntrada("10:00:00");
		marcacoesParaCalculo.setSaida("12:00:00");
		
		String cpf = "01439869103";
		
		ccaDao.calcularEInserirAtraso(marcacoesParaCalculo);
				
		//-------------Metodo para Listar todos os registros--------
		List<CalculoAtraso> horario = ccaDao.listarTodosCalculoAtraso();

		for (CalculoAtraso mfs : horario) {
			System.out.println("CPF : " + mfs.getCpf() + "Entrada: " + mfs.getEntrada() + ", Sa�da: " + mfs.getSaida()); 
		}

		// ---------------Metodo para buscar por CPF-----------------------------

//		String T = "6977984031";
//		CalculoAtraso cca = ccaDao.buscarCalculoAtrasoPorCpf(T);
//		System.out.println(cca.getCpf() + " - " + cca.getEntrada() + " - " + cca.getSaida());		

		
	}
}