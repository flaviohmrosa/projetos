package okdados.com.br.api_leinertex.entity.rowmapper;

import okdados.com.br.api_leinertex.dto.MatizDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatizByProductIdRowMapper implements RowMapper<MatizDTO> {

    @Override
    public MatizDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        MatizDTO matizDTO = new MatizDTO();

        matizDTO.setIdProduto(rs.getString("id_produto"));
        matizDTO.setDescricao(rs.getString("matiz"));
        matizDTO.setId(rs.getInt("id"));

        return matizDTO;
    }
}
