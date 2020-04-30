package br.com.education.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.education.dto.PagamentoDto;
import br.com.education.entity.Pagamento;
import br.com.education.repository.PagamentoRepository;

@Service
public class PagamentoSevice {

	@Autowired
	PagamentoRepository pagamentoRepository;

	public PagamentoDto save(PagamentoDto pagamentoDto) {
		Pagamento pagamento = Pagamento.builder().idFuncioario(pagamentoDto.getIdFuncionario())
				.nomeFuncionario(pagamentoDto.getNomeFuncionario()).nomeSetor(pagamentoDto.getNomeSetor())
				.id(pagamentoDto.getId()).valor(pagamentoDto.getValor()).build();
		pagamentoRepository.save(pagamento);
		return pagamentoDto;
		
	}

	public PagamentoDto buscaPagamento(long id) {
		Pagamento pagamento = pagamentoRepository.findById(id);
		PagamentoDto pagamentoDto = PagamentoDto.builder().id(pagamento.getId()).nomeFuncionario(pagamento.getNomeFuncionario())
				.idFuncionario(pagamento.getIdFuncioario()).valor(pagamento.getValor()).nomeSetor(pagamento.getNomeSetor()).build();
		return pagamentoDto;
	}

	public List<PagamentoDto> buscaPagamentos() {
		List<Pagamento> pagamentos = pagamentoRepository.findAll();
		List<PagamentoDto> pagamentoDtos = new ArrayList<>();
		
		for (Pagamento pagamento : pagamentos) {
			pagamentoDtos.add(PagamentoDto.builder().id(pagamento.getId())
					.nomeFuncionario(pagamento.getNomeFuncionario()).idFuncionario(pagamento.getIdFuncioario())
					.nomeSetor(pagamento.getNomeSetor()).valor(pagamento.getValor()).build());
		}
		return pagamentoDtos;
	}

	public void deletaPagamento(long id) {
		pagamentoRepository.deleteById(id);
	}
}
