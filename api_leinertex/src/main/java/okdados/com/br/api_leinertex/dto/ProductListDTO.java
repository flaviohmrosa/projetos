package okdados.com.br.api_leinertex.dto;

import java.util.List;

public class ProductListDTO {

    public List<ProductIdAndNameDTO> produtos;
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

    public List<ProductIdAndNameDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductIdAndNameDTO> produtos) {
        this.produtos = produtos;
    }
}
