package br.com.zup.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.avaliacao.modelo.Aluno;

@RestController
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
