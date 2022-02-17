package okdados.com.br.api_leinertex.service;


import okdados.com.br.api_leinertex.dto.LinksDTO;
import okdados.com.br.api_leinertex.dto.ProductListDTO;
import okdados.com.br.api_leinertex.repository.ProductDinamicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductDinamicRepository productDinamicRepository;


    public ProductListDTO findAll(int page, int size) {

        ProductListDTO productListDTO = new ProductListDTO();
        LinksDTO linksDTO = new LinksDTO();

        linksDTO.next = "lista-produtos/page=" + (page + 1);
        linksDTO.prev = "lista-produtos/page=" + page;

        productListDTO.setProdutos(productDinamicRepository.findAllProduct(page, size));
        productListDTO.setLimit(size);
        productListDTO.setLinks(linksDTO);

        return productListDTO;
    }

}
