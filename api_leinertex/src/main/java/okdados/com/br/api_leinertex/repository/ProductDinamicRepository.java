package okdados.com.br.api_leinertex.repository;


import okdados.com.br.api_leinertex.dto.MatizDTO;
import okdados.com.br.api_leinertex.dto.ProductDTO;
import okdados.com.br.api_leinertex.dto.ProductIdAndNameDTO;
import okdados.com.br.api_leinertex.dto.ProductTypeDTO;
import okdados.com.br.api_leinertex.entity.rowmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDinamicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @PersistenceContext
    private EntityManager entityManager;


    public List<ProductIdAndNameDTO> findProductWithIdAndName(int page,
                                                                int size,
                                                                String matiz,
                                                                String tipo,
                                                                String linha,
                                                                String ambiente,
                                                                String acabamento,
                                                                String superficie) {

        List<ProductIdAndNameDTO> list = new ArrayList<>();
        final Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("size", size);

        String sql = "" +
                    "SELECT " +
                    "  SUBSTRING(A.SUBCLASSE,1,2) AS 'id' " +
                    " ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) AS 'nome' " +
                    "FROM BCEST61 A " +
                    " LEFT JOIN TBL_CLASSIF_PROD B ON A.ID_CODIGO_CLASSE = B.ID_CODIGO_CLASSE " +
                    "WHERE A.SUBGRUPO = 2 " +
                    "AND ATIVO_SITE = 'S' ";

        if(matiz != null){
            map.put("matiz", matiz);
            sql +=" AND A.MATIZ_1 COLLATE sql_latin1_general_cp1251_ci_as = UPPER(:matiz) ";
        }

        if(tipo != null){
            map.put("tipo", tipo);
            sql +=" AND A.TIPO_PRODUTO COLLATE sql_latin1_general_cp1251_ci_as = UPPER(:tipo) ";
        }

        if(linha != null){
            map.put("linha", linha);
            sql +=" AND A.LINHA_SITE COLLATE sql_latin1_general_cp1251_ci_as = UPPER(:linha) ";
        }

        if(ambiente != null){
            map.put("ambiente", ambiente);
            sql +=" AND A.AMBIENTE COLLATE sql_latin1_general_cp1251_ci_as = UPPER(:ambiente) ";
        }

        if(acabamento != null){
            map.put("acabamento", acabamento);
            sql +=" AND A.ACABAMENTO COLLATE sql_latin1_general_cp1251_ci_as = UPPER(:acabamento) ";
        }

        if(superficie != null){
            map.put("superficie", superficie);
            sql +=" AND A.SUPERFICIE_1 COLLATE sql_latin1_general_cp1251_ci_as = UPPER(:superficie) ";
        }

        sql +=  " group by SUBSTRING(A.SUBCLASSE,1,2) " +
                "         ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) " +
                " order by LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) " +
                " OFFSET (:page - 1) * :size ROWS " +
                " FETCH NEXT :size ROWS ONLY ";

        list = this.namedParameterJdbcTemplate.query(sql,map,new ProductRowMapper());

        return list;
    }


    public List<ProductDTO> findProductById(String id) {

        String sql = "" +
                    "select  " +
                    "  id " +
                    " ,nome " +
                    " ,categoria_tipo " +
                    " ,linha " +
                    " ,acabamento " +
                    " ,superficie " +
                    " ,ambiente " +
                    "from view_api_produtos " +
                    "where id = ? " +
                    "group by  id " +
                    "         ,nome " +
                    "         ,categoria_tipo " +
                    "         ,linha " +
                    "         ,acabamento " +
                    "         ,superficie " +
                    "         ,ambiente ";

        List<ProductDTO> list = jdbcTemplate.query(sql, new Object[] {id}, new ProductbYIdRowMapper());
        return list;
    }

    public List<MatizDTO> findMatizByProductId(String productId) {
        String sql = "" +
                    "SELECT  " +
                    "  SUBSTRING(a.SUBCLASSE,1,2) id_produto   " +
                    " ,LTRIM(RTRIM(MATIZ_1)) matiz  " +
                    " ,va.id id  " +
                    "FROM BCEST61 a " +
                    " INNER JOIN view_api_matiz va ON va.descricao = LTRIM(RTRIM(MATIZ_1))  " +
                    "WHERE a.SUBGRUPO = 2   " +
                    "AND ATIVO_SITE = 'S'   " +
                    "AND SUBSTRING(a.SUBCLASSE,1,2) = ?  " +
                    "GROUP BY SUBSTRING(a.SUBCLASSE,1,2), LTRIM(RTRIM(MATIZ_1)), va.id  ";

        List<MatizDTO> list = jdbcTemplate.query(sql, new Object[] {productId}, new MatizByProductIdRowMapper());
        return list;
    }

    public List<ProductTypeDTO> findProductTypeByMatiz(String matiz) {

        try {

            String sql = "" +
                    "SELECT  " +
                    " LTRIM(RTRIM(A.TIPO_PRODUTO)) tipo_produto " +
                    "FROM BCEST61 A " +
                    " LEFT JOIN CADEMB C on A.SIT = C.CODIGO " +
                    " LEFT JOIN BCEST73 E ON A.COR = E.CODIGO " +
                    " LEFT JOIN BCEST122 D ON (A.COMISSAO = D.CODIGO and 'A' = D.LETRA) " +
                    " LEFT JOIN TBL_CLASSIF_PROD B ON A.ID_CODIGO_CLASSE = B.ID_CODIGO_CLASSE " +
                    "WHERE A.SUBGRUPO = 2 " +
                    "AND ATIVO_SITE = 'S' " +
                    "AND A.TIPO_PRODUTO <> '' " +
                    "AND A.MATIZ_1 COLLATE sql_latin1_general_cp1251_ci_as = UPPER(?) " +
                    "GROUP BY A.TIPO_PRODUTO " +
                    "ORDER BY A.TIPO_PRODUTO";

            List<ProductTypeDTO> list = jdbcTemplate.query(sql, new Object[] {matiz}, new ProductTypeRowMapper());
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductTypeDTO> findProductTypeByHexacode(String hexacode) {

        try {

            String sql = "" +
                    "SELECT  " +
                    " LTRIM(RTRIM(A.TIPO_PRODUTO)) tipo_produto " +
                    "FROM BCEST61 A " +
                    " LEFT JOIN CADEMB C on A.SIT = C.CODIGO " +
                    " LEFT JOIN BCEST73 E ON A.COR = E.CODIGO " +
                    " LEFT JOIN BCEST122 D ON (A.COMISSAO = D.CODIGO and 'A' = D.LETRA) " +
                    " LEFT JOIN TBL_CLASSIF_PROD B ON A.ID_CODIGO_CLASSE = B.ID_CODIGO_CLASSE " +
                    "WHERE A.SUBGRUPO = 2 " +
                    "AND ATIVO_SITE = 'S' " +
                    "AND A.TIPO_PRODUTO <> '' " +
                    "AND LTRIM(RTRIM(A.COD_RGB_PROD)) = UPPER(?)  " +
                    "GROUP BY A.TIPO_PRODUTO " +
                    "ORDER BY A.TIPO_PRODUTO";

            List<ProductTypeDTO> list = jdbcTemplate.query(sql, new Object[] {hexacode}, new ProductTypeRowMapper());
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<ProductIdAndNameDTO> findProductByMatizAndType(String matiz, String type) {
        try {

            String sql = "" +
                    "    SELECT " +
                    "       SUBSTRING(A.SUBCLASSE,1,2) AS 'id' " +
                    "       ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) AS 'nome' " +
                    "    FROM BCEST61 A " +
                    "    LEFT JOIN CADEMB C on A.SIT = C.CODIGO " +
                    "    LEFT JOIN BCEST73 E ON A.COR = E.CODIGO " +
                    "    LEFT JOIN BCEST122 D ON (A.COMISSAO = D.CODIGO and 'A' = D.LETRA) " +
                    "    LEFT JOIN TBL_CLASSIF_PROD B ON A.ID_CODIGO_CLASSE = B.ID_CODIGO_CLASSE " +
                    "    WHERE A.SUBGRUPO = 2 " +
                    "    AND ATIVO_SITE = 'S' " +
                    "    AND A.TIPO_PRODUTO <> '' " +
                    "    AND A.MATIZ_1 COLLATE sql_latin1_general_cp1251_ci_as = UPPER(?) " +
                    "    AND A.TIPO_PRODUTO = UPPER(?) " +
                    "    GROUP BY SUBSTRING(A.SUBCLASSE,1,2) " +
                    "            ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) " +
                    "    ORDER BY SUBSTRING(A.SUBCLASSE,1,2) " +
                    "            ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) ";

            List<ProductIdAndNameDTO> list = jdbcTemplate.query(sql, new Object[] {matiz, type}, new ProductIdAndNameRowMapper());
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductIdAndNameDTO> findProductByHexacodeAndType(String hexacode, String type) {
        try {

            String sql = "" +
                    "    SELECT " +
                    "       SUBSTRING(A.SUBCLASSE,1,2) AS 'id' " +
                    "       ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) AS 'nome' " +
                    "    FROM BCEST61 A " +
                    "    LEFT JOIN CADEMB C on A.SIT = C.CODIGO " +
                    "    LEFT JOIN BCEST73 E ON A.COR = E.CODIGO " +
                    "    LEFT JOIN BCEST122 D ON (A.COMISSAO = D.CODIGO and 'A' = D.LETRA) " +
                    "    LEFT JOIN TBL_CLASSIF_PROD B ON A.ID_CODIGO_CLASSE = B.ID_CODIGO_CLASSE " +
                    "    WHERE A.SUBGRUPO = 2 " +
                    "    AND ATIVO_SITE = 'S' " +
                    "    AND A.TIPO_PRODUTO <> '' " +
                    "    AND LTRIM(RTRIM(A.COD_RGB_PROD)) = UPPER(?)  " +
                    "    AND A.TIPO_PRODUTO = UPPER(?) " +
                    "    GROUP BY SUBSTRING(A.SUBCLASSE,1,2) " +
                    "            ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) " +
                    "    ORDER BY SUBSTRING(A.SUBCLASSE,1,2) " +
                    "            ,LTRIM(RTRIM(B.DESCRICAO_COMERCIAL)) ";

            List<ProductIdAndNameDTO> list = jdbcTemplate.query(sql, new Object[] {hexacode, type}, new ProductIdAndNameRowMapper());
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
