package br.com.digx.casapopular.service.analise.idadepretendente;

import br.com.digx.casapopular.entity.Familia;
import br.com.digx.casapopular.entity.Pessoa;

import static br.com.digx.casapopular.entity.enumeration.Tipo.PRETENDENTE;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.QUARENTA_E_CINCO;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.TRES;
import static br.com.digx.casapopular.service.analise.idadepretendente.Idade.getIdade;

public class IdadePretendenteRegraUm implements IIdadePretendente {

  @Override
  public Boolean pontosPorIdadePretendente(Familia familia) {
    Boolean valor = null;
    for (Pessoa pessoa : familia.getPessoas()) {
      if (pessoa.getTipo() == PRETENDENTE) {
        valor = (getIdade(pessoa) >= QUARENTA_E_CINCO);
      }
    }
    return valor;
  }

  @Override
  public Integer aplicarRegra(Familia familia) {
    return TRES;
  }

}
