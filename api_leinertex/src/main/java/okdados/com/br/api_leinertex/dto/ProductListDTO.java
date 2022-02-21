package okdados.com.br.api_leinertex.dto;

import okdados.com.br.api_leinertex.entity.ProductEntity;

import java.util.List;

public class ProductListDTO {

    public List<ProductEntity> produtos;
    public int limit;
    public LinksDTO links;

    public ProductListDTO(){}

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public LinksDTO getLinks() {
        return links;
    }

    public void setLinks(LinksDTO links) {
        this.links = links;
    }

    public List<ProductEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductEntity> produtos) {
        this.produtos = produtos;
    }
}
