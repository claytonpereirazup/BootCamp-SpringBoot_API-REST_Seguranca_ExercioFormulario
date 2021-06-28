package br.com.zup.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.avaliacao.controller.dto.AlunoDto;
import br.com.zup.avaliacao.controller.dto.AlunoDtoDetalhe;
import br.com.zup.avaliacao.controller.form.AlunoForm;
import br.com.zup.avaliacao.modelo.Aluno;
import br.com.zup.avaliacao.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<AlunoDto> listar() {
	//lista em memória
	//Aluno aluno = new Aluno(1L, "Clayton Pereira", 48, "clayton.pereira@zup.com.br");
	//return aluno;
		
	List<Aluno> alunos = alunoRepository.findAll();
	return Aluno.converteEntidadeParaDto(alunos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDtoDetalhe> listarPorId(@PathVariable Long id) {
	Optional<Aluno> obj = alunoRepository.findById(id);
		if(obj.isPresent()) {
			//Aluno aluno = obj.get();
			return ResponseEntity.ok(new AlunoDtoDetalhe(obj.get()));
		}
	return ResponseEntity.badRequest().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoForm form, UriComponentsBuilder uriBuilder) {
		Aluno aluno = form.converteFomParaEntidade(form);
		alunoRepository.save(aluno);
			//URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
			//return ResponseEntity(uri).body(new AlunoDto(aluno));
	return ResponseEntity.ok().build();
	}

}
