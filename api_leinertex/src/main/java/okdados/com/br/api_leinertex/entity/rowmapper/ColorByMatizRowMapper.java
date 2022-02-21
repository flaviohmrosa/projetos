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

        if(colorByMatizDTO.getCodigoCor() != null) {
            String red;
            String green;
            String blue;

            red = colorByMatizDTO.getCodigoCor().substring(0, 3);
            green = colorByMatizDTO.getCodigoCor().substring(3, 6);
            blue = colorByMatizDTO.getCodigoCor().substring(6, 9);

            String hex = String.format("#%02X%02X%02X", Integer.parseInt(red),
                    Integer.parseInt(green),
                    Integer.parseInt(blue));

            colorByMatizDTO.setCodigoCor(hex);
        }

        return colorByMatizDTO;
    }
}
