package br.com.education.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagamentoDto implements Serializable{
	
	private static final long serialVersionUID = 257686378522816581L;
	
	private Long id;
	private Long idFuncionario;
	private double valor;
	private String nomeFuncionario;
	private String nomeSetor;

}
