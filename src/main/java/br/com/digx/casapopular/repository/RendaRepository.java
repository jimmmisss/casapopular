package br.com.digx.casapopular.repository;

import br.com.digx.casapopular.entity.Pessoa;
import br.com.digx.casapopular.entity.Renda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendaRepository extends JpaRepository<Renda, Long> {

  Renda findByPessoa(Pessoa id);
}
