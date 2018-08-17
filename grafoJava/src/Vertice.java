import java.util.*;

public class Vertice extends Vector<Vertice>{
	
	//Atributos
	private char valor;
	private int rotulo;
	private double dist;
	private Vertice pai;
	
	//Construtor
	public Vertice(){
		valor = '\0';
		rotulo = 0;
		pai = null;
		dist = 1000000000;
	}
	
	//Armazena um novo pai
	public void setPai(Vertice v){
		pai = v;
	}

	//Armazena um novo rotulo
	public void setRotulo(int rotulo){
		this.rotulo = rotulo;
	}
	
	//Armazena um nova distancia
	public void setDist(double dist){
		this.dist = dist;
	}

	//Armazena o valor contido no vertice
	public void setVertice(char valor){
		this.valor = valor;
	}

	//Retorna o pai armazenado
	public Vertice getPai(){
		return pai;
	}
	
	//Retorna o conteudo da distancia
	public double getDist(){
		return dist;
	}

	//Retorna o conteudo do vertice
	public char getVertice(){
		return valor;
	}

	//Retorna o rotulo atual
	public int getRotulo(){
		return rotulo;
	}
}
