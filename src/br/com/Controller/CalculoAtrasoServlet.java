package br.com.Controller;

import br.com.DAO.CalculoAtrasoDAO;
import br.com.Entity.CalculoAtraso;
import br.com.Entity.HorarioDeTrabalho;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculoAtrasoServlet")
public class CalculoAtrasoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private CalculoAtrasoDAO calculoAtrasoDAO;
   
    public void init() {    	
        calculoAtrasoDAO = new CalculoAtrasoDAO();
        listaratrasos();
    }
    
    private void listaratrasos() {
      	 List<CalculoAtraso> at = calculoAtrasoDAO.listarTodosCalculoAtraso();
      	 getServletContext().setAttribute("at", at);
      }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");        
        
        try {
			switch (action) {
			case "calcularAtraso":
				adicionarAtraso(request, response);
				break;						
			default:
				listarAtrasos(request, response);
				break;
			}
		} catch (Exception e) {
			// trata a exceção
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("Ocorreu um erro ao processar a solicitação: " + e.getMessage());
		}
    }  
    
    private void adicionarAtraso(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cpf = request.getParameter("cpf");
		String entrada = request.getParameter("entrada");
		String saida = request.getParameter("saida");
		String periodoAtraso = request.getParameter("periodoAtraso");		

		if (cpf == null || cpf.isEmpty() || entrada == null || entrada.isEmpty() || saida == null || saida.isEmpty()) {
			throw new Exception("Todos os campos devem ser preenchidos");
		}

		CalculoAtraso atraso = new CalculoAtraso();
		atraso.setCpf(cpf);
		atraso.setEntrada(entrada);		
		atraso.setSaida(saida);
		atraso.setPeriodoAtraso(periodoAtraso);
		calculoAtrasoDAO.calcularEInserirAtraso(cpf);
		listarAtrasos(request, response);
	}

    private void listarAtrasos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    	 
    	List<CalculoAtraso> atraso = calculoAtrasoDAO.listarTodosCalculoAtraso();
        request.setAttribute("atraso", atraso);
        request.getRequestDispatcher("controleDeHora.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        	//http://localhost:8080/RegisterPoint/HoraDeTrabalhoServlet?action=list
        if (action != null) {
            switch (action) {
            case "list":
				   	listarAtrasos(request, response);
                    break;                
                default:
                	listarAtrasos(request, response);
                    break;
            }
        } else {
        	listarAtrasos(request, response);
        }
    }
}
