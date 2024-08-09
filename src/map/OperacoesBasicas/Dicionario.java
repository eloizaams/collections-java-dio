package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
	
	private Map<String, String> dicionario;

	public Dicionario() {
		this.dicionario = new HashMap<String, String>();
	}
	
	public void adicionarPalavra(String palavra, String definicao) {
		dicionario.put(palavra, definicao);
	}
	
	public void removerPalavra(String palavra) {
		if(!dicionario.isEmpty()) {
			dicionario.remove(palavra);
		}
	}
	
	public void exibirPalavras() {
		System.out.println(dicionario);
	}
	
	public String pesquisarPorPalavra(String palavra) {
		return dicionario.get(palavra);
	}

	public static void main(String[] args) {
		Dicionario dicionario = new Dicionario();
		
		dicionario.adicionarPalavra("palavra 1", "Significado 1");
		dicionario.adicionarPalavra("palavra 1", "Significado 1.2");
		dicionario.adicionarPalavra("palavra 2", "Significado 2");
		dicionario.adicionarPalavra("palavra 3", "Significado 3");
		dicionario.adicionarPalavra("palavra 4", "Significado 4");
		
		dicionario.exibirPalavras();
		
		dicionario.removerPalavra("palavra 1");
		
		dicionario.exibirPalavras();
		
		System.out.println(dicionario.pesquisarPorPalavra("palavra 1"));
		System.out.println(dicionario.pesquisarPorPalavra("palavra 2"));
	}
}
