package br.com.zup.avaliacao.controller.dto;

import br.com.zup.avaliacao.modelo.Aluno;

public class AlunoDto {
	private Long id;
	private String nome;
	private Integer idade;
	private String email;
	
	public AlunoDto() {
	}

	public AlunoDto(Aluno entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.idade = entity.getIdade();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getEmail() {
		return email;
	}
	
}
