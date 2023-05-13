package TestesIntegracao;

import java.util.List;

import br.com.DAO.HoraDeTrabalhoDAO;
import br.com.Entity.HorarioDeTrabalho;

public class TestesIntegration_HorarioDeTrabalho {

	public static void main(String[] args) {
		HorarioDeTrabalho ht = new HorarioDeTrabalho();
		HoraDeTrabalhoDAO htDao = new HoraDeTrabalhoDAO();
		try {
			ht.setCpf("6977984000");
			ht.setEntrada("08:00");
			ht.setIntervaloInicio("12:15");
			ht.setIntervaloFim("13:20");
			ht.setSaida("16:00");	
			
			htDao.adicionarHorarioDeTrabalho(ht);
			
		} catch (Exception e) {
			System.out.println(e);
		}	
		
		//---------------------------------------Metodo para Listar todos os registros-----------------------------------------------------
		
//		try {
//			List<HorarioDeTrabalho> horarios = htDao.listarTodosHorariosDeTrabalho();
//
//			for (HorarioDeTrabalho hts : horarios) {
//				System.out.println("CPF: " + ht.getCpf() + "Entrada: " + ht.getEntrada() + ", Saída: " + hts.getSaida() + 
//						", IntervaloInicio: " + hts.getIntervaloInicio() + ", IntervaloFim: " + hts.getIntervaloFim());
//			}
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		//---------------------------------------Metodo para apagar o registros pelo cpf-----------------------------------------------------
		
//		ht.setCpf("69779848134");
//		htDao.removerHorarioDeTrabalho(ht.getCpf());
	}
}
