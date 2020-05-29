package br.com.digx.casapopular.service.analise.idadepretendente;

import br.com.digx.casapopular.entity.Familia;
import br.com.digx.casapopular.entity.Pessoa;

import static br.com.digx.casapopular.entity.enumeration.Tipo.PRETENDENTE;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.DOIS;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.QUARENTA_E_QUATRO;
import static br.com.digx.casapopular.service.analise.constantes.Constantes.TRINTA;
import static br.com.digx.casapopular.service.analise.idadepretendente.Idade.getIdade;

public class IdadePretendenteRegraDois implements IIdadePretendente {

    @Override
    public Boolean pontosPorIdadePretendente(Familia familia) {
        Boolean valor = null;
        for (Pessoa pessoa : familia.getPessoas()) {
            if (pessoa.getTipo() == PRETENDENTE) {
                Integer idade = getIdade(pessoa);
                valor =  idade >= TRINTA && idade <= QUARENTA_E_QUATRO;
            }
        }
        return valor;
    }

    @Override
    public Integer aplicarRegra(Familia familia) {
        return DOIS;
    }

}
