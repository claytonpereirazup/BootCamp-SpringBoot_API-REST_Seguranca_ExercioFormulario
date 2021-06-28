package br.com.zup.avaliacao.controller.dto;

import br.com.zup.avaliacao.modelo.Aluno;

public class AlunoDtoDetalhe {
	
	private String nome;
	private String email;
	
	public AlunoDtoDetalhe() {
	}

	public AlunoDtoDetalhe(Aluno entity) {
		this.nome = entity.getNome();
		this.email = entity.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
}
