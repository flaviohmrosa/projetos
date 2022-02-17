package okdados.com.br.api_leinertex.repository;


import okdados.com.br.api_leinertex.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String>{

}
