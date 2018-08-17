import java.util.Scanner;
import java.io.*;
import java.net.*;

class Saida implements Runnable{

	private Socket cliente; 
	private Scanner entrada;

	public Saida(Socket cliente){
		this.cliente = cliente;
	}

	@Override
	public void run(){
		
		try{
			entrada = new Scanner(cliente.getInputStream());	
		} catch(Exception e) {}

		while(entrada.hasNextLine()){
			System.out.println("Mensagem recebida: " + entrada.nextLine());	
		}
	}
}

class Entrada implements Runnable{
	
	private PrintStream saida;
	private Socket cliente; 

	public Entrada(Socket cliente){
		this.cliente = cliente;
	}

	@Override
	public void run(){
		
		String s;
		Scanner entrada = new Scanner(System.in);
		try{
			saida = new PrintStream(cliente.getOutputStream());
		} catch(Exception e) {}
		
		//Esperando dados
		while(entrada.hasNextLine()){
			s = entrada.nextLine();
			if(s.equals("quit")){
				break;
			}
			saida.println(s);	
		}
	}
}

public class Chat{
	
	//Atributos
	private Socket cliente;	
	private PrintStream saida;

	//Construtor	
	public Chat(String path, int port){
		try{
			System.out.println("Estabelecendo conexão.");
			cliente = new Socket(path,port);	
			System.out.println("Conexão estabelecida.");
		} catch (Exception e){
			System.out.println("Falha ao tentar estabelecer a conexão");
		}
	}
	
	public Socket getCliente(){
		return this.cliente;
	}

	static public void main(String[] args) throws Exception{
		
		Chat chat = new Chat("127.0.0.1",2525);
		Saida s = new Saida(chat.getCliente());
		Entrada e = new Entrada(chat.getCliente());
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(e);
		t1.start();
		t2.start();
	}
}
