package okdados.com.br.api_leinertex.entity.rowmapper;

import okdados.com.br.api_leinertex.dto.ProductIdAndNameDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductIdAndNameRowMapper implements RowMapper<ProductIdAndNameDTO> {

    @Override
    public ProductIdAndNameDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProductIdAndNameDTO productIdAndNameDTO = new ProductIdAndNameDTO();

        productIdAndNameDTO.setId(rs.getString("id"));
        productIdAndNameDTO.setNome(rs.getString("nome"));

        return productIdAndNameDTO;
    }
}
