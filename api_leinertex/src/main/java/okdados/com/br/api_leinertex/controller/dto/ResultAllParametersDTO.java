package okdados.com.br.api_leinertex.controller.dto;

import okdados.com.br.api_leinertex.entity.*;

import java.util.List;

public class ResultAllParametersDTO {

    private List<MatizEntity> matiz;
    private List<SurfaceEntity> superficie;
    private List<ProductTypeEntity> tipoProduto;
    private List<LineEntity> linha;
    private List<AmbienceEntity> ambiente;
    private List<FinishingEntity> acabamento;


    public List<MatizEntity> getMatiz() {
        return matiz;
    }

    public void setMatiz(List<MatizEntity> matiz) {
        this.matiz = matiz;
    }

    public List<SurfaceEntity> getSuperficie() {
        return superficie;
    }

    public void setSuperficie(List<SurfaceEntity> superficie) {
        this.superficie = superficie;
    }

    public List<ProductTypeEntity> getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(List<ProductTypeEntity> tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public List<LineEntity> getLinha() {
        return linha;
    }

    public void setLinha(List<LineEntity> linha) {
        this.linha = linha;
    }

    public List<AmbienceEntity> getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(List<AmbienceEntity> ambiente) {
        this.ambiente = ambiente;
    }

    public List<FinishingEntity> getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(List<FinishingEntity> acabamento) {
        this.acabamento = acabamento;
    }
}
