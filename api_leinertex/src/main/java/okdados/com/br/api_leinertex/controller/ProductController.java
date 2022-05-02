package okdados.com.br.api_leinertex.controller;

import okdados.com.br.api_leinertex.dto.ColorByMatizDTO;
import okdados.com.br.api_leinertex.dto.ProductDTO;
import okdados.com.br.api_leinertex.dto.ProductListDTO;
import okdados.com.br.api_leinertex.dto.ResultAllParametersDTO;
import okdados.com.br.api_leinertex.entity.YieldEntity;
import okdados.com.br.api_leinertex.service.ColorService;
import okdados.com.br.api_leinertex.service.ProductService;
import okdados.com.br.api_leinertex.service.ResultService;
import okdados.com.br.api_leinertex.service.YieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/")
public class ProductController {

    @Autowired
    ResultService resultService;
    @Autowired
    ProductService productService;
    @Autowired
    YieldService yieldService;
    @Autowired
    ColorService colorService;

    @GetMapping(path = "filtro-listagem")
    public ResultAllParametersDTO findFilters() {
        return resultService.findResult();
    }

    @GetMapping(path = "lista-produtos/page={page}/limit={limit}")
    public ProductListDTO findProductWithIdAndName( @PathVariable("page") int page,
                                                    @PathVariable("limit") int size,
                                                    @RequestParam(value = "matiz", required = false) String matiz,
                                                    @RequestParam(value = "tipo", required = false) String tipo,
                                                    @RequestParam(value = "linha", required = false) String linha,
                                                    @RequestParam(value = "ambiente", required = false) String ambiente,
                                                    @RequestParam(value = "acabamento", required = false) String acabamento,
                                                    @RequestParam(value = "superficie", required = false) String superficie) {
        return productService.findProductWithIdAndName( page,
                                                        size,
                                                        matiz,
                                                        tipo,
                                                        linha,
                                                        ambiente,
                                                        acabamento,
                                                        superficie);
    }

    @GetMapping(path = "rendimento")
    public List<YieldEntity> findAll() {
        return yieldService.findAll();
    }

    @GetMapping(path = "produto/{id}")
    public  List<ProductDTO> findProductById(@PathVariable("id") String id) {
        return productService.findProductById(id);
    }

    @GetMapping(path = "cores/{matiz}")
    public List<ColorByMatizDTO> findColorByMatiz(@PathVariable("matiz") String matiz) {
        return colorService.findColorByMatiz(matiz);
    }

    @GetMapping(path = "cores-produtos/{hexacode}")
    public List<ColorByMatizDTO> findColorByHexacode(@PathVariable("hexacode") String hexacode) {
        return colorService.findColorByHexacode(hexacode);
    }

}