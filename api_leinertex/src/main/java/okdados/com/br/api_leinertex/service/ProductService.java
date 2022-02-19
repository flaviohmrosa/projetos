package okdados.com.br.api_leinertex.service;


import net.minidev.json.JSONObject;
import okdados.com.br.api_leinertex.controller.dto.LinksDTO;
import okdados.com.br.api_leinertex.controller.dto.ProductDTO;
import okdados.com.br.api_leinertex.controller.dto.ProductListDTO;
import okdados.com.br.api_leinertex.repository.ProductDinamicRepository;
import okdados.com.br.api_leinertex.repository.YieldDinamicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDinamicRepository productDinamicRepository;
    @Autowired
    YieldDinamicRepository yieldDinamicRepository;


    public ProductListDTO findProductWithIdAndName(int page, int size) {

        ProductListDTO productListDTO = new ProductListDTO();
        LinksDTO linksDTO = new LinksDTO();
        JSONObject jsonObj = new JSONObject();

        linksDTO.next = "lista-produtos/page=" + (page + 1);
        linksDTO.prev = "lista-produtos/page=" + page;

        productListDTO.setProdutos(productDinamicRepository.findProductWithIdAndName(page, size));
        productListDTO.setLimit(size);
        productListDTO.setLinks(linksDTO);


        return productListDTO;
    }



    public List<ProductDTO> findProductById(String id) {
        List<ProductDTO> productDTO = new ArrayList<>();

        try {
            productDTO = productDinamicRepository.findProductById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(ProductDTO produto : productDTO )
        {
            produto.setRendimento(yieldDinamicRepository.findByCode(produto.getSit()));
        }

        return productDTO;
    }

}
