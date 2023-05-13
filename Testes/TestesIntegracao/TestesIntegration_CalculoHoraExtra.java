package TestesIntegracao;

import br.com.DAO.CalculoHoraExtraDAO;
import br.com.Entity.CalculoHoraExtra;

public class TestesIntegration_CalculoHoraExtra {

	public static void main(String[] args) {
		CalculoHoraExtra chx = new CalculoHoraExtra();
		CalculoHoraExtraDAO chxDao = new CalculoHoraExtraDAO();
		
		try {			
			chx.setEntradaRealizada("08:00");
			chx.setSaidaRealizada("19:00");
//			chx.setEntradaPrevista("08:00");
//			chx.setSaidaPrevista("17:00");
//			chx.setHoraExtraEntrada(2);			
//			chx.setHoraExtraSaida(0);			
//			chx.setData(null);
			
			chxDao.adicionarHoraExtras(chx);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
	}

}
