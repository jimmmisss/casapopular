package br.com.digx.casapopular.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Familia implements Serializable {

    private final static long serialVersionUID = -7851688577755959917L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer pontuacao;

    @OneToMany(mappedBy = "familia", cascade = CascadeType.MERGE)
    private List<Pessoa> pessoas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "familia")
    private StatusFamilia status;

}
