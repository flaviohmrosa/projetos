package okdados.com.br.api_leinertex.repository;


import okdados.com.br.api_leinertex.dto.ColorByMatizDTO;
import okdados.com.br.api_leinertex.dto.ColorDTO;
import okdados.com.br.api_leinertex.entity.rowmapper.ColorByMatizRowMapper;
import okdados.com.br.api_leinertex.entity.rowmapper.ColorRowMapper;
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
                    "  a.CODIGO id  " +
                    " ,LTRIM(RTRIM(a.DESCRICAO)) nome  " +
                    " ,LTRIM(RTRIM(b.COD_RGB_PROD)) codigo_cor " +
                    " ,case when b.ATIVO_SITE = 'S' then 'Sim' else 'Não' end disponivel  " +
                    "FROM BCEST73 a   " +
                    " INNER JOIN BCEST61 b ON a.CODIGO = b.COR  " +
                    " INNER JOIN view_api_matiz VA ON VA.descricao = LTRIM(RTRIM(b.MATIZ_1))  " +
                    "WHERE SUBSTRING(b.SUBCLASSE,1,2) = ?  " +
                    "AND VA.id = ?  " +
                    "AND a.DESCRICAO <> '' " +
                    "GROUP BY a.CODIGO  " +
                    "        ,a.DESCRICAO  " +
                    "        ,b.COD_RGB_PROD  " +
                    "        ,b.ATIVO_SITE ";

        List<ColorDTO> list = jdbcTemplate.query(sql, new Object[] {idProduto, idMatiz}, new ColorRowMapper());
        return list;
    }

    public List<ColorByMatizDTO> findColorByMatiz(String matiz) {

        String sql = "" +
                    "SELECT  " +
                    " LTRIM(RTRIM(A.MATIZ_1)) AS 'matiz', " +
                    " A.COR AS 'id', " +
                    " LTRIM(RTRIM(E.DESCRICAO)) AS 'nome', " +
                    " LTRIM(RTRIM(A.COD_RGB_PROD)) AS 'codigo_cor', " +
                    " case when A.ATIVO_SITE = 'S' then 'Sim' else 'Não' end disponivel " +
                    "FROM BCEST61 A " +
                    " LEFT JOIN CADEMB C on A.SIT = C.CODIGO " +
                    " LEFT JOIN BCEST73 E ON A.COR = E.CODIGO " +
                    " LEFT JOIN BCEST122 D ON (A.COMISSAO = D.CODIGO and 'A' = D.LETRA) " +
                    " LEFT JOIN TBL_CLASSIF_PROD B ON A.ID_CODIGO_CLASSE = B.ID_CODIGO_CLASSE " +
                    "WHERE A.SUBGRUPO = 2 " +
                    "AND ATIVO_SITE = 'S' " +
                    "AND A.MATIZ_1 = ? " +
                    "GROUP BY  A.MATIZ_1, " +
                            " A.COR, " +
                            " E.DESCRICAO, " +
                            " A.COD_RGB_PROD, " +
                            " A.ATIVO_SITE ";

        List<ColorByMatizDTO> list = jdbcTemplate.query(sql, new Object[] {matiz}, new ColorByMatizRowMapper());
        return list;
    }

}
