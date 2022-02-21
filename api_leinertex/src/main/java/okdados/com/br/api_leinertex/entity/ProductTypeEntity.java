package okdados.com.br.api_leinertex.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static jdk.nashorn.internal.objects.NativeString.trim;

@Entity
@Table(name = "VIEW_API_TIPO_PRODUTO")
public class ProductTypeEntity {

    @Id
    public Long id;

    @Column
    public String descricao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return trim(descricao);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
