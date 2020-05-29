package br.com.digx.casapopular.service.analise.quantidadepretendente;

import br.com.digx.casapopular.entity.Familia;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.DOIS;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.TRES;
import static br.com.digx.casapopular.service.analise.quantidadepretendente.QuantidadeDependentes.quantidadeDependentes;

public class QuantidadeDependentesRegraUm implements IQuantidadeDependente {

  @Override
  public Boolean pontosPorQuantidadeDependente(Familia familia) {
    return quantidadeDependentes(familia) >= TRES;
  }

  @Override
  public Integer aplicarRegra(Familia familia) {
    return DOIS;
  }

}
