public class Vertice{
	
	//Atributos
	private int valor;
	private Vertice dir;
	private Vertice esq;

	//Construtor
	public Vertice(int valor){
		this.valor = valor;
		this.dir = null;
		this.esq = null;
	}

	
	//Seta um novo valor no vertice
	public void setValor(int valor){
		this.valor = valor;
	}
	
	//Seta um filho a esq
	public void setEsq(int valor){
		esq = new Vertice(valor);
	}
	
	//Seta um filho a dir
	public void setDir(int valor){
		dir = new Vertice(valor);
	}

	//Retorna o filho da esq
	public Vertice filhoEsq(){
		return esq;
	}
	
	//Retorna o filho da dir
	public Vertice filhoDir(){
		return dir;
	}

	//Retorna o valor contido no vertice
	public int getValor(){
		return valor;
	}	
}
