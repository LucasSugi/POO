public class Hello extends Thread{
	
	private int n;

	public Hello(int n){
		this.n = n;
	}

	
	public void run (){
		System.out.println("Hello world1 " + n);		
		System.out.println("Hello world2 " + n);		
	}

	static public void main(String[] args){
		
		int i;

		Hello[] vetor = new Hello[10];	
		for(i=0;i<10;i++){
			vetor[i] = new Hello(i);
		}

		for(i=0;i<10;i++){
			vetor[i].start();
		}
		System.out.println("Fim da thread principal");
	}
}
