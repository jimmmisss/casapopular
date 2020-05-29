package br.com.digx.casapopular.service.analise.idadepretendente;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import br.com.digx.casapopular.entity.Pessoa;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.ZERO;

public abstract class Idade {

    private Idade() {
        super();
    }

    public static Integer getIdade(Pessoa pessoa) {
        int idade = ZERO;
        LocalDate dataHoje = LocalDate.now();
        if (pessoa.getNascimento() != null) {
            LocalDate dtNacimento = ZonedDateTime.ofInstant(pessoa.getNascimento().toInstant(),
                    ZoneId.of("America/Sao_Paulo")).toLocalDate();
            Period dif = dtNacimento.until(dataHoje);
            idade = dif.getYears();
        }
        return idade;
    }

}
