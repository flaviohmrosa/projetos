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

    public List<YieldEntity> findByCode(String code) {

        String sql = "" +
                "select " +
                "  id " +
                " ,disponibilidade " +
                " ,tamanho " +
                " ,medida " +
                " ,rendimento_m2 " +
                " ,disponivel " +
                "from view_api_rendimento " +
                "where codigo = ? ";

        List<YieldEntity> list = jdbcTemplate.query(sql, new Object[] {code}, new YieldRowMapper());
        return list;
    }
}
