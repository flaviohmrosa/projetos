package okdados.com.br.api_leinertex.entity.rowmapper;

import okdados.com.br.api_leinertex.dto.ClientDTO;
import okdados.com.br.api_leinertex.dto.ProductIdAndNameDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<ClientDTO> {

    @Override
    public ClientDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setCodigo(rs.getString("CODIGO"));
        clientDTO.setNomeFantasia(rs.getString("FANTASIA"));
        clientDTO.setLogradouro(rs.getString("LOGRADOURO"));
        clientDTO.setFone(rs.getString("FONECOM"));
        clientDTO.setEmail(rs.getString("EMAILCOM"));
        clientDTO.setWhatsapp(rs.getString("WHATSAPP"));
        clientDTO.setComplemento(rs.getString("COMPLEMENTO"));
        clientDTO.setNumero(rs.getString("NUMERO"));
        clientDTO.setBairro(rs.getString("BAIRRO"));
        clientDTO.setCepLogradouro(rs.getLong("CEP_LOGRADOURO"));
        clientDTO.setCidade(rs.getString("CIDADE"));
        clientDTO.setUF(rs.getString("DS_UF"));
        clientDTO.setLatitude(rs.getFloat("LATITUDE"));
        clientDTO.setLongitude(rs.getFloat("LONGITUDE"));
        clientDTO.setRaio(rs.getFloat("RAIO"));

        return clientDTO;
    }
}
