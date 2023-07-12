package com.book.controle.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 100, message = "campo deve ter 3-100 caracters")
	private String nome;
	
	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 200, message = "campo deve ter 3-100 caracters")
	private String descricao;
	
	//proteger contra a serializacao https://stackoverflow.com/questions/47693110/could-not-write-json-infinite-recursion-stackoverflowerror-nested-exception
	@JsonManagedReference
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<>();

	public Categoria() {
		super();
	}

	public Categoria(Integer id, String nome, String descricao) {
		super();
		Id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getdescricao() {
		return descricao;
	}

	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(Id, other.Id);
	}
	
	
	
}
