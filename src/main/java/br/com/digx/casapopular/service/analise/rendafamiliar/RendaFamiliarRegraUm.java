package br.com.digx.casapopular.service.analise.rendafamiliar;

import br.com.digx.casapopular.entity.Familia;
import br.com.digx.casapopular.entity.Pessoa;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.CINCO;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.NOVECENTOS;
import static br.com.digx.casapopular.service.analise.rendafamiliar.RendaFamiliar.rendaFamiliar;

public class RendaFamiliarRegraUm implements IRendaFamiliar {

  @Override
  public Boolean pontosPorRendaFamiliar(Familia familia) {
    for (Pessoa pessoa : familia.getPessoas()) {
      Double valor = pessoa.getRenda().getValor();
    }

    return rendaFamiliar(familia) <= NOVECENTOS;
  }

  @Override
  public Integer aplicarRegra(Familia familia) {
    return CINCO;
  }

}
