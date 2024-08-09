package set.Pesquisa;

import java.util.Objects;

public class Contato {
	
	private String nome;
	private int telefone;

	public Contato(String nome, int telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public int getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		return nome + " - " + telefone ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contato))
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome);
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
	

}
