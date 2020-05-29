package br.com.digx.casapopular.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.digx.casapopular.dto.RendaDto;
import br.com.digx.casapopular.entity.Pessoa;
import br.com.digx.casapopular.entity.Renda;
import br.com.digx.casapopular.exception.ObjectNotFoundException;
import br.com.digx.casapopular.mapper.Mappable;
import br.com.digx.casapopular.repository.RendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class RendaService implements Mappable {

    private final RendaRepository rendaRepository;
    private final ModelMapper mapper;

    public RendaService(RendaRepository rendaRepository, ModelMapper mapper) {
        this.rendaRepository = rendaRepository;
        this.mapper = mapper;
    }

    public RendaDto findByPessoa(Pessoa pessoa) {
        Renda rendaRecuperada = rendaRepository.findByPessoa(pessoa);
        if (isNull(rendaRecuperada)) {
            throw new ObjectNotFoundException("Nenhuma renda encontrada: " + Renda.class);
        }
        return map(rendaRecuperada, RendaDto.class);
    }

    public List<RendaDto> listar() {
        List<Renda> renda = rendaRepository.findAll();
        return renda.stream().map(m -> map(m, RendaDto.class)).collect(Collectors.toList());
    }

    public void salvar(RendaDto rendaDto) {
        Renda renda = map(rendaDto, Renda.class);
        rendaRepository.save(renda);
    }

    public void atualizar(RendaDto rendaDto, Long id) {
        Optional<Renda> renda = rendaRepository.findById(id);
        if (renda.isPresent()) {
            rendaDto.setId(id);
            rendaRepository.save(map(rendaDto, Renda.class));
        }
    }

    public void deletar(Long id) {
        rendaRepository.deleteById(id);
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }

}
