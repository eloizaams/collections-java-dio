package set.Ordenacao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
	
	private Set<Produto> produtoSet;

	public CadastroProdutos() {
		this.produtoSet = new HashSet<>();
	}
	
	public void adicionarProduto (long codigo, String nome, double preco, int quantidade) {
		produtoSet.add(new Produto(codigo, nome, preco, quantidade));
	}
	
	public Set<Produto>  exibirProdutosPorNome() {
		return new TreeSet<Produto>(produtoSet);	
	}
	
	public Set<Produto>  exibirProdutosPorPreco() {
		Set<Produto> produtoPorPreco =  new TreeSet<Produto>(new ComparaPorPreco());	
		produtoPorPreco.addAll(produtoSet);
		return produtoPorPreco;
	}

	public static void main(String[] args) {
		CadastroProdutos cadastro = new CadastroProdutos();
		cadastro.adicionarProduto(1L, "Produto 5", 15d, 5);
		cadastro.adicionarProduto(2L, "Produto 0", 20d, 10);
		cadastro.adicionarProduto(1L, "Produto 3", 10d, 2);
		cadastro.adicionarProduto(9L, "Produto 9",2d, 2);
		
		System.out.println(cadastro.produtoSet);
		
		System.out.println(cadastro.exibirProdutosPorNome());
		
		System.out.println(cadastro.exibirProdutosPorPreco());
		
	}
}

class ComparaPorPreco implements Comparator<Produto>{

	@Override
	public int compare(Produto p1, Produto p2) {
		
		return Double.compare(p1.getPreco(), p2.getPreco());
	}
	
}
