package okdados.com.br.api_leinertex.service;


import okdados.com.br.api_leinertex.dto.ClientDTO;
import okdados.com.br.api_leinertex.repository.ClientDinamicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDinamicRepository clientDinamicRepository;

    public List<ClientDTO> findByCep(String cep) {

        return clientDinamicRepository.findByCep(cep);
    }
}
