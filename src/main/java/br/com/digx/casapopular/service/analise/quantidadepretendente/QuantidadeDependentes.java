package br.com.digx.casapopular.service.analise.quantidadepretendente;

import br.com.digx.casapopular.entity.Familia;
import br.com.digx.casapopular.entity.Pessoa;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.IDADE_DEPENDENTES;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.ZERO;
import static br.com.digx.casapopular.service.analise.idadepretendente.Idade.getIdade;

public abstract class QuantidadeDependentes {

  private QuantidadeDependentes() {
    super();
  }

  public static Integer quantidadeDependentes(Familia familia) {
    int quantidadeDependentes = ZERO;

    for (Pessoa pessoa : familia.getPessoas()) {
      if (getIdade(pessoa) <= IDADE_DEPENDENTES) {
        quantidadeDependentes++;
      }
    }
    return quantidadeDependentes;
  }

}
