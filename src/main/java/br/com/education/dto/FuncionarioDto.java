package br.com.education.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FuncionarioDto implements Serializable {

	private static final long serialVersionUID = -6687725854022178875L;
	
	private Long id;
	
	@NotEmpty(message = "nome nao poder ser vazio")
	private String nome;
	@NotEmpty(message = "sexo nao poder ser vazio")
	private String sexo;
	@NotEmpty(message = "nascimento nao poder ser vazio")
	private String nascimento;
	@NotEmpty(message = "salario nao poder ser vazio")
	private String salario;
	
}
