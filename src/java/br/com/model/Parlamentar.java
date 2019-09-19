package br.com.model;

/**
 *
 * @author guto
 */
public class Parlamentar {
    public int codigo;
    public String nome;
    public String federacao;
    public String partido;
    public String voto;
    
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getFederacao() {
        return nome;
    }

    public void setFederacao(String federacao) {
        this.federacao = federacao;
    }
    
    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    
    public String getvoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
