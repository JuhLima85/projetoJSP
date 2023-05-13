package br.com.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HorarioDeTrabalho implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cpf;
	private String entrada;
	private String intervaloInicio;
    private String intervaloFim;
    private String saida;

    public HorarioDeTrabalho() {
		// TODO Auto-generated constructor stub
	}   
   
	public HorarioDeTrabalho(Long id, String cpf, String entrada, String intervaloInicio, String intervaloFim,
			String saida) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.entrada = entrada;
		this.intervaloInicio = intervaloInicio;
		this.intervaloFim = intervaloFim;
		this.saida = saida;
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

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getIntervaloInicio() {
		return intervaloInicio;
	}

	public void setIntervaloInicio(String intervaloInicio) {
		this.intervaloInicio = intervaloInicio;
	}

	public String getIntervaloFim() {
		return intervaloFim;
	}

	public void setIntervaloFim(String intervaloFim) {
		this.intervaloFim = intervaloFim;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public static class HorarioDeTrabalhoList {
        private List<HorarioDeTrabalho> horarios;

        public HorarioDeTrabalhoList() {
            horarios = new ArrayList<>(3);
        }

        public boolean adicionarHorario(HorarioDeTrabalho horario) {
            if (horarios.size() < 3) {
                horarios.add(horario);
                return true;
            }
            return false;
        }

        public boolean removerHorario(int index) {
            if (index >= 0 && index < horarios.size()) {
                horarios.remove(index);
                return true;
            }
            return false;
        }

        public void listarHorarios() {
            for (HorarioDeTrabalho horario : horarios) {
                System.out.println("Entrada: " + horario.getEntrada() + " - Saída: " + horario.getSaida());
            }
        }
    }
}
