package br.com.digx.casapopular.service.analise.rendafamiliar;

import br.com.digx.casapopular.entity.Familia;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.DOIS_MIL;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.MIL_QUINHENTOS_E_UM;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.UM;
import static br.com.digx.casapopular.service.analise.rendafamiliar.RendaFamiliar.rendaFamiliar;

public class RendaFamiliarRegraTres implements IRendaFamiliar {

    @Override
    public Boolean pontosPorRendaFamiliar(Familia familia) {
        Double rendaFamiliar = rendaFamiliar(familia);
        return rendaFamiliar >= MIL_QUINHENTOS_E_UM && rendaFamiliar <= DOIS_MIL;
    }

    @Override
    public Integer aplicarRegra(Familia familia) {
        return UM;
    }

}
