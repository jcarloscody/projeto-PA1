package com.book.controle.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.book.controle.dominio.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 100, message = "campo deve ter 3-100 caracters")
	private String titulo;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro obj) {
		super();
		id = obj.getId();
		titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
