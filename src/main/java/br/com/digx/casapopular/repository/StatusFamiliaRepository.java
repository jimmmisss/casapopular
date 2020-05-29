package br.com.digx.casapopular.repository;

import br.com.digx.casapopular.entity.StatusFamilia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusFamiliaRepository extends JpaRepository<StatusFamilia, Long> {
}
