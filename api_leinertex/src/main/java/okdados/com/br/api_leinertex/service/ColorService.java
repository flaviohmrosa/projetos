package okdados.com.br.api_leinertex.service;


import okdados.com.br.api_leinertex.dto.ColorByMatizDTO;
import okdados.com.br.api_leinertex.dto.ProductTypeDTO;
import okdados.com.br.api_leinertex.repository.ColorDinamicRepository;
import okdados.com.br.api_leinertex.repository.ProductDinamicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ColorService {

    @Autowired
    ColorDinamicRepository colorDinamicRepository;
    @Autowired
    ProductDinamicRepository productDinamicRepository;

    public List<ColorByMatizDTO> findColorByMatiz(String matiz) {
        List<ColorByMatizDTO> color = new ArrayList<>();

        color = colorDinamicRepository.findColorByMatiz(matiz);

        for(ColorByMatizDTO colorByMatizDTO : color )
        {
            colorByMatizDTO.setProdutos(productDinamicRepository.findProductTypeByMatiz(matiz));
            for(ProductTypeDTO productTypeDTO : colorByMatizDTO.getProdutos()) {
                productTypeDTO.setProdutos(productDinamicRepository.findProductByMatizAndType(matiz, productTypeDTO.getTipoProduto()));
            }
        }

        return color;
    }


    public List<ColorByMatizDTO> findColorByHexacode(String hexacode) {
        List<ColorByMatizDTO> color = new ArrayList<>();
        hexacode = hexacode.replace("#", "");

        try{
            Integer r = Integer.valueOf(hexacode.substring(0, 2), 16);
            Integer g = Integer.valueOf(hexacode.substring(2, 4), 16);
            Integer b = Integer.valueOf(hexacode.substring(4, 6), 16);

            hexacode = "" + r + g + b;

            color = colorDinamicRepository.findColorByHexacode(hexacode);

            for(ColorByMatizDTO colorByMatizDTO : color )
            {
                colorByMatizDTO.setProdutos(productDinamicRepository.findProductTypeByHexacode(hexacode));
                for(ProductTypeDTO productTypeDTO : colorByMatizDTO.getProdutos()) {
                    productTypeDTO.setProdutos(productDinamicRepository.findProductByHexacodeAndType(hexacode, productTypeDTO.getTipoProduto()));
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return color;
    }

}
