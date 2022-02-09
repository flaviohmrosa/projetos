package okdados.com.br.api_leinertex.service;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
@Entity(name = "pessoa")
public class ClientesService {

    @Id
    @Column(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column(name = "nome")
    public String nome;

    @OneToMany
    @JoinColumn(name = "id_pessoa")
    public List<InfoClientesService> info;


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

    public List<InfoClientesService> getInfo() {
        return info;
    }

    public void setInfo(List<InfoClientesService> info) {
        this.info = info;
    }
}
