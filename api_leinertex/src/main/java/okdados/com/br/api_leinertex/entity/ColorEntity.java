package okdados.com.br.api_leinertex.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ColorEntity {

    @Id
    public Integer id;
    public String descricao;
    public String codigoRgb;


    public ColorEntity(){}

    public ColorEntity(Integer id, String descricao, String codigoRgb) {
        this.id = id;
        this.descricao = descricao;
        this.codigoRgb = codigoRgb;
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

    public String getCodigoRgb() {
        return codigoRgb;
    }

    public void setCodigoRgb(String codigoRgb) {
        this.codigoRgb = codigoRgb;
    }
}
