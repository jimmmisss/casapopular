package br.com.digx.casapopular.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.digx.casapopular.dto.PessoaDto;
import br.com.digx.casapopular.dto.StatusFamiliaDto;
import br.com.digx.casapopular.entity.Pessoa;
import br.com.digx.casapopular.entity.StatusFamilia;
import br.com.digx.casapopular.exception.ObjectNotFoundException;
import br.com.digx.casapopular.mapper.Mappable;
import br.com.digx.casapopular.repository.StatusFamiliaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StatusFamiliaService implements Mappable {

  private final StatusFamiliaRepository statusFamiliaRepository;
  private final ModelMapper mapper;

  public StatusFamiliaService(StatusFamiliaRepository statusFamiliaRepository, ModelMapper mapper) {
    this.statusFamiliaRepository = statusFamiliaRepository;
    this.mapper = mapper;
  }

  public StatusFamiliaDto findById(Long id) {
    Optional<StatusFamilia> statusFamilia = statusFamiliaRepository.findById(id);
    StatusFamilia p =
        statusFamilia.orElseThrow(() -> new ObjectNotFoundException("Nenhum StatusFamilia encontrado: " + id));
    return map(p, StatusFamiliaDto.class);
  }

  public List<StatusFamiliaDto> listar() {
    List<StatusFamilia> statusFamilia = statusFamiliaRepository.findAll();
    return statusFamilia.stream().map(m -> map(m, StatusFamiliaDto.class)).collect(Collectors.toList());
  }

  public void salvar(StatusFamiliaDto statusFamiliaDto) {
    StatusFamilia statusFamilia = map(statusFamiliaDto, StatusFamilia.class);
    statusFamiliaRepository.save(statusFamilia);
  }

  public void atualizar(StatusFamiliaDto statusFamiliaDto, Long id) {
    Optional<StatusFamilia> statusFamilia = statusFamiliaRepository.findById(id);
    if (statusFamilia.isPresent()) {
      statusFamiliaDto.setId(id);
      statusFamiliaRepository.save(map(statusFamiliaDto, StatusFamilia.class));
    }
  }

  public void deletar(Long id) {
    statusFamiliaRepository.deleteById(id);
  }

  @Override
  public ModelMapper mapper() {
    return this.mapper;
  }

}
