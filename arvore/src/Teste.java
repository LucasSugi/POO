public class Teste{

	static public void main(String[] args){
		
		Arvore arv = new Arvore(100);	

		arv.add(120);
		arv.add(190);
		arv.add(110);
		arv.add(50);
		arv.add(10);
		arv.add(200);
		arv.add(115);
		arv.add(116);
		arv.add(60);
		arv.add(300);
	
		arv.printArvore();
	}
}
