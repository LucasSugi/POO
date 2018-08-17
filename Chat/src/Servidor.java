import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor{
	
	//Atributos
	private ServerSocket ss;
	private Socket cliente1;
	private Socket cliente2;

	//Construtor
	public Servidor(int port){
		//Reservando uma porta do sistema para o servidor 
		try{	ss = new ServerSocket(port);
			//Mensagem
			System.out.println("A porta " + port + " foi aberta.");
		}catch(Exception e){
			System.out.println("A porta " + port + " já está reservada pelo sistema.");
		}
	}

	public void conexao(){
		
		Scanner entrada = new Scanner(System.in);

		//Esperando conecxao
		try{
			System.out.println("Esperando pela primeira conexão...");	
			cliente1 = ss.accept();
			System.out.println("Conexão estabelecida.");
			System.out.println("Esperando pela segunda conexão...");	
			cliente2 = ss.accept();
			System.out.println("Conexão estabelecida.");
			Msn msn1 = new Msn(cliente1,cliente2);
			Msn msn2 = new Msn(cliente2,cliente1);
			msn1.start();
			msn2.start();

		} catch(Exception e){
			System.out.println("Falha ao tentar estabelecer a conexão.");	
		}
		
		//Finalizar o servidor	
		while(true){	
			if(entrada.nextLine().equals("quit")){
				break;
			}
		}
	}

	static public void main(String[] args){
		
		Servidor servidor = new Servidor(2525);	
		servidor.conexao();
	}
}

class Msn extends Thread{
	
	//Atributos
	private Socket clienteIn;
	private Socket clienteOut;
	private Scanner entrada;
	private PrintStream saida;

	//Construtor	
	public Msn(Socket cliente1, Socket cliente2){
		this.clienteIn = cliente1;
		this.clienteOut = cliente2;
	}
	
	public void run(){
		
		String s;

		//Criandos os objetos de io
		try{
			entrada = new Scanner(clienteIn.getInputStream());
			saida = new PrintStream(clienteOut.getOutputStream());
		} catch(Exception e){
		
		}
		
		//Esperando por dados		
		while(entrada.hasNextLine()){
			s = entrada.nextLine();
			saida.println(s);
		}	
	}
}
