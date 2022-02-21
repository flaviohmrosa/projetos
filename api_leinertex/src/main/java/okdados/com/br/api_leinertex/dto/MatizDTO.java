package okdados.com.br.api_leinertex.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class MatizDTO {

    @JsonIgnore
    public Integer id;
    @JsonIgnore
    public String idProduto;
    public String descricao;

    List<ColorDTO> cor;

    public MatizDTO(){}

    public MatizDTO(String idProduto, Integer id, String descricao, List<ColorDTO> cor) {
        this.idProduto = idProduto;
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ColorDTO> getCor() {
        return cor;
    }

    public void setCor(List<ColorDTO> cor) {
        this.cor = cor;
    }
}
