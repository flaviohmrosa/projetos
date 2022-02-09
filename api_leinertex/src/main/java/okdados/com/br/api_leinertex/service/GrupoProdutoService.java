package okdados.com.br.api_leinertex.service;


import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity(name = "GRUPO_PRODUTO")
public class GrupoProdutoService {

    @Id
    @Column(name = "id_grupo_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "descricao")
    public String descricao;


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
}
