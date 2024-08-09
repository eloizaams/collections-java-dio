import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConjuntoPalavrasUnicas {
	
	private Set<String> conjuntoPalavrasUnicas;

	public ConjuntoPalavrasUnicas() {
		this.conjuntoPalavrasUnicas = new HashSet<>();
	}
	
	public boolean adicionarPalavra(String palavra){
		return conjuntoPalavrasUnicas.add(palavra);
	}
	
	public boolean removerPalavra(String palavra){
		return conjuntoPalavrasUnicas.remove(palavra);
	}
	
	public boolean verificarPalavra(String palavra){
		return conjuntoPalavrasUnicas.contains(palavra);
		
	}
	
	public void exibirPalavrasUnicas(){
		System.out.println(conjuntoPalavrasUnicas);
	}
	
	public static void main(String[] args) {
		ConjuntoPalavrasUnicas cpu = new ConjuntoPalavrasUnicas();
		cpu.adicionarPalavra("Amora");
		cpu.adicionarPalavra("Morango");
		cpu.adicionarPalavra("Framboesa");
		cpu.adicionarPalavra("Melão");
		cpu.adicionarPalavra("Manga");
		cpu.adicionarPalavra("Abacaxi");
		cpu.adicionarPalavra("Laranja");
		
	    cpu.exibirPalavrasUnicas();
	    
	    cpu.removerPalavra("Framboesa");
	    cpu.exibirPalavrasUnicas();
	    
	    String palavra1 = "Amora",
	    		palavra2 = "Banana";
	    
	    System.out.println("A palavra " + palavra1 + (cpu.verificarPalavra(palavra1)?" está": " não está") + " no conjunto");
	    System.out.println("A palavra " + palavra2 + (cpu.verificarPalavra(palavra2)?" está": " não está") + " no conjunto");
	    
	}
	
}
