package br.com.education.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.education.dto.FuncionarioDto;
import br.com.education.response.Response;
import br.com.education.service.FuncionarioService;

@RestController
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping(value="/funcionario",method = RequestMethod.POST)
	public ResponseEntity<Response<FuncionarioDto>> novoFuncionario(@Valid @RequestBody FuncionarioDto funcionarioDto, 
			BindingResult result){
		Response<FuncionarioDto> response = new Response<FuncionarioDto>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return new ResponseEntity<Response<FuncionarioDto>>(response,HttpStatus.BAD_REQUEST);
		}
		response.setData(funcionarioService.save(funcionarioDto));
		return new ResponseEntity<Response<FuncionarioDto>>(response,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
	public ResponseEntity<FuncionarioDto> funcionario(@PathVariable(value = "id") long id){
		FuncionarioDto funcionarioDto = funcionarioService.getById(id);
		if(Objects.nonNull(funcionarioDto)) {
			return new ResponseEntity<FuncionarioDto>(funcionarioDto,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/funcionario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FuncionarioDto> delete(@PathVariable(value = "id") long id){
		FuncionarioDto funcionarioDto = funcionarioService.getById(id);
		if(Objects.nonNull(funcionarioDto)) {
			funcionarioService.delete(funcionarioDto.getId());
			return new ResponseEntity<FuncionarioDto>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<FuncionarioDto>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/funcionario", method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDto>> allFuncionario(){
		List<FuncionarioDto> funcionarioDtos = funcionarioService.getAll();
		if(Objects.nonNull(funcionarioDtos)) {
			return new ResponseEntity<List<FuncionarioDto>>(funcionarioDtos,HttpStatus.OK);
		}
		return new ResponseEntity<List<FuncionarioDto>>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "funcionario/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FuncionarioDto> put(@PathVariable(value = "id") long id, 
			@RequestBody FuncionarioDto funcionarioDto){
		FuncionarioDto dto = funcionarioService.getById(id);
		if(Objects.nonNull(dto)) {
			funcionarioDto.setId(id);
			if(Strings.isEmpty(funcionarioDto.getNome())) {
				funcionarioDto.setNome(dto.getNome());
			}
			if(Strings.isEmpty(funcionarioDto.getSexo())) {
				funcionarioDto.setSexo(dto.getSexo());
			}
			funcionarioService.save(funcionarioDto);
			return new ResponseEntity<FuncionarioDto>(funcionarioDto, HttpStatus.OK);
		}
		return new ResponseEntity<FuncionarioDto>(HttpStatus.BAD_REQUEST);
	}
	
}
