package br.com.Entity;

import java.util.ArrayList;
import java.util.List;

public class CalculoAtraso {
	private Long id;
	private String cpf;
    private String data;
    private String entradaPrevista;
    private String entradaRealizada;
    private String saidaPrevista;
    private String saidaRealizada;
    private int atrasoEntrada;
    private int atrasoSaida;

   public CalculoAtraso() {
	// TODO Auto-generated constructor stub
}
   
	public CalculoAtraso(Long id, String cpf, String data, String entradaPrevista, String entradaRealizada,
		String saidaPrevista, String saidaRealizada, int atrasoEntrada, int atrasoSaida) {
	super();
	this.id = id;
	this.cpf = cpf;
	this.data = data;
	this.entradaPrevista = entradaPrevista;
	this.entradaRealizada = entradaRealizada;
	this.saidaPrevista = saidaPrevista;
	this.saidaRealizada = saidaRealizada;
	this.atrasoEntrada = atrasoEntrada;
	this.atrasoSaida = atrasoSaida;
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

	public int getAtrasoEntrada() {
		return atrasoEntrada;
	}

	public void setAtrasoEntrada(int atrasoEntrada) {
		this.atrasoEntrada = atrasoEntrada;
	}

	public int getAtrasoSaida() {
		return atrasoSaida;
	}

	public void setAtrasoSaida(int atrasoSaida) {
		this.atrasoSaida = atrasoSaida;
	}

}

class CalculoAtrasoList {
    private List<CalculoAtraso> atrasos;

    public CalculoAtrasoList() {
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
 }


