package okdados.com.br.api_leinertex.entity.rowmapper;

import okdados.com.br.api_leinertex.dto.ProductIdAndNameDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductIdAndNameDTO> {

    @Override
    public ProductIdAndNameDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProductIdAndNameDTO productEntity = new ProductIdAndNameDTO();

        productEntity.setId(rs.getString("id"));;
        productEntity.setNome(rs.getString("nome"));

        return productEntity;
    }
}
