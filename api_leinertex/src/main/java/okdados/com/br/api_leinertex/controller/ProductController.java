package okdados.com.br.api_leinertex.controller;

import okdados.com.br.api_leinertex.dto.ProductDTO;
import okdados.com.br.api_leinertex.dto.ProductListDTO;
import okdados.com.br.api_leinertex.dto.ResultAllParametersDTO;
import okdados.com.br.api_leinertex.entity.YieldEntity;
import okdados.com.br.api_leinertex.service.ProductService;
import okdados.com.br.api_leinertex.service.ResultService;
import okdados.com.br.api_leinertex.service.YieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class ProductController {

    @Autowired
    ResultService resultService;
    @Autowired
    ProductService productService;
    @Autowired
    YieldService yieldService;


    @GetMapping(path = "/filtro-listagem")
    public ResultAllParametersDTO findFilters() {
        return resultService.findResult();
    }

    @GetMapping(path = "lista-produtos/page={page}/limit={limit}")
    public ProductListDTO findProductWithIdAndName(@PathVariable("page") int page,
                                                    @PathVariable("limit") int size) {
        return productService.findProductWithIdAndName(page, size);
    }

    @GetMapping(path = "/rendimento")
    public List<YieldEntity> findAll() {
        return yieldService.findAll();
    }

    @GetMapping(path = "produto/{id}")
    public  List<ProductDTO> findProductById(@PathVariable("id") String id) {
        return productService.findProductById(id);
    }

}