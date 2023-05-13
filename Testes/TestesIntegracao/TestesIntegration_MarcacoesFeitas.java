package TestesIntegracao;

import java.util.List;

import br.com.DAO.MarcacoesFeitasDAO;
import br.com.Entity.MarcacoesFeitas;

public class TestesIntegration_MarcacoesFeitas {

	public static void main(String[] args) {
		
		MarcacoesFeitas mf = new MarcacoesFeitas();
		MarcacoesFeitasDAO mfdao = new MarcacoesFeitasDAO();
		try {
			mf.setCpf("6977984031");
			mf.setEntrada("08:00");
			mf.setIntervaloInicio("12:15");
			mf.setIntervaloFim("13:20");
			mf.setSaida("16:00");	
			
			mfdao.adicionarMarcacao(mf);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
//---------------------------------------Metodo para Listar todos os registros-----------------------------------------------------
		
//		try {
//			List<MarcacoesFeitas> horario = mfdao.listarTodasMarcacoesFeitas();
//
//			for (MarcacoesFeitas mfs : horario) {
//				System.out.println("CPF : " + mf.getCpf() + "Entrada: " + mf.getEntrada() + ", Sa�da: " + mfs.getSaida() + 
//						", IntervaloInicio: " + mfs.getIntervaloInicio() + ", IntervaloFim: " + mfs.getIntervaloFim());
//			}
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		//---------------------------------------Metodo para apagar o registros pelo cpf-----------------------------------------------------
		
//		mf.setCpf("6977984031");
//		mfdao.removerMarcacoesFeitas(mf.getCpf());
		
	}

}
