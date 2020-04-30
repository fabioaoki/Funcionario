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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Table(name="setor")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Setor implements Serializable {
	
	private static final long serialVersionUID = -2984928128348888112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
//	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "funcionario_id")
	@Column(name = "id_funcionario")
	private Long idFuncionario;
	
	@Column(name = "nome_setor")
	private String nomeSetor;

}
