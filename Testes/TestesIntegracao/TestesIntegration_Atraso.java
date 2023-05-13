package TestesIntegracao;

import br.com.DAO.CalculoAtrasoDAO;
import br.com.Entity.CalculoAtraso;

public class TestesIntegration_Atraso {

	public static void main(String[] args) {
		CalculoAtraso cca = new CalculoAtraso();
		CalculoAtrasoDAO ccaDao = new CalculoAtrasoDAO();
		
		try {
			cca.setAtrasoEntrada(10);
			cca.setAtrasoSaida(0);
			
			ccaDao.adicionarCalculoAtraso(cca);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
