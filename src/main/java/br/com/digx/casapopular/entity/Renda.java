package br.com.digx.casapopular.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Renda implements Serializable {

  private final static long serialVersionUID = -7851688577755959917L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Double valor;

  @OneToOne
  @JoinColumn(name = "pessoa")
  private Pessoa pessoa;
}
