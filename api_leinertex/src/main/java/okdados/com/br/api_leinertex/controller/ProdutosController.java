package okdados.com.br.api_leinertex.controller;


import okdados.com.br.api_leinertex.repository.ProdutosRepository;
import okdados.com.br.api_leinertex.service.ProdutosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produto")
public class ProdutosController {

    private final ProdutosRepository produtosRepository;

    public ProdutosController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @GetMapping
    public Page<ProdutosService> findAll(Pageable pageable) {
        return produtosRepository.findAll(pageable);
    }

    @GetMapping(path = "{id}")
    public Page<ProdutosService> findById(Pageable pageable, @PathVariable("id") Integer id) {
        return produtosRepository.findByIdPage(pageable, id);
    }

    @GetMapping("/filter")
    public List<ProdutosService> findProdutctByDescription(@RequestParam("name") String name) {
        return this.produtosRepository.findByDescricaoContains(name);
    }

    @GetMapping("/sql/{id}")
    public List<ProdutosService> findAllById(@PathVariable("id") Integer id) {
        return produtosRepository.findAllById(id);
    }

    @GetMapping("/estudo/paginacao-simples")
    public Page<ProdutosService> paginacaoSimples() {
        return produtosRepository.findAll(PageRequest.of(0,10));
    }

}