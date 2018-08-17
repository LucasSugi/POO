import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 * Classe responsável por ser um jogador de bozo.
 */
public class Player{
	
	//Atributos	
	private Socket gamer;
	private PrintStream output;
	private Scanner input;
	private int id;
	
	/**
	 * @param path IP a ser conectado.
	 * @param port Porta na qual se deve conectar.
	 * @param id ID do usuario.
	 */
	public Player(String path, int port, int id){
		try{
			System.out.println("Tentando realizar a conexão.");
			gamer = new Socket(path,port);
			this.id = id;
			System.out.println("Conexão realizada com sucesso.");
		} catch(Exception e){
			System.out.println("Não foi possível conectar ao servidor " + path + " com a porta " + port + ".");	
		}
	}
	
	/**
	 * Execucao do jogo.
	 */ 	
	public void play(){
		
		String s;
		int counter = 1;
		IABozo IA = new IABozo();

		//Preparando os objetos de io
		try{
			output = new PrintStream(gamer.getOutputStream());	
			input = new Scanner(gamer.getInputStream());
		} catch(Exception e) {}

		//Enviando o id	
		s = "I " + id;
		output.println(s);
		
		//Execucao da IA
		while(counter<=10){
			//Iniciando a rodada
			s = "R" + counter;
			output.println(s);
		
			//Recebe os dados e escolhe a melhor configuracao
			s = input.nextLine();
			s = IA.posExt2(s);
			output.println(s);

			//Recebe os dados e escolhe a melhor configuracao
			s = input.nextLine();
			s = IA.rolar(s);
			output.println(s);

			//Escolhendo o melhor lugar para o placar
			s = input.nextLine();
			s = IA.add(s,counter);

			//Escolhendo o placar
			output.println(s);
			input.nextLine();

			counter++;
		}
		
		//Finalizando o jogo
		output.println("F");
		input.nextLine();
		input.nextLine();
		input.nextLine();
		System.out.println(input.nextLine());

		//Desconectando o jogador
		try{
			input.close();
			output.close();
			gamer.close();
		} catch(Exception e) {}
	}	
}
