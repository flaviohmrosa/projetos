package okdados.com.br.api_leinertex.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import okdados.com.br.api_leinertex.entity.YieldEntity;

import java.util.List;

public class ProductDTO {

    public String id;
    public String nome;
    public String categoria_tipo;
    public String linha;
    public String acabamento;
    public String superficie;
    public String ambiente;
    @JsonIgnore
    public String sit;

    private List<YieldEntity> rendimento;



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

    public List<YieldEntity> getRendimento() {
        return rendimento;
    }

    public void setRendimento(List<YieldEntity> rendimento) {
        this.rendimento = rendimento;
    }
}
