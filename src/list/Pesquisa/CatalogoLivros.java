package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
	
	private List<Livro> catologoLivros;

	public CatalogoLivros() {
		this.catologoLivros = new ArrayList<>();
	}
	
	public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
		catologoLivros.add(new Livro(titulo, autor, anoPublicacao));
	}
	
	public List<Livro> pesquisarPorAutor(String autor){
		List<Livro> listaPesquisa = new ArrayList<Livro>();
		
		if (!catologoLivros.isEmpty()) {
			for(Livro livro: catologoLivros) {
				if(livro.getAutor().equalsIgnoreCase(autor)) {
					listaPesquisa.add(livro);
				}
			}
		}
	
		return listaPesquisa;	
	}
	
	public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
		List<Livro> listaPesquisa = new ArrayList<Livro>();
				
				if (!catologoLivros.isEmpty()) {
					for(Livro livro: catologoLivros) {
						if(livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
							listaPesquisa.add(livro);
						}
					}
				}
			
		return listaPesquisa;	
	}
	
	public Livro pesquisarPorTitulo(String titulo){
				
		if (!catologoLivros.isEmpty()) {
			for(Livro livro: catologoLivros) {
				if(livro.getTitulo().equalsIgnoreCase(titulo)) {
					return livro;
				}
			}
		}
	
		return null;	
	}
	
	public static void main(String[] args) {
		CatalogoLivros catalogoLivros = new CatalogoLivros();
		catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
		catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
		catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
		catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
		catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);
		
		System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));
		
		System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2020, 2022));
		
		System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
	}
}//class CatalogoLivros
