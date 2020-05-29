package br.com.digx.casapopular.service.analise;

import java.util.Arrays;
import java.util.List;

import br.com.digx.casapopular.dto.PessoaDto;
import br.com.digx.casapopular.dto.RendaDto;
import br.com.digx.casapopular.dto.StatusFamiliaDto;
import br.com.digx.casapopular.entity.Familia;
import br.com.digx.casapopular.entity.Pessoa;
import br.com.digx.casapopular.entity.Renda;
import br.com.digx.casapopular.exception.ObjectWithStatusInvalid;
import br.com.digx.casapopular.mapper.Mappable;
import br.com.digx.casapopular.service.PessoaService;
import br.com.digx.casapopular.service.RendaService;
import br.com.digx.casapopular.service.StatusFamiliaService;
import br.com.digx.casapopular.service.analise.idadepretendente.IIdadePretendente;
import br.com.digx.casapopular.service.analise.idadepretendente.IdadePretendenteRegraDois;
import br.com.digx.casapopular.service.analise.idadepretendente.IdadePretendenteRegraTres;
import br.com.digx.casapopular.service.analise.idadepretendente.IdadePretendenteRegraUm;
import br.com.digx.casapopular.service.analise.quantidadepretendente.IQuantidadeDependente;
import br.com.digx.casapopular.service.analise.quantidadepretendente.QuantidadeDependentesRegraDois;
import br.com.digx.casapopular.service.analise.quantidadepretendente.QuantidadeDependentesRegraUm;
import br.com.digx.casapopular.service.analise.rendafamiliar.IRendaFamiliar;
import br.com.digx.casapopular.service.analise.rendafamiliar.RendaFamiliarRegraDois;
import br.com.digx.casapopular.service.analise.rendafamiliar.RendaFamiliarRegraTres;
import br.com.digx.casapopular.service.analise.rendafamiliar.RendaFamiliarRegraUm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.digx.casapopular.service.analise.constantes.Constantes.ZERO;

@Service
public class Analise implements Mappable {

    private final PessoaService pessoaService;
    private final RendaService rendaService;
    private final StatusFamiliaService statusFamiliaService;
    private final ModelMapper mapper;

    static List<IRendaFamiliar> rendaPorFamilia = Arrays.asList(
        new RendaFamiliarRegraUm(), new RendaFamiliarRegraDois(), new RendaFamiliarRegraTres());

    static List<IIdadePretendente> idadePretendentes = Arrays.asList(
        new IdadePretendenteRegraUm(), new IdadePretendenteRegraDois(), new IdadePretendenteRegraTres());

    static List<IQuantidadeDependente> quantidadeDependentes = Arrays.asList(
        new QuantidadeDependentesRegraUm(), new QuantidadeDependentesRegraDois());

    @Autowired
    public Analise(PessoaService pessoaService, RendaService rendaService,
        StatusFamiliaService statusFamiliaService, ModelMapper mapper) {
        this.pessoaService = pessoaService;
        this.rendaService = rendaService;
        this.statusFamiliaService = statusFamiliaService;
        this.mapper = mapper;
    }

    private Integer totalPontosPorRendaFamiliar(Familia familia) {
        int pontos = ZERO;
        for (IRendaFamiliar renda : rendaPorFamilia) {
            setRendaPessoa(familia);
            if (renda.pontosPorRendaFamiliar(familia)) {
                pontos = renda.aplicarRegra(familia);
                break;
            }
        }
        return pontos;
    }

    private Familia setRendaPessoa(Familia familia) {
        for (Pessoa pessoa : familia.getPessoas()) {
            RendaDto rendaPorPessoa = rendaService.findByPessoa(pessoa);
            pessoa.setRenda(map(rendaPorPessoa, Renda.class));
        }
        return familia;
    }

    private Integer totalPontosPorIdadePretendente(Familia familia) {
        int pontos = ZERO;
        setIdadePessoa(familia);
        for (IIdadePretendente idadePretendente : idadePretendentes) {
            if (idadePretendente.pontosPorIdadePretendente(familia)) {
                pontos = idadePretendente.aplicarRegra(familia);
                break;
            }
        }
        return pontos;
    }

    private Familia setIdadePessoa(Familia familia) {
        for (Pessoa pessoa : familia.getPessoas()) {
            PessoaDto pessoaDto = pessoaService.findById(pessoa.getId());
            Pessoa map = map(pessoaDto, Pessoa.class);
            pessoa.setNascimento(map.getNascimento());
            pessoa.setTipo(map.getTipo());
        }
        return familia;
    }

    private Integer totalPontosPorQuantidadeDependente(Familia familia) {
        int pontos = ZERO;
        for (IQuantidadeDependente quantidadeDependente : quantidadeDependentes) {
            if (quantidadeDependente.pontosPorQuantidadeDependente(familia)) {
                pontos = quantidadeDependente.aplicarRegra(familia);
                break;
            }
        }
        return pontos;
    }

    public Familia resultado(Familia familia) {
        getVerificaStatusFamilia(familia);
        Integer pontosPorRendaFamiliar = totalPontosPorRendaFamiliar(familia);
        Integer pontosPorIdadePretendente = totalPontosPorIdadePretendente(familia);
        Integer pontosPorQuantidadeDependente = totalPontosPorQuantidadeDependente(familia);
        familia.setPontuacao(pontosPorRendaFamiliar + pontosPorIdadePretendente + pontosPorQuantidadeDependente);
        return familia;
    }

    private void getVerificaStatusFamilia(Familia familia) {
        StatusFamiliaDto id = statusFamiliaService.findById(familia.getStatus().getId());
        if (!id.getTipo().equalsIgnoreCase("0")) {
            throw new ObjectWithStatusInvalid("Status da família precisa ser válido");
        }
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }
}