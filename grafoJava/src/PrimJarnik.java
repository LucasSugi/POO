import java.util.*;

public class PrimJarnik{
	
	//Atributos
	private ArrayList<Vertice> lista;	
	final int DENTRO = 1;
	final int FORA = 0;

	//Construtor
	public PrimJarnik(){
		lista = new ArrayList<Vertice>();
	}

	//Algoritmo PrimJarnik
	public void primJarnik(Grafo g, Vertice v){
		
		int i;	
		Vertice[] listV;
		Vertice w,y;
		Aresta[] a;

		//O vertice incial tem distancia 0	
		v.setDist(0);

		//O vertice inicial esta dentro da nuvem
		v.setRotulo(DENTRO);	

		//Inserir todos os vertices na lista
		listV = g.vertices();
		for(i=0;i<g.getnV();i++){
			lista.add(listV[i]);
		}
	
		//Instanciando o objeto para comparacao
		Comparar cmp = new Comparar();
		lista.sort(cmp);	

		//Enquanto houver itens na lista rode
		while(lista.size() != 0){
				
			w = lista.remove(0);

			//Mudando o rotulo do vertice a ser analisado
			w.setRotulo(DENTRO);

			//Recebendo todas as arestas incidentes de w
			a = g.incidentAresta(w);
			
			i = 0;
			while(a[i++] != null){
				
				y = g.opposite(a[i-1],w);	

				if(y.getRotulo() != DENTRO && y.getDist() > a[i-1].getAresta()){
					y.setDist(a[i-1].getAresta());
					lista.sort(cmp);
				}
			}
		}
	}
}

class Comparar implements Comparator<Vertice>{
	
	@Override
	public int compare(Vertice v1, Vertice v2){
		
		if(v1.getDist() > v2.getDist()){
			return 1;
		}
		else if(v1.getDist() == v2.getDist()){
			return 0;
		}
		return -1;
	}
}
