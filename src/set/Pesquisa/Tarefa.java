package set.Pesquisa;

import java.util.Objects;

public class Tarefa {
	
	private String descricao;
	private boolean concluida;
	
	public Tarefa(String descricao) {
		this.descricao = descricao;
		this.concluida = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}

	@Override
	public String toString() {
		return descricao + " - " + (concluida?"Concluída":"Pendente");
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tarefa))
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(descricao, other.descricao);
	}
	
	
	

}
