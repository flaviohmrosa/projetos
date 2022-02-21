package okdados.com.br.api_leinertex.entity.rowmapper;

import okdados.com.br.api_leinertex.dto.ColorByMatizDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorByMatizRowMapper implements RowMapper<ColorByMatizDTO> {

    @Override
    public ColorByMatizDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ColorByMatizDTO colorByMatizDTO = new ColorByMatizDTO();

        colorByMatizDTO.setMatiz(rs.getString("matiz"));
        colorByMatizDTO.setId(rs.getInt("id"));
        colorByMatizDTO.setNome(rs.getString("nome"));
        colorByMatizDTO.setCodigoCor(rs.getString("codigo_cor"));
        colorByMatizDTO.setDisponivel(rs.getString("disponivel"));

        return colorByMatizDTO;
    }
}
