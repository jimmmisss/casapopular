package br.com.digx.casapopular.service.analise.rendafamiliar;

import java.util.List;

import br.com.digx.casapopular.entity.Familia;
import br.com.digx.casapopular.entity.Pessoa;
import br.com.digx.casapopular.service.RendaService;
import org.springframework.beans.factory.annotation.Autowired;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.VALOR_INICIAL;

public abstract class RendaFamiliar {

  private final RendaService rendaService;

  @Autowired
  private RendaFamiliar(RendaService rendaService) {
    super();
    this.rendaService = rendaService;
  }

  public static Double rendaFamiliar(Familia familia) {
    Double valor = VALOR_INICIAL;

    List<Pessoa> pessoas = familia.getPessoas();
    for (Pessoa pessoa : pessoas) {
      valor += pessoa.getRenda().getValor();

    }
    return valor;
  }

}
