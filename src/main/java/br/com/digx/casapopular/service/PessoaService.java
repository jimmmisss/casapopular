package br.com.digx.casapopular.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.digx.casapopular.dto.PessoaDto;
import br.com.digx.casapopular.entity.Pessoa;
import br.com.digx.casapopular.exception.ObjectNotFoundException;
import br.com.digx.casapopular.mapper.Mappable;
import br.com.digx.casapopular.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PessoaService implements Mappable {

  private final PessoaRepository pessoaRepository;
  private final ModelMapper mapper;

  public PessoaService(PessoaRepository pessoaRepository, ModelMapper mapper) {
    this.pessoaRepository = pessoaRepository;
    this.mapper = mapper;
  }

  public PessoaDto findById(Long id) {
    Optional<Pessoa> pessoa = pessoaRepository.findById(id);
    Pessoa p = pessoa.orElseThrow(() -> new ObjectNotFoundException("Nenhuma pessoa encontrada: " + id));
    return map(p, PessoaDto.class);
  }

  public List<PessoaDto> listar() {
    List<Pessoa> pessoa = pessoaRepository.findAll();
    return pessoa.stream().map(m -> map(m, PessoaDto.class)).collect(Collectors.toList());
  }

  public void salvar(PessoaDto pessoaDto) {
    Pessoa pessoa = map(pessoaDto, Pessoa.class);
    pessoaRepository.save(pessoa);
  }

  public void atualizar(PessoaDto pessoaDto, Long id) {
    Optional<Pessoa> pessoa = pessoaRepository.findById(id);
    if (pessoa.isPresent()) {
      pessoaDto.setId(id);
      pessoaRepository.save(map(pessoaDto, Pessoa.class));
    }
  }

  public void deletar(Long id) {
    pessoaRepository.deleteById(id);
  }

  @Override
  public ModelMapper mapper() {
    return this.mapper;
  }

}
