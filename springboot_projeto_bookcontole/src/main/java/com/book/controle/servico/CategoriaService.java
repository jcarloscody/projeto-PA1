package com.book.controle.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.book.controle.dominio.Categoria;
import com.book.controle.dto.CategoriaDTO;
import com.book.controle.repositories.CategoriaRepository;
import com.book.controle.servico.excecoes.DataIntegrityViolationExceptionn;
import com.book.controle.servico.excecoes.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = this.categoriaRepository.findById(id); // optional pq pode encontrar ou nao
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria upDate(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setdescricao(objDTO.getDescricao());
		obj.setNome(objDTO.getNome());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityViolationExceptionn("Esta categoria possui livros, não pode ser deletada");
		}
	}

}
