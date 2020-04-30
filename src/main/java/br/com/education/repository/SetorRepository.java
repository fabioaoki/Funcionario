package br.com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.education.entity.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long>{

	Setor findById(long id);
}
