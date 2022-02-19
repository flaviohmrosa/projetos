package okdados.com.br.api_leinertex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_api_rendimento")
public class YieldEntity {

    @Id
    @JsonIgnore
    public Integer id;
    public String disponibilidade;
    public Float tamanho;
    public String medida;
    public Float rendimento_m2;
    public String disponivel;
    @JsonIgnore
    public String codigo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Float getRendimento_m2() {
        return rendimento_m2;
    }

    public void setRendimento_m2(Float rendimento_m2) {
        this.rendimento_m2 = rendimento_m2;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


}
