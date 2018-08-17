/*
 * Classe responsável por gerar os valores da megasena
 * Nome: Lucas Yudi Sugi
 * Número USP: 9293251
 */

public class MegaSena{


	public static void main(String[] args) throws Exception {
		
		int i;
		int randomNumber, semente;

		//Informando o usuário para digitar um valor na finalidade de gerar uma semente
		System.out.print("Digite um inteiro para usá-lo na criação da semente: ");
				
		//Armazenando a semente digitada pelo usuário
		semente = EntradaTeclado.leInt();
	
		//Criação do objeto Random e inicializando uma nova semente
		Random rand = new Random(semente);
		
		//Informando o usuário
		System.out.print("Esses são os números gerados para a sua Megasena: ");
		
		//Geração dos valores
		for(i=0;i<6;i++){
			randomNumber = rand.getIntRand(60) + 1;	
			System.out.print(randomNumber + " ");
		}
		System.out.println();
	}
}
