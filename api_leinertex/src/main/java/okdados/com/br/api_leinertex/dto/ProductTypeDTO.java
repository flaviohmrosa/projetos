package okdados.com.br.api_leinertex.dto;

import java.util.List;

public class ProductTypeDTO {

    public String tipoProduto;

    private List<ProductIdAndNameDTO> produtos;

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public List<ProductIdAndNameDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductIdAndNameDTO> produtos) {
        this.produtos = produtos;
    }
}
