package okdados.com.br.api_leinertex.repository;


import okdados.com.br.api_leinertex.controller.dto.ColorDTO;
import okdados.com.br.api_leinertex.rowmapper.ColorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColorDinamicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ColorDTO> findColorByMatizAndProduct(String idProduto, int idMatiz) {

        String sql = "" +
                    "SELECT  " +
                    "  a.CODIGO id " +
                    " ,LTRIM(RTRIM(a.DESCRICAO)) nome " +
                    " ,LTRIM(RTRIM(b.COD_RGB_PROD)) codigo_cor" +
                    " ,case when b.ATIVO_SITE = 'S' then 'Sim' else 'Não' end disponivel " +
                    "FROM BCEST73 A  " +
                    " INNER JOIN BCEST61 B ON A.CODIGO = B.COR " +
                    " INNER JOIN VIEW_API_MATIZ VA ON VA.DESCRICAO = LTRIM(RTRIM(B.MATIZ_1)) " +
                    "WHERE SUBSTRING(B.SUBCLASSE,1,2) = ? " +
                    "AND VA.ID = ? " +
                    "GROUP BY a.CODIGO " +
                    "        ,a.DESCRICAO " +
                    "        ,b.COD_RGB_PROD " +
                    "        ,b.ATIVO_SITE ";

        List<ColorDTO> list = jdbcTemplate.query(sql, new Object[] {idProduto, idMatiz}, new ColorRowMapper());
        return list;
    }

}
