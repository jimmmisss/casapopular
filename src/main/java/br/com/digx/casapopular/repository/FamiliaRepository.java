package br.com.digx.casapopular.repository;

import java.util.List;

import br.com.digx.casapopular.entity.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

  List<Familia> findByOrderByPontuacaoDesc();
}
