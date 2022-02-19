package okdados.com.br.api_leinertex.service;

import okdados.com.br.api_leinertex.controller.dto.ResultAllParametersDTO;
import okdados.com.br.api_leinertex.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    @Autowired
    MatizRepository matizRepository;
    @Autowired
    SurfaceRepository surfaceRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    LineRepository lineRepository;
    @Autowired
    AmbienceRepository ambienceRepository;
    @Autowired
    FinishingRepository finishingRepository;

    public ResultAllParametersDTO findResult(){
        ResultAllParametersDTO resultDTO = new ResultAllParametersDTO();

        resultDTO.setMatiz(matizRepository.findAll());
        resultDTO.setSuperficie(surfaceRepository.findAll());
        resultDTO.setTipoProduto(productTypeRepository.findAll());
        resultDTO.setLinha(lineRepository.findAll());
        resultDTO.setAmbiente(ambienceRepository.findAll());
        resultDTO.setAcabamento(finishingRepository.findAll());

        return resultDTO;
    }

}
