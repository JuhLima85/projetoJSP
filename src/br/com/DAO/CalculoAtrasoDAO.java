package br.com.DAO;

import br.com.Entity.CalculoAtraso;
import br.com.Entity.MarcacoesFeitas;
import br.com.Persistence.Conneciton;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalculoAtrasoDAO {
	
	private Conneciton conn;
    private List<CalculoAtraso> atrasos;

    public CalculoAtrasoDAO() {
    	this.conn = new Conneciton();
        atrasos = new ArrayList<>();
    }

    public void adicionarAtraso(CalculoAtraso atraso) {
        atrasos.add(atraso);
    }

    public boolean removerAtraso(int index) {
        if (index >= 0 && index < atrasos.size()) {
            atrasos.remove(index);
            return true;
        }
        return false;
    }

    public List<CalculoAtraso> listarAtrasos() {
        return atrasos;
    }

    public CalculoAtraso buscarAtrasoPorData(String data) {
        for (CalculoAtraso atraso : atrasos) {
            if (atraso.getData().equals(data)) {
                return atraso;
            }
        }
        return null;
    }

    public boolean atualizarAtraso(CalculoAtraso atrasoAtualizado) {
        for (int i = 0; i < atrasos.size(); i++) {
            CalculoAtraso atraso = atrasos.get(i);
            if (atraso.getData().equals(atrasoAtualizado.getData())) {
                atrasos.set(i, atrasoAtualizado);
                return true;
            }
        }
        return false;
    }
    
    public void adicionarCalculoAtraso(CalculoAtraso atraso) {
    	String sql = "INSERT INTO Atraso (entrada, saida) VALUES (?, ?)";

        try (java.sql.Connection con = conn.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

        	stmt.setInt(1, atraso.getAtrasoEntrada());
            stmt.setInt(2, atraso.getAtrasoSaida());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
