    package okdados.com.br.api_leinertex.controller;


    import okdados.com.br.api_leinertex.repository.ClientesRepository;
    import okdados.com.br.api_leinertex.service.ClientesService;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @RestController
    @RequestMapping(value = "/clientes")
    public class ClientesController {

        public final ClientesRepository clientesRepository;

        public ClientesController(ClientesRepository clientesRepository) {
            this.clientesRepository = clientesRepository;
        }

        @GetMapping
        public List<ClientesService> findAll() {

            return clientesRepository.findAll();
        }

        @GetMapping(value = "/{id}")
        public List<ClientesService> findAllById(@PathVariable("id") Integer id) {

            return clientesRepository.findAllById(id);
        }
    }
