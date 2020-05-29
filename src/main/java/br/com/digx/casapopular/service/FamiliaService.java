package br.com.digx.casapopular.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.digx.casapopular.dto.FamiliaDto;
import br.com.digx.casapopular.entity.Familia;
import br.com.digx.casapopular.mapper.Mappable;
import br.com.digx.casapopular.repository.FamiliaRepository;
import br.com.digx.casapopular.service.analise.Analise;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FamiliaService implements Mappable {

    private final FamiliaRepository familiaRepository;
    private final Analise analise;
    private final ModelMapper mapper;

    public FamiliaService(FamiliaRepository familiaRepository, Analise analise, ModelMapper mapper) {
        this.familiaRepository = familiaRepository;
        this.analise = analise;
        this.mapper = mapper;
    }

    public List<FamiliaDto> listar() {
        List<Familia> familia = familiaRepository.findByOrderByPontuacaoDesc();
        return familia.stream().map(m -> map(m, FamiliaDto.class)).collect(Collectors.toList());
    }

    public void salvar(FamiliaDto familiaDto) {
        Familia familia = map(familiaDto, Familia.class);
        familiaRepository.save(analise.resultado(familia));
    }

    public void atualizar(FamiliaDto familiaDto, Long id) {
        Optional<Familia> familia = familiaRepository.findById(id);
        if (familia.isPresent()) {
            familiaDto.setId(id);
            familiaRepository.save(map(familiaDto, Familia.class));
        }
    }

    public void deletar(Long id) {
        familiaRepository.deleteById(id);
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }

}
