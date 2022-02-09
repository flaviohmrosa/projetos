package okdados.com.br.api_leinertex.repository;

import okdados.com.br.api_leinertex.service.ClientesService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesService, Integer> {

    List<ClientesService> findAllById(Integer id);

}