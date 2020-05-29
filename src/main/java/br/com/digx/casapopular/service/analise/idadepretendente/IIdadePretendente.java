package br.com.digx.casapopular.service.analise.idadepretendente;

import br.com.digx.casapopular.entity.Familia;

public interface IIdadePretendente {

  Boolean pontosPorIdadePretendente(Familia familia);

  Integer aplicarRegra(Familia familia);
}
