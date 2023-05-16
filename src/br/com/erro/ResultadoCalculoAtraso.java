package br.com.erro;
import br.com.Entity.CodigoErro;

public class ResultadoCalculoAtraso {
    private String diferenca;
    private String periodoAtraso;
    private CodigoErro codigoErro;
    private String mensagem;
    
    public ResultadoCalculoAtraso(String diferenca, String periodoAtraso) {
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
}
