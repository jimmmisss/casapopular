package br.com.digx.casapopular.entity;

import java.io.Serializable;
import java.util.Date;

import br.com.digx.casapopular.entity.enumeration.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pessoa implements Serializable {

  private final static long serialVersionUID = -7851688577755959917L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nome;
  @Enumerated(EnumType.STRING)
  private Tipo tipo;
  private Date nascimento;

  @OneToOne
  private Renda renda;

  @ManyToOne
  @JoinColumn(name = "familia")
  private Familia familia;

}
