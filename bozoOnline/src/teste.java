public class teste extends Thread{
	
	public void run(){
	
		Player player;

		for(int i=0;i<50;i++){
			player = new Player("127.0.0.1",9669,9293251);
			player.play();
		}
	}

	static public void main(String[] args){
	
		teste[] t = new teste[100000];
		for(int i=0;i<100000;i++) { 
			t[i] = new teste();
			t[i].start(); 
		}
	}
}
