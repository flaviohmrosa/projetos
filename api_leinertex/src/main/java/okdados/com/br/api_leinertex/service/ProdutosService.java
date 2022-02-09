package okdados.com.br.api_leinertex.service;


import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Service
@Entity(name = "PRODUTOS")
public class ProdutosService implements Serializable {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "descricao")
    public String descricao;

    @Column(name = "id_grupo_produto")
    public Integer idGrupoProduto;

    @OneToMany
    @JoinColumn(referencedColumnName = "id_produto", name = "id_produto")
    public List<EstoqueService> estoque;

    @OneToMany
    @JoinColumn(referencedColumnName = "id_grupo_produto", name = "id_grupo_produto")
    public List<GrupoProdutoService> grupo;


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

    public Integer getIdGrupoProduto() {
        return idGrupoProduto;
    }

    public void setIdGrupoProduto(Integer idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }

    public List<EstoqueService> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<EstoqueService> estoque) {
        this.estoque = estoque;
    }

    public List<GrupoProdutoService> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<GrupoProdutoService> grupo) {
        this.grupo = grupo;
    }
}
