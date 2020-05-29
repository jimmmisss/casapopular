package br.com.digx.casapopular.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import br.com.digx.casapopular.entity.enumeration.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PessoaDto implements Serializable {

    private final static long serialVersionUID = -7851688577755959917L;

    private Long id;
    private String nome;
    private Tipo tipo;
    private Date nascimento;
    private RendaDto renda;
    private FamiliaDto familia;

}
