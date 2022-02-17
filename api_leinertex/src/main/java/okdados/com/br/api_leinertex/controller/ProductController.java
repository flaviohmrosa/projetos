package okdados.com.br.api_leinertex.controller;

import okdados.com.br.api_leinertex.dto.ProductListDTO;
import okdados.com.br.api_leinertex.dto.ResultAllParametersDTO;
import okdados.com.br.api_leinertex.service.ProductService;
import okdados.com.br.api_leinertex.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class ProductController {

    @Autowired
    ResultService resultService;
    @Autowired
    ProductService productService;

    @GetMapping(path = "/filtro-listagem")
    public ResultAllParametersDTO findFilters() {
        return resultService.findResult();
    }

    @GetMapping(path = "lista-produtos/page={page}/limit={limit}")
    public ProductListDTO findAll(@PathVariable("page") int page,
                                  @PathVariable("limit") int size) {

        return productService.findAll(page, size);
    }
}