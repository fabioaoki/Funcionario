package br.com.education.dto;

import java.io.Serializable;

import br.com.education.entity.Funcionario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetorDto implements Serializable{

	private static final long serialVersionUID = -8506770629673247689L;

	private Long id;
	private Funcionario funcionario;
	private String nomeSetor;
}
