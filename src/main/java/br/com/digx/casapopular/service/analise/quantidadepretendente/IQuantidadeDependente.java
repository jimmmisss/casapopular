package br.com.digx.casapopular.service.analise.quantidadepretendente;

import br.com.digx.casapopular.entity.Familia;

public interface IQuantidadeDependente {

  Boolean pontosPorQuantidadeDependente(Familia familia);

  Integer aplicarRegra(Familia familia);

}
