package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
	
	private Map<String, Integer> contagemPalavras;

	public ContagemPalavras() {
		this.contagemPalavras = new HashMap<String, Integer>();
	}
	
	//Adiciona uma palavra à contagem.
	public void adicionarPalavra(String palavra) {
		if(contagemPalavras.containsKey(palavra)) {
			contagemPalavras.put(palavra, contagemPalavras.get(palavra)+1);
		}
		else {
			contagemPalavras.put(palavra, 1);
		}
	}
	
	public void removerPalavra(String palavra) {
		contagemPalavras.remove(palavra);
	}

	public void exibirContagemPalavras() {
		System.out.println(contagemPalavras);
	}
	
	public String encontraPalavraMaisFrequente() {
		int contaPalavraMaisFrequente = 0;
		String palavraMaisFrequente = "";
		for (Map.Entry<String, Integer> entry : contagemPalavras.entrySet()) {
		      if (entry.getValue() > contaPalavraMaisFrequente) {
		    	  contaPalavraMaisFrequente = entry.getValue();
		          palavraMaisFrequente = entry.getKey();
			}
		}
		return palavraMaisFrequente + " -> " + contaPalavraMaisFrequente + " vezes";
	}
	 public static void main(String[] args) {
		    ContagemPalavras contagemLinguagens = new ContagemPalavras();

		    // Adiciona linguagens e suas contagens
		    contagemLinguagens.adicionarPalavra("Java");
		    contagemLinguagens.adicionarPalavra("Java");
		    contagemLinguagens.adicionarPalavra("Python");
		    contagemLinguagens.adicionarPalavra("Python");
		    contagemLinguagens.adicionarPalavra("Python");
		    contagemLinguagens.adicionarPalavra("Python");
		    contagemLinguagens.adicionarPalavra("Python");
		    contagemLinguagens.adicionarPalavra("JavaScript");
		    contagemLinguagens.adicionarPalavra("C#");
		    contagemLinguagens.adicionarPalavra("C#");
		    contagemLinguagens.adicionarPalavra("C#");
		    contagemLinguagens.adicionarPalavra("C#");
		    

		    // Exibe a contagem total de linguagens
		    contagemLinguagens.exibirContagemPalavras();

		    // Encontra e exibe a linguagem mais frequente
		    String linguagemMaisFrequente = contagemLinguagens.encontraPalavraMaisFrequente();
		    System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
		  }
}
