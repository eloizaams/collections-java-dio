package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
	
	private List<Item> carrinho;

	public CarrinhoDeCompras() {
		this.carrinho = new ArrayList<>(); 
	}
	
	public void adicionarItem(String nome, double preco, int quantidade) {
		carrinho.add(new Item(nome, preco, quantidade));
	}
	
	public void removerItem(String nome) {
		List<Item> itensASeremRemovidos = new ArrayList<>();
		
		for(Item item: carrinho) {
			if(item.getNome().equalsIgnoreCase(nome)) {
				itensASeremRemovidos.add(item);
			}
		}
		
		carrinho.removeAll(itensASeremRemovidos);
	}
	
	public double calcularValorTotal() {
		double soma = 0.0;
		for(Item item: carrinho) {
			soma += item.getPreco()*item.getQuantidade();
		}
		return soma;
	}
	
	public void exibirItens() {
		System.out.println(carrinho);
	}
	
	
	public static void main(String[] args) {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		carrinho.adicionarItem("Banco", 54.90, 6);
		carrinho.adicionarItem("mesa", 200.0, 10);
		carrinho.adicionarItem("Banco", 82.0, 2);
		carrinho.adicionarItem("Tapete", 195.00, 2);
		
		carrinho.exibirItens();
		
		carrinho.removerItem("Banco");
		carrinho.exibirItens();
		
		System.out.printf("\nO valor total do carrinho de compras é: R$ %,.2f", carrinho.calcularValorTotal());
	}
}
