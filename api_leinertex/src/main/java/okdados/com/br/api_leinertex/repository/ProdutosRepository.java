package okdados.com.br.api_leinertex.repository;


import okdados.com.br.api_leinertex.service.ProdutosService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosService, Integer> {

    List<ProdutosService> findByDescricaoContains(String nome);

    @Query(value = "SELECT * FROM PRODUTOS WHERE ID_PRODUTO = :id", nativeQuery = true)
    Page<ProdutosService> findByIdPage(Pageable pageable, @Param("id") Integer id);

    @Query(value =  "" +
                    "SELECT  " +
                    "    * " +
                    "FROM PRODUTOS " +
                    "WHERE ID_PRODUTO = :id ", nativeQuery = true)
    List<ProdutosService> findAllById(@Param("id") Integer id);
}
