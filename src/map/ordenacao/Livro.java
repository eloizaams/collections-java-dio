package map.ordenacao;

import java.util.Objects;

public class Livro {
	
	private String titulo;
	private String autor;
	private Double preco;

	public Livro(String titulo, String autor, Double preco) {
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Livro))
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	
	
	

}
