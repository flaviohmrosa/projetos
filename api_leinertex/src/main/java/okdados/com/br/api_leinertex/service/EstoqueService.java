package okdados.com.br.api_leinertex.service;


import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Entity(name = "ESTOQUE")
public class EstoqueService {

    @Id
    @Column(name = "id_estoque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "id_produto")
    public Integer idProduto;

    @Column(name = "QUANTIDADE_SAIDA")
    public Float quantidadeSaida;

    @Column(name = "QUANTIDADE_ENTRADA")
    public Float quantidadeEntrada;

    @Column(name = "QUANTIDADE_DISPONIVEL")
    public Float quantidadeDisponivel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Float getQuantidadeSaida() {
        return quantidadeSaida;
    }

    public void setQuantidadeSaida(Float quantidadeSaida) {
        this.quantidadeSaida = quantidadeSaida;
    }

    public Float getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(Float quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }

    public Float getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Float quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
