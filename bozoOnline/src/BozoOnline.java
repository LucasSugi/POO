import java.io.*;
import java.net.*;
import java.util.Scanner;

public class BozoOnline extends Thread{
	
	//Atributos
	private Socket client;
	private PrintStream output;
	private Scanner input;
	private RolaDados dados;
	private Placar placar;
	private int id,flag,score,game;
	private int[] dadosAtuais;
	public static int size;
	
	
	/**
	 * @param client Jogador do bozo.
	 */
	public BozoOnline(Socket client){
		this.client = client;
		dados = new RolaDados(5);
		placar = new Placar();
		flag = 0;
		game = 1;
		score = 0;
		size++;
	}
	
	/**
	 * Executa o bozo online para o cliente conectado na rede.
	 */
	public void run(){
		
		String s,test = "R";
		boolean[] dices;
		int move;

		//Preparando os objetos
		try{
			output = new PrintStream(client.getOutputStream());
			input = new Scanner(client.getInputStream());
		} catch(Exception e) {}

		//Mensagem para o cliente perguntando seu ID
		try{
			s = input.nextLine();
			if(s.charAt(0) == 'I'){
				id = Integer.parseInt(s.substring(2,s.length()));
			}
			else{
				placar.setPlacar();
				exit();	
			}
	
			while(game<=10){
				//Usuario deve inicar a rodada
				s = input.nextLine();
				test = "R" + game;	
				if(s.equals(test)){

					//Rola os dados
					dadosAtuais = dados.rolar();
					s = convertToString(dadosAtuais);

					//Envia os dados para o usuario
					output.println(s);
					
					move = 0;
					while(move++<2){
						//Recebe os dados do usuario
						s = input.nextLine();
						if(s.charAt(0) == 'T'){
							dices = convertToBoolean(s.substring(1,s.length()));
							dadosAtuais = dados.rolar(dices);
							s = convertToString(dadosAtuais);
							output.println(s);
						}
						else{
							placar.setPlacar();
							exit();
						}
					}

					//Entrada do usuario indicando o a posicao do placar
					s = input.nextLine();
					test = "P" + game + " ";
				       	if(game<10){
						if(s.substring(0,3).equals(test)){
							placar.add((Integer.parseInt(s.substring(3,s.length()))),dadosAtuais);	
							output.println("Seu score atual: " + placar.getScore());
						}
						else{					
							placar.setPlacar();
							exit();	
						}
					}
					else{
						if(s.substring(0,4).equals(test)){
							placar.add((Integer.parseInt(s.substring(4,s.length()))),dadosAtuais);	
							output.println("Seu score atual: " + placar.getScore());
						}
						else{
							placar.setPlacar();
							exit();	
						}
					}
				}
				else{
					placar.setPlacar();
					exit();	
				}
				game++;
			}

			s = input.nextLine();
			if(s.charAt(0) != 'F'){
				placar.setPlacar();
			}
			exit();	

		}catch(Exception e) {}
	}

	/**
	 * Retorna um cliente.
	 * @return O socket cliente armazenado.
	 */
	 public Socket getClient(){
		return client; 
	 }	
	
	 /**
	  * Finaliza a execucao do cliente.
	  */
	 public void exit(){
		if(flag  == 0){	
		 	try{
				output.println("\nO servidor está finalizando a sua execução.");
				score = placar.getScore();
				output.println("\nEsse foi o seu placar final: " + score + ". Apos " + (game-1) + " jogadas.");
				client.close();
				input.close();
				output.close();
				flag = 1;
			} catch(Exception e) {}
		}
	 }
	
	/**
	 * Converte os dados rolados para uma string.
	 * @param vector  Vetor contendo os dados.
	 * @return String com as faces dos dados.
	 */
	public String convertToString(int[] vector){
		String s = "";
		for(int i=0;i<vector.length;i++){
			s += vector[i];	
			s += " ";
		}
		return s;	
	}

	/**
	 * Converte os dados rolados para booleano.
	 * @param s String contendo a representacao dos dados.
	 * @return Vetor de booleano contendo as informacoes de quais dados devem ser rolados(true) ou nao(false).
	 */
	public boolean[] convertToBoolean(String s){
		boolean[] dices = new boolean[5];
		int i,j;
			
		j = 0;
		for(i=0;i<s.length();i++){
			if(s.charAt(i) == '1'){
				dices[j++] = true;		
			}
			else if(s.charAt(i) == '0'){
				dices[j++] = false;
			}
		}
		
		return dices;	
	}
}
