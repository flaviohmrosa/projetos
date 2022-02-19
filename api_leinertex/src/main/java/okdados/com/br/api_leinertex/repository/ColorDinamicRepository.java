package okdados.com.br.api_leinertex.repository;


import okdados.com.br.api_leinertex.controller.dto.MatizDTO;
import okdados.com.br.api_leinertex.controller.dto.ProductDTO;
import okdados.com.br.api_leinertex.entity.ProductEntity;
import okdados.com.br.api_leinertex.rowmapper.MatizByProductIdRowMapper;
import okdados.com.br.api_leinertex.rowmapper.ProductRowMapper;
import okdados.com.br.api_leinertex.rowmapper.ProductbYIdRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDinamicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ProductEntity> findProductWithIdAndName(int page, int size) {

        String sql = "" +
                    "select " +
                    "  id " +
                    " ,nome " +
                    "from view_api_produtos " +
                    "group by id " +
                    "        ,nome " +
                    "order by nome " +
                    "OFFSET (? - 1) * ? ROWS  " +
                    "FETCH NEXT ? ROWS ONLY ";

        List<ProductEntity> list = jdbcTemplate.query(sql, new Object[] {page, size, size}, new ProductRowMapper());
        return list;
    }


    public List<ProductDTO> findProductById(String id) {

        String sql = "" +
                    "select  " +
                    "  id " +
                    " ,nome " +
                    " ,categoria_tipo " +
                    " ,linha " +
                    " ,acabamento " +
                    " ,superficie " +
                    " ,ambiente " +
                    " ,sit " +
                    "from view_api_produtos " +
                    "where id = ? ";

        List<ProductDTO> list = jdbcTemplate.query(sql, new Object[] {id}, new ProductbYIdRowMapper());
        return list;
    }

    public List<MatizDTO> findMatizByProductId(String productId) {
        String sql = "" +
                    "SELECT " +
                    "  SUBSTRING(A.SUBCLASSE,1,2) id_produto  " +
                    " ,LTRIM(RTRIM(MATIZ_1)) matiz " +
                    " ,VA.ID id " +
                    "FROM BCEST61 A " +
                    " INNER JOIN VIEW_API_MATIZ VA ON VA.DESCRICAO = LTRIM(RTRIM(MATIZ_1)) " +
                    "WHERE A.SUBGRUPO = 2  " +
                    "AND ATIVO_SITE = 'S'  " +
                    "AND SUBSTRING(A.SUBCLASSE,1,2) = ? " +
                    "GROUP BY SUBSTRING(A.SUBCLASSE,1,2)  " +
                    "        ,MATIZ_1 " +
                    "        ,VA.ID";

        List<MatizDTO> list = jdbcTemplate.query(sql, new Object[] {productId}, new MatizByProductIdRowMapper());
        return list;
    }
}
