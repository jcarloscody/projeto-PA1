package com.book.controle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.controle.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<Livro> findAllByIdCategoria(@Param(value = "id_cat") Integer id_cat);


}
