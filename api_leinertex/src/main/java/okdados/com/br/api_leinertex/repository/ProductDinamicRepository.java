package okdados.com.br.api_leinertex.repository;


import okdados.com.br.api_leinertex.entity.ProductEntity;
import okdados.com.br.api_leinertex.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDinamicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<ProductEntity> findAllProduct(int page, int size) {

        String sql = "" +
                    "SELECT " +
                    "  CODIGO " +
                    " ,DESCRICAO " +
                    "FROM BCEST61 " +
                    "ORDER BY DESCRICAO " +
                    "OFFSET (? - 1) * ? ROWS " +
                    "FETCH NEXT ? ROWS ONLY ";

        List<ProductEntity> list = jdbcTemplate.query(sql, new Object[] {page, size, size}, new ProductRowMapper());

        return list;
    }
}
