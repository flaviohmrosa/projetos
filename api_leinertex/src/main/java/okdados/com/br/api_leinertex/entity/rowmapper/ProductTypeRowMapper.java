package okdados.com.br.api_leinertex.entity.rowmapper;

import okdados.com.br.api_leinertex.dto.ProductTypeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductTypeRowMapper implements RowMapper<ProductTypeDTO> {

    @Override
    public ProductTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProductTypeDTO productTypeDTO = new ProductTypeDTO();

        productTypeDTO.setTipoProduto(rs.getString("tipo_produto"));

        return productTypeDTO;
    }
}
