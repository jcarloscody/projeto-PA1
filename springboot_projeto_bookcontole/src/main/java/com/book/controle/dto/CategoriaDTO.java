package com.book.controle.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.book.controle.dominio.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer Id;
	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 100, message = "campo deve ter 3-100 caracters")
	private String nome;

	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 200, message = "campo deve ter 3-100 caracters")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		Id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getdescricao();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
