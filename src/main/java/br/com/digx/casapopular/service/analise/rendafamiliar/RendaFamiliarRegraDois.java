package br.com.digx.casapopular.service.analise.rendafamiliar;

import br.com.digx.casapopular.entity.Familia;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.MIL_E_QUINHENTOS;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.NOVECENTOS_E_UM;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.TRES;
import static br.com.digx.casapopular.service.analise.rendafamiliar.RendaFamiliar.rendaFamiliar;

public class RendaFamiliarRegraDois implements IRendaFamiliar {

    @Override
    public Boolean pontosPorRendaFamiliar(Familia familia) {
        Double rendaFamiliar = rendaFamiliar(familia);
        return rendaFamiliar >= NOVECENTOS_E_UM && rendaFamiliar <= MIL_E_QUINHENTOS;
    }

    @Override
    public Integer aplicarRegra(Familia familia) {
        return TRES;
    }

}
