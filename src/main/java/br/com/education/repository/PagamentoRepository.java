package br.com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.education.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	
	Pagamento findById (long id);

}
