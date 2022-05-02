package okdados.com.br.api_leinertex.dto;

import java.util.List;

public class ColorByMatizDTO {

    public Integer id;
    public String matiz;
    public String nome;
    public String codigoCor;
    public String disponivel;

    private List<ProductTypeDTO> produtos;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoCor() {
        return codigoCor;
    }

    public void setCodigoCor(String codigoCor) {
        this.codigoCor = codigoCor;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getMatiz() {
        return matiz;
    }

    public void setMatiz(String matiz) {
        this.matiz = matiz;
    }

    public List<ProductTypeDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductTypeDTO> produtos) {
        this.produtos = produtos;
    }
}
