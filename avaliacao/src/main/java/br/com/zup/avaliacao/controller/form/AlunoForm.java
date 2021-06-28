package br.com.zup.avaliacao.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.avaliacao.modelo.Aluno;

public class AlunoForm {
	
	@NotBlank
	@Size(min = 5, max = 30)
	private String nome;
	@NotNull
	@Min(value = 18)
	private Integer idade;
	@Email
	@Size(min = 10, max = 40)
	private String email;
	
	public AlunoForm() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//metodo conversor de Form -> Entidade
	public Aluno converteFomParaEntidade(AlunoForm form) {
		return new Aluno(nome, idade, email);
	}
	
	
}
