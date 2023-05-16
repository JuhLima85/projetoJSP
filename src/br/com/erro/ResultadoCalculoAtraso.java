package br.com.erro;
import br.com.Entity.CodigoErro;

public class ResultadoCalculoAtraso {
    private String diferenca;
    private String periodoAtraso;
    private CodigoErro codigoErro;
    private String mensagem;
<<<<<<< HEAD
    private String cpf;
    private String entrada;
    private String saida;   

	public ResultadoCalculoAtraso(String cpf, String entrada, String saida) {
		super();
		this.cpf = cpf;
		this.entrada = entrada;
		this.saida = saida;
	}

	public ResultadoCalculoAtraso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultadoCalculoAtraso(String diferenca, String periodoAtraso) {
=======
    
    public ResultadoCalculoAtraso(String diferenca, String periodoAtraso) {
>>>>>>> f7ebaaf26b0257b9afad7a1bf04762570dc04726
        this.diferenca = diferenca;
        this.periodoAtraso = periodoAtraso;
    }
    
    public ResultadoCalculoAtraso(CodigoErro codigoErro, String mensagem) {
        this.codigoErro = codigoErro;
        this.mensagem = mensagem;
    }
    
    public String getDiferenca() {
        return diferenca;
    }
    
    public String getPeriodoAtraso() {
        return periodoAtraso;
    }
    public CodigoErro getCodigoErro() {
        return codigoErro;
    }

    public String getMensagem() {
        return mensagem;
    }
<<<<<<< HEAD
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

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
=======
>>>>>>> f7ebaaf26b0257b9afad7a1bf04762570dc04726
}
