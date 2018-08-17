import java.util.*;

public class Grafo{
		
	//Atributos
	private int nV,nA;
	private Vertice listV;
	private Aresta listA;

	//Construtor
	public Grafo(){
		nV = nA = 0;
		listV = new Vertice();
		listA = new Aresta();
	}

	//Adiciona um vertice no grafo
	public Vertice addVertice(char valor){
		//Cria um novo vertice
		Vertice novo = new Vertice();	
		//Armazena o valor nele
		novo.setVertice(valor);
		//Adiciona ele na lista
		listV.add(novo);
		//Aumentando a quantidade de vertices
		nV++;
		//Retornando o vertice criado
		return novo;
	}
	
	//Retorna a quantidade de vertices do grafo
	public int getnV(){
		return nV;
	}
	
	//Retorna a quantidade de arestas do grafo
	public int getnA(){
		return nA;
	}

	//Retorna os vertices finais da aresta
	public Vertice[] endVertices(Aresta a){
		return a.endVertice();		
	}

	//Retorna o vertice oposto da aresta
	public Vertice opposite(Aresta a, Vertice v){
		return a.opposite(v);
	}

	//Atualiza o conteudo do vertice
	public void replaceVertice(Vertice v,char valor){
		v.setVertice(valor);	
	}

	//Atualiza o conteudo da aresta
	public void replaceAresta(Aresta a, int valor){
		a.setAresta(valor);
	}
	
	//Retorna todas as arestas incidentes de v
	public Aresta[] incidentAresta(Vertice v){
		
		int i,j;
		Aresta[] a,list1;
		Vertice[] list2;

		//Recebendo todas as arestas do grafo
		a = arestas();		
		
		//Inicializando	
		list1 = new Aresta[nA + 1];
		for(i=0;i<nA;i++){
			list1[i] = null;
		}

		j = 0;
		for(i=0;i<nA;i++){
			list2 = a[i].endVertice();	
			if(list2[0] == v || list2[1] == v){
				list1[j++] = a[i];
			}
		}
	
		return list1;
	}

	//Imprime o conteudo de todos os vertices
	public void imprimeVertice(){
		
		Vertice v;
		Iterator<Vertice> i = listV.iterator();

		while(i.hasNext()){
			v = i.next();
			System.out.println(v.getVertice());
		}
	}

	//Imprime o conteudo de todas as arestas
	public void imprimeAresta(){
		
		Aresta a;
		Iterator<Aresta> i;

		i = listA.iterator();
		while(i.hasNext()){
			a = i.next();
			System.out.println(a.getAresta());
		}	
	}
	
	//Retorna todas as aretas
	public Aresta[] arestas(){
		
		int j = 0;
		Aresta[] a = new Aresta[nA];
		Iterator<Aresta> i;

		i = listA.iterator();
		while(i.hasNext()){
			a[j] = i.next();	
			j++;
		}

		return a;
	}

	//Verifica se dois vertices sao adjascentes
	public boolean areAdjacent(Vertice v1, Vertice v2){
		
		Aresta[] a;
		Vertice[] v;
		
		//Recebe todas as arestas
		a = arestas();

		//Verifica em todas as arestas se v1 e v2 sao adjacentes
		for(int i=0;i<nA;i++){
			v = a[i].endVertice();
			if( (v[0] == v1 && v[1] == v2) || (v[0] == v2 && v[1] == v1)){
				return true;
			}
		}
		return false;
	}

	//Remove um vertice
	public void removeVertice(Vertice v){
			
		int i;
		Vertice[] list;
		
		//Recebendo o conjunto de todos os vertices	
		list = vertices();

		for(i=0;i<nV;i++){
			if(list[i] == v){
				break;
			}
		}

		listV.remove(i);	
	}	
	
	//Remove uma aresta
	public void removeAresta(Aresta a){
		
		int i;
		Aresta[] list;	

		//Recebendo o conjunto de arestas
		list = arestas();

		for(i=0;i<nA;i++){
			if(list[i] == a){
				break;
			}	
		}
		
		a.addVertice(null,null);
		listA.remove(i);
	}

	//Retorna uma referência para todos os vertices
	public Vertice[] vertices(){
		
		Vertice[] list = new Vertice[nV];
		int j = 0;
			
		Iterator<Vertice> i = listV.iterator();
		Vertice v;

		while(i.hasNext()){
			list[j] = i.next();	
			j++;
		}
		
		return list;
	}

	//Adiciona uma aresta no grafo
	public Aresta addAresta(int valor, Vertice v1, Vertice v2){
		//Cria uma nova aresta
		Aresta novo = new Aresta();
		//Armazena o valor na aresta
		novo.setAresta(valor);
		//Armazena os vertices na aresta
		novo.addVertice(v1,v2);	
		//Adiciona a aresta na lista
		listA.add(novo);
		//Aumentando a quantidade de arestas
		nA++;
		//Retorna a nova aresta
		return novo;
	}
}
