import java.util.*;

public class Teste{

	static public void main(String[] args){
		
		Integer itens;

		//Coleção vetor
		Vector<Integer> item = new Vector<Integer>();	
		
		//Adicionando itens na coleção
		for(int i=0;i<9;i++){
			itens = i;	
			item.add(itens);
		}
			
		//Recebendo iterador da coleção
		Iterator<Integer> i = item.iterator();
		
		//Imprimindo todos os itens da coleção	
		System.out.println("Antes da ordenação.");
		while(i.hasNext()){
			itens = i.next();
			System.out.println(itens);
		}


		//Criação do objeto responsável por implementar a classe Comparator	
		Comparar cp = new Comparar();
		
		//Ordenação da coleção utilizando a minha própia comparação
		item.sort(cp);	
		
		//Recebendo iterador da coleção
		i = item.iterator();
		
		//Imprimindo todos os itens da coleção	
		System.out.println("Depois da ordenação.");
		while(i.hasNext()){
			itens = i.next();
			System.out.println(itens);
		}
	}
}
