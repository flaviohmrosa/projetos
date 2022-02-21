package okdados.com.br.api_leinertex.service;


import net.minidev.json.JSONObject;
import okdados.com.br.api_leinertex.dto.LinksDTO;
import okdados.com.br.api_leinertex.dto.MatizDTO;
import okdados.com.br.api_leinertex.dto.ProductDTO;
import okdados.com.br.api_leinertex.dto.ProductListDTO;
import okdados.com.br.api_leinertex.repository.ColorDinamicRepository;
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
    @Autowired
    ColorDinamicRepository colorDinamicRepository;


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

    public List<MatizDTO> findMatizByProductId(String productId) {

        return productDinamicRepository.findMatizByProductId(productId);

    }



    public List<ProductDTO> findProductById(String id) {
        List<ProductDTO> productDTO = new ArrayList<>();

        productDTO = productDinamicRepository.findProductById(id);

        for(ProductDTO produto : productDTO )
        {
            produto.setRendimento(yieldDinamicRepository.findByProductId(id));
            produto.setMatiz(this.findMatizByProductId(produto.getId()));
            for(MatizDTO matizDTO : produto.getMatiz()) {
                matizDTO.setCor(colorDinamicRepository.findColorByMatizAndProduct(produto.getId(), matizDTO.getId()));
            }
        }

        return productDTO;
    }



}
