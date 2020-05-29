package br.com.digx.casapopular.service.analise.quantidadepretendente;

import br.com.digx.casapopular.entity.Familia;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.TRES;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.UM;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.ZERO;
import static br.com.digx.casapopular.service.analise.quantidadepretendente.QuantidadeDependentes.quantidadeDependentes;

public class QuantidadeDependentesRegraDois implements IQuantidadeDependente {

  @Override
  public Boolean pontosPorQuantidadeDependente(Familia familia) {
    Integer quantidadeDependentes = quantidadeDependentes(familia);
    return quantidadeDependentes > ZERO && quantidadeDependentes < TRES;
  }

  @Override
  public Integer aplicarRegra(Familia familia) {
    return UM;
  }

}
