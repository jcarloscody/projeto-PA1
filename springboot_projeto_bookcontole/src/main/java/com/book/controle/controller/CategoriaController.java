package com.book.controle.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.controle.dominio.Categoria;
import com.book.controle.dto.CategoriaDTO;
import com.book.controle.servico.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = this.categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> listCategorias = categoriaService.findAll();
		List<CategoriaDTO> categoriaDTOs = listCategorias.stream().map((obj) -> new CategoriaDTO(obj)).toList();
		return ResponseEntity.ok().body(categoriaDTOs);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj) {
		Categoria post = categoriaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> upDate(@PathVariable Integer id, @Valid @RequestBody CategoriaDTO objDTO) {
		Categoria newObj = categoriaService.upDate(id, objDTO);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
