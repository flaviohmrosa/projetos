package okdados.com.br.api_leinertex.rowmapper;

import okdados.com.br.api_leinertex.entity.ProductEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductEntity> {

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(rs.getString("id"));;
        productEntity.setNome(rs.getString("nome"));

        return productEntity;
    }
}
