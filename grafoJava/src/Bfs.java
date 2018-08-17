import java.util.*;

public class Bfs{
	
	//Atributos	
	LinkedList<Vertice> fila;
	final int EXPLORADO = 1;
	final int DESCOBERTO = -1;
	final int NAODESCOBERTO = 0;

	//Construtor
	public Bfs(){
		fila = new LinkedList<Vertice>();
	}
	
	//Algoritmo bfs
	public void bfs(Grafo g, Vertice v){
		
		Vertice w,y;
		Aresta[] a;
		int i;

		//Alterando o rotulo do primeiro vertice	
		v.setRotulo(EXPLORADO);	

		//Enfileirando o primeiro vertice
		fila.add(v);

		//Rodando o algoritmo ate a fila ficar fazia
		while(fila.size() != 0){
			
			//Desenfileirando	
			w = fila.remove();

			//Muda o rotulo do vertice
			w.setRotulo(EXPLORADO);

			//Processa o vertice
			System.out.println(w.getVertice());

			//Recebe as arestas incidentes do vertice
			a = g.incidentAresta(w);
			
			i = 0;	
			while(a[i++] != null){
				
				y = g.opposite(a[i-1],w);		

				if(y.getRotulo() == NAODESCOBERTO){
					y.setRotulo(DESCOBERTO);
					fila.add(y);
				}
			}	
		}
		
	}
}
