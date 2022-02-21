package okdados.com.br.api_leinertex.repository;

import okdados.com.br.api_leinertex.entity.YieldEntity;
import okdados.com.br.api_leinertex.rowmapper.YieldRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class YieldDinamicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<YieldEntity> findByProductId(String productId) {

        String sql = "" +
                "SELECT " +
                "  LTRIM(RTRIM(C.DESCRICAO)) AS disponibilidade " +
                " ,C.VOLUME AS tamanho " +
                " ,LTRIM(RTRIM(C.VOLUME_ETIQUETA)) AS medida " +
                " ,B.FATOR_CONV AS rendimento_m2 " +
                " ,CASE WHEN A.ATIVO_SITE = 'S'  " +
                "       THEN 'Sim' " +
                "       ELSE 'Não' " +
                "       END AS disponivel " +
                "FROM BCEST61 A " +
                " LEFT JOIN CADEMB C ON A.SIT = C.CODIGO " +
                " LEFT JOIN BCEST122 D ON (A.COMISSAO = D.CODIGO AND 'A' = D.LETRA) " +
                " LEFT JOIN TBL_CLASSIF_PROD B ON A.ID_CODIGO_CLASSE = B.ID_CODIGO_CLASSE " +
                "WHERE A.SUBGRUPO = 2 " +
                "AND ATIVO_SITE = 'S' " +
                "AND SUBSTRING(A.SUBCLASSE,1,2) = ? " +
                "GROUP BY C.DESCRICAO " +
                " ,C.VOLUME " +
                " ,C.VOLUME_ETIQUETA " +
                " ,B.FATOR_CONV " +
                " ,A.ATIVO_SITE";

        List<YieldEntity> list = jdbcTemplate.query(sql, new Object[] {productId}, new YieldRowMapper());
        return list;
    }
}
