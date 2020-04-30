package br.com.education.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.education.dto.FuncionarioDto;
import br.com.education.entity.Funcionario;
import br.com.education.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	public FuncionarioDto save(@Valid FuncionarioDto funcionarioDto) {
		Funcionario funcionario = Funcionario.builder().id(funcionarioDto.getId()).nome(funcionarioDto.getNome()).sexo(funcionarioDto.getSexo()).nascimento(funcionarioDto.getNascimento()).build();
		funcionarioRepository.save(funcionario);
		return funcionarioDto;
	}
	
	public FuncionarioDto getById (long id) {
		Funcionario funcionario = funcionarioRepository.findById(id);
		return FuncionarioDto.builder().id(funcionario.getId()).nome(funcionario.getNome()).nascimento(funcionario.getNascimento()).sexo(funcionario.getSexo()).build();
	}
	
	public void delete(long id) {
		funcionarioRepository.deleteById(id);
	}
	
	public List<FuncionarioDto> getAll() {
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		List<FuncionarioDto> funcionarioDto = new ArrayList<>();
		
		for (Funcionario funcionario : funcionarios) {
			funcionarioDto.add(FuncionarioDto.builder().id(funcionario.getId())
					.nome(funcionario.getNome()).sexo(funcionario.getSexo())
					.nascimento(funcionario.getNascimento()).build());
		}
		return funcionarioDto;
	} 
	
	
	
	
	

}
