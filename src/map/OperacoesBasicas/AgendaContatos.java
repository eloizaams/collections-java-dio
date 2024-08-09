package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
	
	private Map<String, Integer> contatosMap;

	public AgendaContatos() {
		this.contatosMap = new HashMap<String, Integer>();
	}
	
	public void adicionarContato(String nome, Integer telefone) {
		contatosMap.put(nome, telefone);
	}
	
	public void removerContato(String nome) {
		if(!contatosMap.isEmpty()) {
			contatosMap.remove(nome);
		}
	}

	public void exibirContatos() {
		System.out.println(contatosMap);
	}
	
	public Integer pesquisarPorNome(String nome) {
		return contatosMap.get(nome);
	}
	
	public static void main(String[] args) {
		AgendaContatos agenda= new AgendaContatos();
		
		agenda.adicionarContato("Camila", 123456);
		agenda.adicionarContato("Camila", 0);
		agenda.adicionarContato("Camila Cavalcanti",3333);
		agenda.adicionarContato("Camila Dio",85475);
		agenda.adicionarContato("Maria", 111111);
		agenda.adicionarContato("Camila", 44444);
		
		agenda.exibirContatos();
		System.out.println(agenda.pesquisarPorNome("Camila"));
		
		agenda.removerContato("Maria");
		agenda.exibirContatos();
	}
}
