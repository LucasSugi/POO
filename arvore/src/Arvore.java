import java.util.*;

public class Arvore{
	
	//Atributos
	private int n;	
	private Vertice raiz;

	//Construtor
	public Arvore(int valor){
		n = 0;
		raiz = new Vertice(valor);
	}

	//Adicionar um elemento na arvore	
	public boolean add(int valor){
		n++;
		return addAux(raiz,valor);
	}

	//Funcao auxiliar para adicionar um vertice
	public boolean addAux(Vertice v, int valor){
	
		if(v.getValor() > valor){
			if(v.filhoEsq() == null){
				v.setEsq(valor);	
				return true;
			}	
			addAux(v.filhoEsq(),valor);
		}
		else if(v.getValor() < valor){
			if(v.filhoDir() == null){
				v.setDir(valor);
				return true;
			}
			addAux(v.filhoDir(),valor);
		}
		return false;
	}
	
	//Calcula a altura da arvore
	public int altura(){
		int alt = 0;
		return alturaAux(raiz,alt);	
	}

	//Funcao auxiliar responsavel por calcular a altura
	public int alturaAux(Vertice v, int alt){
		
		int retE, retD;

		retE = retD = -1;
		if(v.filhoEsq() != null){
			retE = alturaAux(v.filhoEsq(),alt);
		}	
		if(v.filhoDir() != null){
			retD = alturaAux(v.filhoDir(),alt);
		}
		if(v.filhoEsq() != v.filhoDir()){
			if(retE>retD){
				return retE + 1;	
			}
			return retD + 1;
		}
		return 1;
	}

	//Impressao da arvore
	public void printArvore(){
	
		LinkedList<Vertice> lista;
		Vertice v;
		int alt,i,nivel;
		int[] vector;

		lista = new LinkedList<Vertice>();	

		//Armazenando a altura da arvore
		alt = altura();

		//Adicionando a raiz na lista
		lista.add(raiz);

		//Vetor responsavel por indicar a quantidade de elementos em cada nivel
		vector = new int[alt];
		for(i=0;i<alt;i++){
			vector[i] = 0;
		}
		vector[0]++;

		i = 0;
		nivel = 0;
		while(i++<=n){
			v = lista.remove();
			System.out.print(v.getValor() + " ");		
			if(v.filhoEsq() != null) {
				lista.add(v.filhoEsq());	
				vector[nivel+1]++;
			}
			if(v.filhoDir() != null) {
				lista.add(v.filhoDir());	
				vector[nivel+1]++;
			}
			vector[nivel]--;
			if(vector[nivel] == 0){
				System.out.println();
				nivel++;
			}
		}
	}
}
