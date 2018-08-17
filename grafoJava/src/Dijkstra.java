import java.util.*;

public class Dijkstra{
	
	//Atributos
	PriorityQueue<Vertice> q;
	Compare cmp;

	//Construtor
	public Dijkstra(){
		cmp = new Compare();
		q = new PriorityQueue<Vertice>(cmp);	
	}

	//Algoritmo dijkstra
	public void dijkstra(Grafo g, Vertice v, Vertice f){
		
		int i;
		Vertice[] listV;
		Vertice w,y;
		Aresta[] listA;

		//Recebendo todos os vertices de g		
		listV = g.vertices();
		
		//O Vertice inicial possui distancia 0
		v.setDist(0);

		//Adicionando todos os vertices na heap
		for(i=0;i<g.getnV();i++){
			q.add(listV[i]);
		}
		
		while(q.size() != 0){
			
			//Vertice com menor peso	
			w = q.poll();	
		
			//Arestas incidente de w
			listA = g.incidentAresta(w);
			
			i = 0;
			while(listA[i++] != null){
				//Vertice oposto a w	
				y = g.opposite(listA[i-1],w);	

				if(y.getDist() > w.getDist() +listA[i-1].getAresta()){
					y.setDist(w.getDist() + listA[i-1].getAresta());
					q.remove(y);
					q.add(y);
					y.setPai(w);
				}
			}	
		}
		
		while(f != null){
			System.out.println(f.getVertice());	
			f = f.getPai();
		}	
	}
}

//Classe que sera utilizada para comparacao
class Compare implements Comparator<Vertice>{

	public int compare(Vertice v1, Vertice v2){
	
		if(v1.getDist() > v2.getDist()){
			return 1;
		}
		if(v1.getDist() == v2.getDist()){
			return 1;
		}
		return -1;
	}	
}
