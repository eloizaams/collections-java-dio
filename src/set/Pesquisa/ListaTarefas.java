package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
	
	private Set<Tarefa> tarefasSet;

	public ListaTarefas() {
		this.tarefasSet = new HashSet<>();
	}
	
	//Adiciona uma nova tarefa ao Set.
	public void adicionarTarefa(String descricao){
		tarefasSet.add(new Tarefa(descricao));
	}
	
	//Remove uma tarefa do Set de acordo com a descrição, se estiver presente.
	public boolean removerTarefa(String descricao){
		return tarefasSet.remove(new Tarefa(descricao));
	}
	
	//Exibe todas as tarefas da lista de tarefas.
	public void exibirTarefas(){
		System.err.println(tarefasSet);
	}
	
	//Conta o número total de tarefas na lista de tarefas.
	public int contarTarefas() {
		return tarefasSet.size();
	}
	
	//Retorna um Set com as tarefas concluídas.
	public Set<Tarefa> obterTarefasConcluidas() {
		Set<Tarefa> tarefasConcluidas = new HashSet<>();
		for(Tarefa t: tarefasSet) {
			if(t.isConcluida()) {
				tarefasConcluidas.add(t);
			}
		}
		return tarefasConcluidas;
	}
	
	//Retorna um Set com as tarefas pendentes.
	public Set<Tarefa> obterTarefasPendentes() {
		Set<Tarefa> tarefasPendentes = new HashSet<>();
		for(Tarefa t: tarefasSet) {
			if(!t.isConcluida()) {
				tarefasPendentes.add(t);
			}
		}
		return tarefasPendentes;
	}
	
	// Marca uma tarefa como concluída de acordo com a descrição.
	public void marcarTarefaConcluida(String descricao) {
		for(Tarefa t: tarefasSet) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setConcluida(true);
			}
		}
	}
	
	//Marca uma tarefa como pendente de acordo com a descrição.
	public void marcarTarefaPendente(String descricao) {
		for(Tarefa t: tarefasSet) {
			if (t.getDescricao().equalsIgnoreCase(descricao)) {
				t.setConcluida(false);
			}
		}
	}
	
	// Remove todas as tarefas da lista de tarefas.
	public void limparListaTarefas() {
		tarefasSet.clear();
	}

	public static void main(String[] args) {
		ListaTarefas listaTarefas = new ListaTarefas();
		
		listaTarefas.adicionarTarefa("Tarefa 1");
		listaTarefas.adicionarTarefa("Tarefa 2");
		listaTarefas.adicionarTarefa("Tarefa 3");
		listaTarefas.adicionarTarefa("Tarefa 4");
		listaTarefas.adicionarTarefa("Tarefa 5");
		
		listaTarefas.exibirTarefas();
		
		listaTarefas.marcarTarefaConcluida("Tarefa 3");
		listaTarefas.marcarTarefaConcluida("Tarefa 2");
		System.out.println(listaTarefas.obterTarefasConcluidas());
		listaTarefas.marcarTarefaPendente("Tarefa 2");
		System.out.println(listaTarefas.obterTarefasPendentes());
		System.out.println("Tarefas na lista: " + listaTarefas.contarTarefas());
		listaTarefas.removerTarefa("Tarefa 1");
		System.out.println("Tarefas na lista: " + listaTarefas.contarTarefas());
		listaTarefas.limparListaTarefas();
		System.out.println("Tarefas na lista: " + listaTarefas.contarTarefas());
	}
}
