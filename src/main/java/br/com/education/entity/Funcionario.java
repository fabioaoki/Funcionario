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
@Table(name="funcionario")
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario implements Serializable {
		
	private static final long serialVersionUID = 6496879288393478176L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "sexo", nullable = false)
	private String sexo;
	
	@Column(name = "nascimento")
	private String nascimento;

	@Column(name = "salario")
	private String salario;

}
