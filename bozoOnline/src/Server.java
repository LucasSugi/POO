import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 * Classe responsável por iniciar o servidor.
 */
public class Server{
	
	//Atributos
	private ServerSocket ss;

	/**
	 * @param port Porta na qual o servidor deve ser criado.
	 */
	public Server(int port){
		try{
			System.out.println("Conectando com a porta " + port + ".");
			ss = new ServerSocket(port);	
			System.out.println("Conexão bem sucedida.");
		} catch (Exception e){
			System.out.println("A porta " +  port + " já esta sendo utilizada.");
		}
	}
	
	/**
	 * Conecta um usuário ao servidor.
	 */	
	public void connect(){
		
		Socket client;
		BozoOnline[] bozo,aux;
		int counter = 0, limit = 100,i;

		//Inicialmente ha suporte para 100 cliente
		bozo = new BozoOnline[100];

		//Controle do servidor
		ControlServer control = new ControlServer(ss,bozo);
		control.start();

		while(true){
			//Esperando uma conexao	
			try{
				System.out.println("Esperando conexão..");
				client = ss.accept();	
				System.out.println("Conexão estabelecida.");
				bozo[counter] = new BozoOnline(client);	
				bozo[counter].start();
				counter++;
				if(counter == limit){
					aux = new BozoOnline[counter+100];		
					for(i=0;i<counter;i++){
						aux[i] = bozo[i];
					}
					bozo = null;
					bozo = aux;
					limit += 100;
				}	
			} catch(Exception e){
				if(control.getStop() != 1) System.out.println("Falha ao tentar se conectar com o usuário.");
			}

			if(control.getStop() == 1) {
				return;
			}
		}
	}
	
	/**
	 * Inicia o servidor.
	 * @param args Argumentos.
	 */
	static public void main(String[] args){
		
		Server server = new Server(9669);	
		server.connect();	
	}
}

/**
 * Classe responsável por realizar o controle do servidor.
 *
 */
class ControlServer extends Thread{
	
	//Atributos
	private ServerSocket ss;
	private BozoOnline[] bozo;
	private int stop;

	/**
	 * @param ss Servidor que esta sendo executado.
	 * @param bozo Vetor contendo os clientes conectados no servidor.
	 */
	public ControlServer(ServerSocket ss, BozoOnline[] bozo){
		this.ss = ss;
		this.bozo = bozo;
		this.stop = 0;
	}
	
	/**
	 * Flag que indica parada.
	 */	
	public int getStop(){
		return stop;
	}

	/**
	 * Finaliza o servidor.
	 */
	public void run(){
		
		Scanner input = new Scanner(System.in);	
		String s;

		while(true){
			s = input.nextLine();	
			if(s.equals("quit")) {
				stop = 1;
				input.close();
				finalize();
				break;
			}
		}
	}

	/**
	 * Finaliza a execucao do servidor.
	 */
	public void finalize(){
		
		Socket client;

		try{
			ss.close();
			sleep(1000);	
			for(int i=0;i<BozoOnline.size;i++){
				bozo[i].exit();	
			}
		} catch(Exception e){
		
		}

	}
}
