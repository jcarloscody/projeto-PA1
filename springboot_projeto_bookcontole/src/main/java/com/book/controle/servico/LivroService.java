package com.book.controle.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.controle.dominio.Categoria;
import com.book.controle.dominio.Livro;
import com.book.controle.repositories.LivroRepository;
import com.book.controle.servico.excecoes.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = this.livroRepository.findById(id); // optional pq pode encontrar ou nao
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat); // caso não exita retorna uma exceção
		return livroRepository.findAllByIdCategoria(id_cat);
	}

	public Livro upDate(Integer id, Livro obj) {
		Livro newObj = findById(id);
		upDateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void upDateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setTexto(obj.getTexto());
		newObj.setNome_autor(obj.getNome_autor());
	}

	public Livro create(Integer cat_id, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(cat_id);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
		livroRepository.delete(obj);
	}

}
