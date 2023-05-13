package br.com.DAO;

import br.com.Entity.CalculoHoraExtra;
import br.com.Entity.MarcacoesFeitas;
import br.com.Persistence.Conneciton;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalculoHoraExtraDAO {
	
	private Conneciton conn;
    private List<CalculoHoraExtra> horasExtras;

    public CalculoHoraExtraDAO() {
    	this.conn = new Conneciton();
        horasExtras = new ArrayList<>();
    }

    public void adicionarHoraExtra(CalculoHoraExtra horaExtra) {
        horasExtras.add(horaExtra);
    }

    public boolean removerHoraExtra(int index) {
        if (index >= 0 && index < horasExtras.size()) {
            horasExtras.remove(index);
            return true;
        }
        return false;
    }

    public List<CalculoHoraExtra> listarHorasExtras() {
        return horasExtras;
    }

    public CalculoHoraExtra buscarHoraExtraPorData(String data) {
        for (CalculoHoraExtra horaExtra : horasExtras) {
            if (horaExtra.getData().equals(data)) {
                return horaExtra;
            }
        }
        return null;
    }

    public boolean atualizarHoraExtra(CalculoHoraExtra horaExtraAtualizada) {
        for (int i = 0; i < horasExtras.size(); i++) {
            CalculoHoraExtra horaExtra = horasExtras.get(i);
            if (horaExtra.getData().equals(horaExtraAtualizada.getData())) {
                horasExtras.set(i, horaExtraAtualizada);
                return true;
            }
        }
        return false;
    }
    
    public void adicionarHoraExtras(CalculoHoraExtra horaEx) {
    	String sql = "INSERT INTO HoraExtra (entrada, saida) VALUES (?, ?)";

        try (java.sql.Connection con = conn.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

//        	stmt.setString(1, horaEx.getEntradaPrevista());
//            stmt.setString(2, horaEx.getSaidaPrevista());
            stmt.setString(1, horaEx.getEntradaRealizada());
            stmt.setString(2, horaEx.getSaidaRealizada());
//            stmt.setInt(5, horaEx.getHoraExtraEntrada());
//            stmt.setInt(6, horaEx.getHoraExtraSaida());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

