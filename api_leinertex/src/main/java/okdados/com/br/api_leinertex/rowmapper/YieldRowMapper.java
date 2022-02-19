package okdados.com.br.api_leinertex.rowmapper;

import okdados.com.br.api_leinertex.entity.YieldEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class YieldRowMapper implements RowMapper<YieldEntity> {

    @Override
    public YieldEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

        YieldEntity yieldEntity = new YieldEntity();

        yieldEntity.setDisponibilidade(rs.getString("disponibilidade"));
        yieldEntity.setTamanho(rs.getFloat("tamanho"));
        yieldEntity.setMedida(rs.getString("medida"));
        yieldEntity.setRendimento_m2(rs.getFloat("rendimento_m2"));
        yieldEntity.setDisponivel(rs.getString("disponivel"));

        return yieldEntity;
    }
}