package br.com.Controller;

import br.com.DAO.CalculoAtrasoDAO;
import br.com.Entity.CalculoAtraso;
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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "add":
                adicionarAtraso(request, response);
                break;
            case "remove":
                removerAtraso(request, response);
                break;
            case "update":
                atualizarAtraso(request, response);
                break;
            default:
                listarAtrasos(request, response);
        }
    }

    private void adicionarAtraso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        double valor = Double.parseDouble(request.getParameter("valor"));
        CalculoAtraso atraso = new CalculoAtraso();
        calculoAtrasoDAO.adicionarAtraso(atraso);
        listarAtrasos(request, response);
    }

    private void removerAtraso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        calculoAtrasoDAO.removerAtraso(index);
        listarAtrasos(request, response);
    }

    private void atualizarAtraso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        double valor = Double.parseDouble(request.getParameter("valor"));
        CalculoAtraso atrasoAtualizado = new CalculoAtraso();
        calculoAtrasoDAO.atualizarAtraso(atrasoAtualizado);
        listarAtrasos(request, response);
    }

    private void listarAtrasos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CalculoAtraso> atrasos = calculoAtrasoDAO.listarAtrasos();
        request.setAttribute("atrasos", atrasos);
        request.getRequestDispatcher("listarAtrasos.jsp").forward(request, response);
    }
}
