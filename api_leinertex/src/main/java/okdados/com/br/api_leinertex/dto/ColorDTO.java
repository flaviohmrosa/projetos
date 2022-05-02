package okdados.com.br.api_leinertex.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ColorDTO {

    public Integer id;
    @JsonIgnore
    public Integer idMatiz;
    public String nome;
    public String codigoCor;
    public String disponivel;

    public ColorDTO(){}

    public ColorDTO(Integer id, Integer idMatiz, String nome, String codigoCor, String disponivel) {
        this.id = id;
        this.idMatiz = idMatiz;
        this.nome = nome;
        this.codigoCor = codigoCor;
        this.disponivel = disponivel;
    }

    public ColorDTO(Integer valueOf, Integer valueOf1, Integer valueOf2) {
    }

    public ColorDTO(Integer valueOf, Integer valueOf1, Integer valueOf2, Integer valueOf3) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMatiz() {
        return idMatiz;
    }

    public void setIdMatiz(Integer idMatiz) {
        this.idMatiz = idMatiz;
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
}
