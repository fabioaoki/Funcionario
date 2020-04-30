package br.com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.education.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findById(long id);

}
