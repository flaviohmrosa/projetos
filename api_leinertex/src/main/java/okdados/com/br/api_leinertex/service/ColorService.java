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


}
