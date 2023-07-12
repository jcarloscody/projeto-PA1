package com.book.controle.dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GenerationType;

@Entity
public class Livro  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 100, message = "campo deve ter 3-100 caracters")
	private String titulo;

	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 100, message = "campo deve ter 3-100 caracters")
	private String nome_autor;
	
	@NotEmpty(message = "Fiel must be full")
	@Length(min = 3, max = 2000000, message = "campo deve ter 3-2000000 caracters")
	private String texto;

	//proteger contra a serializacao https://stackoverflow.com/questions/47693110/could-not-write-json-infinite-recursion-stackoverflowerror-nested-exception
	//pode usar tbm o jsonignore
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
		super();
		Id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Livro other = (Livro) obj;
		return Objects.equals(Id, other.Id);
	}

}
