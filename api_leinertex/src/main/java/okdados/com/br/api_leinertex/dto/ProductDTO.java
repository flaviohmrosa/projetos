package okdados.com.br.api_leinertex.dto;

import okdados.com.br.api_leinertex.entity.ProductEntity;

import java.util.List;

public class ProductDTO {

    private List<ProductEntity> produtos;

    public List<ProductEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductEntity> produtos) {
        this.produtos = produtos;
    }

}
