package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
	
	private Map<Long, Produto> estoqueProdutosMap;

	public EstoqueProdutos() {
		this.estoqueProdutosMap = new HashMap<>();
	}
	
	public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
	    estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
	 }
	
	 public void exibirProdutos() {
		System.out.println(estoqueProdutosMap);
	 }
	 
	 public double calcularValorTotalEstoque() {
		 double valorTotal = 0.0;
		 if(!estoqueProdutosMap.isEmpty()) {
			for(Produto p: estoqueProdutosMap.values()) {
				valorTotal += p.getPreco()*p.getQuantidade();
			}
		 }
		 return valorTotal;
	 }
			 
	 public Produto obterProdutoMaisCaro() {
		 Produto produtoMaisCaro = null;
		 Double maiorPreco = Double.MIN_VALUE;
		 if(!estoqueProdutosMap.isEmpty()) {
			 for(Produto p: estoqueProdutosMap.values()) {
				 if(p.getPreco() > maiorPreco) {
					 produtoMaisCaro = p;
					 maiorPreco = p.getPreco();
				 }
			 }
		 }		 
		 return produtoMaisCaro;
	 }
	 
	 public Produto obterProdutoMaisBarato() {
		 Produto produtoMaisBarato = null;
		 Double menorPreco = Double.MAX_VALUE;
		 if(!estoqueProdutosMap.isEmpty()) {
			 for(Produto p: estoqueProdutosMap.values()) {
				 if(p.getPreco() < menorPreco) {
					 produtoMaisBarato = p;
					 menorPreco = p.getPreco();
				 }
			 }
		 }		 
		 return produtoMaisBarato;
	 }
	 
	 public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
		 Produto produtoMaiorQuantidade = null;
		 Double maiorQuantidade = Double.MIN_VALUE;
		 if(!estoqueProdutosMap.isEmpty()) {
			 for(Produto p: estoqueProdutosMap.values()) {
				 if(p.getPreco()*p.getQuantidade() > maiorQuantidade) {
					 produtoMaiorQuantidade = p;
					 maiorQuantidade = p.getPreco()*p.getQuantidade();
				 }
			 }
		 }		 
		 return produtoMaiorQuantidade;
	 }
	 
	 public static void main(String[] args) {
		 EstoqueProdutos estoque = new EstoqueProdutos();

		    // Exibe o estoque vazio
		    estoque.exibirProdutos();

		    // Adiciona produtos ao estoque
		    estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
		    estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
		    estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
		    estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

		    // Exibe os produtos no estoque
		    estoque.exibirProdutos();

		    // Calcula e exibe o valor total do estoque
		    System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

		    // Obtém e exibe o produto mais caro
		    Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
		    System.out.println("Produto mais caro: " + produtoMaisCaro);

		    // Obtém e exibe o produto mais barato
		    Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
		    System.out.println("Produto mais barato: " + produtoMaisBarato);

		    // Obtém e exibe o produto com a maior quantidade em valor no estoque
		    Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
		    System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
		  }
 }
