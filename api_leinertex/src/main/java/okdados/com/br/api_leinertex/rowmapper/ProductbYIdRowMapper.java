package okdados.com.br.api_leinertex.rowmapper;

import okdados.com.br.api_leinertex.dto.ProductDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductbYIdRowMapper implements RowMapper<ProductDTO> {

    @Override
    public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(rs.getString("id"));
        productDTO.setNome(rs.getString("nome"));
        productDTO.setCategoria_tipo(rs.getString("categoria_tipo"));
        productDTO.setLinha(rs.getString("linha"));
        productDTO.setAcabamento(rs.getString("acabamento"));
        productDTO.setSuperficie(rs.getString("superficie"));
        productDTO.setAmbiente(rs.getString("ambiente"));


        return productDTO;
    }
}
