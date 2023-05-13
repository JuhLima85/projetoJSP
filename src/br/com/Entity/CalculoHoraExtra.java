package br.com.Entity;

import java.util.ArrayList;
import java.util.List;

public class CalculoHoraExtra {
	private Long id;
	private String cpf;
    private String data;
    private String entradaPrevista;
    private String entradaRealizada;
    private String saidaPrevista;
    private String saidaRealizada;
    private int horaExtraEntrada;
    private int horaExtraSaida;
    
   public CalculoHoraExtra() {
	// TODO Auto-generated constructor stub
   }
   
	public CalculoHoraExtra(Long id, String cpf, String data, String entradaPrevista, String entradaRealizada,
		String saidaPrevista, String saidaRealizada, int horaExtraEntrada, int horaExtraSaida) {
	super();
	this.id = id;
	this.cpf = cpf;
	this.data = data;
	this.entradaPrevista = entradaPrevista;
	this.entradaRealizada = entradaRealizada;
	this.saidaPrevista = saidaPrevista;
	this.saidaRealizada = saidaRealizada;
	this.horaExtraEntrada = horaExtraEntrada;
	this.horaExtraSaida = horaExtraSaida;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEntradaPrevista() {
		return entradaPrevista;
	}

	public void setEntradaPrevista(String entradaPrevista) {
		this.entradaPrevista = entradaPrevista;
	}

	public String getEntradaRealizada() {
		return entradaRealizada;
	}

	public void setEntradaRealizada(String entradaRealizada) {
		this.entradaRealizada = entradaRealizada;
	}

	public String getSaidaPrevista() {
		return saidaPrevista;
	}

	public void setSaidaPrevista(String saidaPrevista) {
		this.saidaPrevista = saidaPrevista;
	}

	public String getSaidaRealizada() {
		return saidaRealizada;
	}

	public void setSaidaRealizada(String saidaRealizada) {
		this.saidaRealizada = saidaRealizada;
	}

	public int getHoraExtraEntrada() {
		return horaExtraEntrada;
	}

	public void setHoraExtraEntrada(int horaExtraEntrada) {
		this.horaExtraEntrada = horaExtraEntrada;
	}

	public int getHoraExtraSaida() {
		return horaExtraSaida;
	}

	public void setHoraExtraSaida(int horaExtraSaida) {
		this.horaExtraSaida = horaExtraSaida;
	}

}

class CalculoHoraExtraList {
    private List<CalculoHoraExtra> horasExtras;

    public CalculoHoraExtraList() {
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

    public void listarHorasExtras() {
        for (CalculoHoraExtra horaExtra : horasExtras) {
            System.out.println("Data: " + horaExtra.getData() +
                    " - Entrada Prevista: " + horaExtra.getEntradaPrevista() +
                    " - Entrada Realizada: " + horaExtra.getEntradaRealizada() +
                    " - Saída Prevista: " + horaExtra.getSaidaPrevista() +
                    " - Saída Realizada: " + horaExtra.getSaidaRealizada() +
                    " - Hora Extra Entrada: " + horaExtra.getHoraExtraEntrada() + " min" +
                    " - Hora Extra Saída: " + horaExtra.getHoraExtraSaida() + " min");
        }
    }
}
