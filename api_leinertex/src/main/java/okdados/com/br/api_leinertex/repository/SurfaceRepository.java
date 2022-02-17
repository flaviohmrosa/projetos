package okdados.com.br.api_leinertex.repository;

import okdados.com.br.api_leinertex.entity.SurfaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurfaceRepository extends JpaRepository<SurfaceEntity, Long> {
}
