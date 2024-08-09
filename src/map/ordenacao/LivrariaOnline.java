package map.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class LivrariaOnline {

	private Map<String, Livro> livrariaOnline;

	public LivrariaOnline() {
		this.livrariaOnline = new HashMap<>();
	}

	// Adiciona um livro à livraria, utilizando o o link da obra na Amazon
	// Marketplace como chave no Map.
	public void adicionarLivro(String link, String titulo, String autor, double preco) {
		livrariaOnline.put(link, new Livro(titulo, autor, preco));
	}

	// Remove um ou mais livros da livraria, dado o titulo do livro.
	public void removerLivro(String titulo) {
		List<String> chavesRemover = new ArrayList<>();
		for (Map.Entry<String, Livro> entry : livrariaOnline.entrySet()) {
			if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
				chavesRemover.add(entry.getKey());
			}
		}
		for (String chave : chavesRemover) {
			livrariaOnline.remove(chave);
		}
	}

	// Exibe os livros da livraria em ordem crescente de preço.
	public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
		List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaOnline.entrySet());

		Collections.sort(livrosParaOrdenarPorPreco, new ComparaPreco());

		Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

		for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
			livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
		}

		return livrosOrdenadosPorPreco;
	}

	// Retorna uma lista ordenada de todos os livros escritos por um determinado autor.
	public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
		List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrariaOnline.entrySet());

		Collections.sort(livrosParaOrdenarPorAutor, new ComparaAutor());

		Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

		for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
			livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
		}

		return livrosOrdenadosPorAutor;
	}

	// Retorna o livro mais caro disponível na livraria.
	public Livro obterLivroMaisCaro() {
		double precoMaisCaro = Double.MIN_VALUE;
		Livro livroMaisCaro = null;
		for (Livro livro : livrariaOnline.values()) {
			if (livro.getPreco() > precoMaisCaro) {
				precoMaisCaro = livro.getPreco();
				livroMaisCaro = livro;
			}
		}
		return livroMaisCaro;
	}

	// Retorna o livro mais barato disponível na livraria.
	public Livro exibirLivroMaisBarato() {
		double precoMaisBarato = Double.MAX_VALUE;
		Livro livroMaisBarato = null;
		for (Livro livro : livrariaOnline.values()) {
			if (livro.getPreco() < precoMaisBarato) {
				precoMaisBarato = livro.getPreco();
				livroMaisBarato = livro;
			}
		}
		return livroMaisBarato;
	}
	
	 public static void main(String[] args) {
		    LivrariaOnline livrariaOnline = new LivrariaOnline();
		    // Adiciona os livros à livraria online
		    livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", "1984", "George Orwell", 50d);
		    livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", "A Revolução dos Bichos", "George Orwell", 7.05d);
		    livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", "Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
		    livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", "Malorie", "Josh Malerman", 5d);
		    livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", "E Não Sobrou Nenhum", "Agatha Christie", 50d);
		    livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", "Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

		    // Exibe todos os livros ordenados por preço
		    System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

		    // Pesquisa livros por autor
		    String autorPesquisa = "Josh Malerman";
		    livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

		    // Obtém e exibe o livro mais caro
		    System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

		    // Obtém e exibe o livro mais barato
		    System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

		    // Remover um livro pelo título
		    livrariaOnline.removerLivro("1984");
		   

		  }
}

class ComparaPreco implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		return Double.compare(l1.getValue().getPreco(), l2.getValue().getPreco());
	}
}

class ComparaAutor implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		return l1.getValue().getAutor().compareToIgnoreCase(l2.getValue().getAutor());

	}

}
