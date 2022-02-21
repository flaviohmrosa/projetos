package okdados.com.br.api_leinertex.entity.rowmapper;

import okdados.com.br.api_leinertex.dto.ColorDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorRowMapper implements RowMapper<ColorDTO> {

    @Override
    public ColorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ColorDTO colorDTO = new ColorDTO();

        colorDTO.setId(rs.getInt("id"));
        colorDTO.setNome(rs.getString("nome"));
        colorDTO.setCodigoCor(rs.getString("codigo_cor"));
        colorDTO.setDisponivel(rs.getString("disponivel"));

        return colorDTO;
    }
}
