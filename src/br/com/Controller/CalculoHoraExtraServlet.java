package br.com.Controller;

import br.com.DAO.CalculoHoraExtraDAO;
import br.com.Entity.CalculoHoraExtra;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculoHoraExtraServlet")
public class CalculoHoraExtraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CalculoHoraExtraDAO calculoHoraExtraDAO;

    public void init() {
        calculoHoraExtraDAO = new CalculoHoraExtraDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "add":
                adicionarHoraExtra(request, response);
                break;
            case "remove":
                removerHoraExtra(request, response);
                break;
            case "update":
                atualizarHoraExtra(request, response);
                break;
            default:
                listarHorasExtras(request, response);
        }
    }

    private void adicionarHoraExtra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        double valor = Double.parseDouble(request.getParameter("valor"));
        CalculoHoraExtra horaExtra = new CalculoHoraExtra();
        calculoHoraExtraDAO.adicionarHoraExtra(horaExtra);
        listarHorasExtras(request, response);
    }

    private void removerHoraExtra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        calculoHoraExtraDAO.removerHoraExtra(index);
        listarHorasExtras(request, response);
    }

    private void atualizarHoraExtra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        double valor = Double.parseDouble(request.getParameter("valor"));
        CalculoHoraExtra horaExtraAtualizada = new CalculoHoraExtra();
        calculoHoraExtraDAO.atualizarHoraExtra(horaExtraAtualizada);
        listarHorasExtras(request, response);
    }

    private void listarHorasExtras(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CalculoHoraExtra> horasExtras = calculoHoraExtraDAO.listarHorasExtras();
        request.setAttribute("horasExtras", horasExtras);
        request.getRequestDispatcher("listarHorasExtras.jsp").forward(request, response);
    }
}

