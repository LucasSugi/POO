import java.util.*;

public class Kruskal{
	
	//Atributos
	ArrayList<Aresta> fila;
	private final int FORA = 0;
	private final int DENTRO = 1;

	//Construtor
	public Kruskal(){
		fila = new ArrayList<Aresta>();
	}

	//Algoritmo Kruskal
	public void kruskal(Grafo g){
	
		Vertice[] listV;
		Aresta[] listA;
		Aresta a;
		int i;

		//Criando a particao para todos os vertices
		Particao[] p = new Particao[g.getnV()];	
		
		//Populando a particao com todos os vertices	
		listV = g.vertices();	
		for(i=0;i<g.getnV();i++){
			p[i] = new Particao();
			p[i].add(listV[i]);
			listV[i].setRotulo(p[i].getRotulo());
		}

		//Populando a fila com as arestas
		listA = g.arestas();
		for(i=0;i<g.getnA();i++){
			fila.add(listA[i]);
		}

		//Criando o objeto que sera utilizado para comparar
		Comparar2 cmp = new Comparar2();

		//Ordenar as arestas
		fila.sort(cmp);

		while(fila.size() != 0){
				
			a = fila.remove(0);

			//Calculando os vertices finais da aresta
			listV = g.endVertices(a);

			//Verificando se os vertices fazem parte de particoes diferentes
			if(listV[0].getRotulo() != listV[1].getRotulo()){
				p[listV[0].getRotulo()].concat(p[listV[1].getRotulo()]);	
				a.setRotulo(DENTRO);
			}
		}
	}
}


class Comparar2 implements Comparator<Aresta>{
	
	@Override
	public int compare(Aresta a1, Aresta a2){
		if(a1.getAresta() > a2.getAresta()){
			return 1;
		}	
		else if(a1.getAresta() == a2.getAresta()){
			return 0;
		}
		return -1;
	}

}
