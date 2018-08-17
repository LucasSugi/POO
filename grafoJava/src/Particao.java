import java.util.*;

public class Particao extends Vector<Vertice>{
	
	//Atributos
	private int rotulo;	
	private static int add = 0;
	
	//Construtor
	public Particao(){
		rotulo = add++;
	}

	//Retorna o rotulo da particao
	public int getRotulo(){
		return rotulo;
	}

	//Concatena duas particoes
	public void concat(Particao p){
		
		Vertice v;
		Iterator<Vertice> i;
	
		//Objeto de iteracao
		i = p.iterator();	
		
		//Armazenando os elementos de p
		while(i.hasNext()){
			v = i.next();
			v.setRotulo(rotulo);
			add(v);
		}
	}

	//Retorna os vertices armazenados
	public Vertice[] retain(){
	
		int j = 0;
		Vertice[] v;
		Iterator<Vertice> i;
	
		v = new Vertice[size() + 1];

		i = iterator();
		while(i.hasNext()){
			v[j++] = i.next(); 
		}
		v[j] = null;
		return v;
	}
}
