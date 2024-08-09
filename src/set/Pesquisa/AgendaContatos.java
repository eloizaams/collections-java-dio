package set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
	
	private Set<Contato> contatoSet;

	public AgendaContatos() {
		this.contatoSet = new HashSet<>();
	}
	
	public void adicionarContato(String nome, int telefone) {
		contatoSet.add(new Contato(nome, telefone));
	}
	
	public void exibirContatos() {
		System.out.println(contatoSet);
	}
	
	public Set<Contato> pesquisaPorNome(String nome) {
		Set<Contato> contatosPorNome = new HashSet<Contato>();
		for(Contato contato: contatoSet) {
			if (contato.getNome().startsWith(nome)) {
				contatosPorNome.add(contato);
			}
		}
		return contatosPorNome;
	}
	
	public Contato atualizarNumeroContato(String nome, int novoNumero) {
		Contato contatoAtualizado = null;
		for (Contato c: contatoSet) {
			if (c.getNome().equalsIgnoreCase(nome)) {
				c.setTelefone(novoNumero);
				contatoAtualizado = c;
				break;
			}
		}
		return contatoAtualizado;
	}
	
	public static void main(String[] args) {
		AgendaContatos agenda = new AgendaContatos();
		
		agenda.exibirContatos();
		
		agenda.adicionarContato("Camila", 123456);
		agenda.adicionarContato("Camila", 0);
		agenda.adicionarContato("Camila Cavalcanti",3333);
		agenda.adicionarContato("Camila Dio",85475);
		agenda.adicionarContato("Maria", 111111);
		
		agenda.exibirContatos();
		
		agenda.atualizarNumeroContato("Maria", 254521);
		agenda.exibirContatos();
		
		System.out.println(agenda.pesquisaPorNome("Camila"));
	}
}
