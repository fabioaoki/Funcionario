package br.com.education.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SetorDto implements Serializable{

	private static final long serialVersionUID = -8506770629673247689L;

	private Long id;
	private Long idFuncionario;
	private String nomeSetor;
}
