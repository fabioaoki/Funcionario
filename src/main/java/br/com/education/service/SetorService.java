package br.com.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.education.dto.SetorDto;
import br.com.education.entity.Setor;
import br.com.education.repository.SetorRepository;

@Service
public class SetorService {

	@Autowired
	SetorRepository setorRepository;

	public SetorDto newSetor(SetorDto setorDto) {
		Setor setor = Setor.builder().nomeSetor(setorDto.getNomeSetor()).id(setorDto.getId()).
				idFuncionario(setorDto.getIdFuncionario()).build();
		setorRepository.save(setor);
		return setorDto;
	}
	
	public SetorDto getSetorId(long id) {
		Setor setor = setorRepository.findById(id);
		return SetorDto.builder().id(setor.getId()).idFuncionario(setor.getIdFuncionario())
				.nomeSetor(setor.getNomeSetor()).build();
			
	}
	
}
