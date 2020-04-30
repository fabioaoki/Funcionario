package br.com.education.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.education.dto.FuncionarioDto;
import br.com.education.dto.SetorDto;
import br.com.education.service.FuncionarioService;
import br.com.education.service.SetorService;

@RestController
public class SetorController {
	
	@Autowired
	SetorService setorService;
	
	@Autowired
	FuncionarioService funcionarioService; 
	
	@RequestMapping(value = "/setor/{id}", method = RequestMethod.POST)
	public ResponseEntity<SetorDto> insereSetor(@PathVariable(value = "id") long id,
			@RequestBody SetorDto setorDto){
		
		FuncionarioDto funcionarioDto = funcionarioService.getById(id);
		if(Objects.nonNull(funcionarioDto)) {
			setorDto.setIdFuncionario(funcionarioDto.getId());
			setorService.newSetor(setorDto);
			return new ResponseEntity<SetorDto>(setorDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<SetorDto>(HttpStatus.BAD_REQUEST);
	}
	

}
