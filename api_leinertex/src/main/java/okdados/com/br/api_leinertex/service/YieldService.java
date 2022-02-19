package okdados.com.br.api_leinertex.service;


import okdados.com.br.api_leinertex.entity.YieldEntity;
import okdados.com.br.api_leinertex.repository.YieldDinamicRepository;
import okdados.com.br.api_leinertex.repository.YieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YieldService {

        @Autowired
        YieldRepository yieldRepository;
        @Autowired
        YieldDinamicRepository yieldDinamicRepository;


        public List<YieldEntity> findAll() {
            return yieldRepository.findAll();
        }

        public List<YieldEntity> findByCode(String code) {
            return yieldDinamicRepository.findByCode(code);
        }


}
