package br.com.education.controller;

import java.util.List;
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
import br.com.education.dto.PagamentoDto;
import br.com.education.service.FuncionarioService;
import br.com.education.service.PagamentoSevice;

@RestController
public class PagamentoController {
	
	@Autowired
	PagamentoSevice pagamentoSevice;
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping(value="/pagamento/{id}",method = RequestMethod.POST)
	public ResponseEntity<PagamentoDto> pagar(@PathVariable (value = "id") long id, 
			@RequestBody PagamentoDto pagamentoDto){
		
		FuncionarioDto funcionarioDto =  funcionarioService.getById(id);
		if(Objects.nonNull(funcionarioDto)){
			pagamentoDto.setNomeFuncionario(funcionarioDto.getNome());
			pagamentoDto.setIdFuncionario(funcionarioDto.getId());
			pagamentoSevice.save(pagamentoDto);
			return new ResponseEntity<PagamentoDto>(pagamentoDto, HttpStatus.OK);
		}
		return new ResponseEntity<PagamentoDto>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/pagamento/{id}", method = RequestMethod.GET)
	public ResponseEntity<PagamentoDto> buscaPagamento(@PathVariable(value = "id") long id){
		PagamentoDto pagamentoDto = pagamentoSevice.buscaPagamento(id);
		if(Objects.nonNull(pagamentoDto)) {
			return new ResponseEntity<PagamentoDto>(pagamentoDto, HttpStatus.OK);
		}
		return new ResponseEntity<PagamentoDto>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/pagamento", method = RequestMethod.GET)
	public ResponseEntity<List<PagamentoDto>> todosPagamentos(){
		
		List<PagamentoDto> pagamentoDto = pagamentoSevice.buscaPagamentos();
		
		if(Objects.nonNull(pagamentoDto)) {
			return new ResponseEntity<List<PagamentoDto>>(pagamentoDto,HttpStatus.OK);
		}
		return new ResponseEntity<List<PagamentoDto>>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/pagamento/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PagamentoDto> deletaPagamento (@PathVariable (value = "id") long id){
		if(Objects.nonNull(pagamentoSevice.buscaPagamento(id))) {
			pagamentoSevice.deletaPagamento(id);
			return new ResponseEntity<PagamentoDto>(HttpStatus.OK);
		}
		return new ResponseEntity<PagamentoDto>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/pagamento/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PagamentoDto> atualizaPagamento(@PathVariable (value = "id") long id, 
			@RequestBody PagamentoDto pagamentoDto){
		
		if(Objects.nonNull(pagamentoSevice.buscaPagamento(id))) {
			PagamentoDto dto = pagamentoDto;
			dto.setId(id);
			pagamentoSevice.save(dto);
			return new ResponseEntity<PagamentoDto>(dto,HttpStatus.OK);
		}
		return new ResponseEntity<PagamentoDto>(HttpStatus.BAD_REQUEST) ;
	}
}


