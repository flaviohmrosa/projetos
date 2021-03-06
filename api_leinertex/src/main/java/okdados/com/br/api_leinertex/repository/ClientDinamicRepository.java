package okdados.com.br.api_leinertex.repository;

import okdados.com.br.api_leinertex.dto.ClientDTO;
import okdados.com.br.api_leinertex.dto.ProductIdAndNameDTO;
import okdados.com.br.api_leinertex.entity.rowmapper.ClientRowMapper;
import okdados.com.br.api_leinertex.entity.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClientDinamicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ClientDTO> findByCep(String cep) {
        List<ClientDTO> list = new ArrayList<>();
        final Map<String, Object> map = new HashMap<>();
        map.put("cep", cep);

        String sql = "" +
                "SELECT " +
                " * " +
                "FROM ( " +
                        " SELECT TOP 10 " +
                        " LTRIM(RTRIM(A.CODIGO)) CODIGO,  " +
                        " LTRIM(RTRIM(A.FANTASIA)) FANTASIA,  " +
                        " LTRIM(RTRIM(L.NOME)) LOGRADOURO,  " +
                        " LTRIM(RTRIM(A.FONECOM)) FONECOM,  " +
                        " LTRIM(RTRIM(A.EMAILCOM)) EMAILCOM,  " +
                        " LTRIM(RTRIM(A.WHATSAPP)) WHATSAPP,  " +
                        " LTRIM(RTRIM(A.COMPLEMENTO)) COMPLEMENTO,  " +
                        " LTRIM(RTRIM(A.NUMERO)) NUMERO,  " +
                        " LTRIM(RTRIM(B.NOME)) BAIRRO,  " +
                        " CAST(CASE WHEN ISNUMERIC(REPLACE(REPLACE(L.CEP_LOGRADOURO, '-', ''), '.', '')) = 0 THEN '0' " +
                        "           ELSE REPLACE(REPLACE(L.CEP_LOGRADOURO, '-', ''), '.', '') " +
                        "           END AS BIGINT) CEP_LOGRADOURO,  " +
                        " LTRIM(RTRIM(C.DESCRICAO)) CIDADE,  " +
                        " LTRIM(RTRIM(L.DS_UF)) DS_UF,  " +
                        " A.LATITUDE,  " +
                        " A.LONGITUDE, " +
                        " dbo.fncCalcula_Distancia_Coordenada_CEP(A.LATITUDE,A.LONGITUDE, :cep) RAIO " +
                        " FROM BREC04 AS A  " +
                        " INNER JOIN LOGRADOURO AS L ON L.LOGRADOURO_ID = A.CD_LOGRADOURO  " +
                        " INNER JOIN BAIRROS AS B ON B.BAIRRO_ID = A.CD_BAIRRO  " +
                        " INNER JOIN BREC03 AS C ON C.CODIGO = A.COD_CIDADE  " +
                        " WHERE DATA_ULT_COMPRA > (GETDATE() - 180) AND BLOQUEADO = 'N' " +
                        " ) TA " +
                "ORDER BY TA.RAIO ";


        list = this.namedParameterJdbcTemplate.query(sql,map,new ClientRowMapper());

        return list;

    }
}
