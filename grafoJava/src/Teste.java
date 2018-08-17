import java.util.*;

public class Teste{

	static public void main(String[] args){
		
		Vertice v1,v2,v3,v4,v5,v6,v7;

		//Cria um grafo
		Grafo g = new Grafo();
			
		//Adicionando os vertices do grafo
		v1 = g.addVertice('A');
		v2 = g.addVertice('B');
		v3 = g.addVertice('C');
		v4 = g.addVertice('D');
		v5 = g.addVertice('E');
		v6 = g.addVertice('F');
		v7 = g.addVertice('G');
	
		g.addAresta(7,v1,v2);
		g.addAresta(5,v1,v4);
		g.addAresta(8,v2,v3);
		g.addAresta(9,v2,v4);
		g.addAresta(7,v2,v5);
		g.addAresta(5,v3,v5);
		g.addAresta(15,v4,v5);
		g.addAresta(6,v4,v6);
		g.addAresta(8,v5,v6);
		g.addAresta(9,v5,v7);
		g.addAresta(11,v6,v7);

		Dijkstra d = new Dijkstra();	

		d.dijkstra(g,v4,v5);
	}
}
