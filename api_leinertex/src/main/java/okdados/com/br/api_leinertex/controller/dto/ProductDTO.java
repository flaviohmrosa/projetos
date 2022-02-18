package okdados.com.br.api_leinertex.dto;

public class ProductDTO {

    public String id;
    public String nome;
    public String categoria_tipo;
    public String linha;
    public String acabamento;
    public String superficie;
    public String ambiente;
    public String sit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria_tipo() {
        return categoria_tipo;
    }

    public void setCategoria_tipo(String categoria_tipo) {
        this.categoria_tipo = categoria_tipo;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getSit() {
        return sit;
    }

    public void setSit(String sit) {
        this.sit = sit;
    }
}
