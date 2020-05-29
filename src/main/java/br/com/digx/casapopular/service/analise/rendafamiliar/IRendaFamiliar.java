package br.com.digx.casapopular.service.analise.rendafamiliar;

import br.com.digx.casapopular.entity.Familia;

public interface IRendaFamiliar {

    Boolean pontosPorRendaFamiliar(Familia familia);
    Integer aplicarRegra(Familia familia);

}
