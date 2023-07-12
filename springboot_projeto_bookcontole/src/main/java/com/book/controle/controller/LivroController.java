package com.book.controle.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.controle.dominio.Livro;
import com.book.controle.dto.LivroDTO;
import com.book.controle.servico.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro obj = this.livroService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@GetMapping // 8090/livros?categoria=1 listar todos os livros de uma determinada categoria
	public ResponseEntity<List<LivroDTO>> findAll(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Livro> list = livroService.findAll(id_cat);
		List<LivroDTO> listDTO = list.stream().map((obj) -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> upDate(@PathVariable Integer id, @Valid @RequestBody Livro obj) {
		Livro newObj = livroService.upDate(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@CrossOrigin
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> upDatePatch(@PathVariable Integer id, @Valid @RequestBody Livro obj) {
		Livro newObj = livroService.upDate(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@CrossOrigin
	@PostMapping // 8080/livros?categoria=3
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer cat_id,
			@Valid @RequestBody Livro obj) {
		Livro newObj = livroService.create(cat_id, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
