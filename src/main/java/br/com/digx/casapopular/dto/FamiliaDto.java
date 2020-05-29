package br.com.digx.casapopular.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FamiliaDto implements Serializable {

    private final static long serialVersionUID = -7851688577755959917L;

    private Long id;
    private Integer pontuacao;
    private List<PessoaDto> pessoas;
    private StatusFamiliaDto status;

}
