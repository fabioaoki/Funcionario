package br.com.education.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "pagamento")
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento implements Serializable {

	private static final long serialVersionUID = -2944804404741958508L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_funcionario")
	private Long idFuncioario;
	
	@Column(name = "valor")
	private double valor;
	
	@Column(name = "nome_funcionario")
	private String nomeFuncionario;
	
	@Column(name = "nome_setor")
	private String nomeSetor;
}
