import java.util.*;

public class Aresta extends Vector<Aresta>{
	
	//Atributos
	private int valor;
	private int rotulo;
	private Vertice v1;
	private Vertice v2;

	//Construtor
	public Aresta(){
		valor = 0;
		rotulo = 0;
	}
	
	//Armazena um novo rotulo
	public void setRotulo(int rotulo){
		this.rotulo = rotulo;
	}
		
	//Retorna o rotulo atual
	public int getRotulo(){
		return rotulo;
	}

	//Armazena um conteudo na aresta
	public void setAresta(int valor){
		this.valor = valor;
	}

	//Adiciona os vértices finais da aresta
	public void addVertice(Vertice v1, Vertice v2){
		this.v1 = v1;	
		this.v2 = v2;	
	}
	
	//Retorna os vertices finais da aresta
	public Vertice[] endVertice(){
		
		Vertice v[] = new Vertice[2];	

		v[0] = v1;
		v[1] = v2;

		return v;
	}

	//Retorna o vertice oposto da aresta
	public Vertice opposite(Vertice v){
		
		if(v == v1){
			return v2;
		}
		return v1;	
	}

	//Retorna o conteudo da aresta
	public int getAresta(){
		return valor;
	}

	//Imprime o conteudo dos vertices finais
	public void imprimeVertice(){
		System.out.println(v1.getVertice() + " " + v2.getVertice());
	}
}
