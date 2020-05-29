package br.com.digx.casapopular.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatusFamiliaDto implements Serializable {

    private final static long serialVersionUID = -7851688577755959917L;

    private Long id;
    private String tipo;
    private String status;

    @JsonIgnore
    private List<FamiliaDto> familias;

}
