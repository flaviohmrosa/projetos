package okdados.com.br.api_leinertex.controller;


import okdados.com.br.api_leinertex.dto.ClientDTO;
import okdados.com.br.api_leinertex.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(path = "/onde-encontrar/{cep}")
    public List<ClientDTO> findByCep(@PathVariable("cep") String cep) {

        return clientService.findByCep(cep);
    }

}
