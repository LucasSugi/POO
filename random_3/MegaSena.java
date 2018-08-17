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
			try{
				randomNumber = rand.getIntRand(i*i,60);	
				System.out.print(randomNumber + " ");
			}
			catch(Exception e){
				System.out.println("O valor digitado é inválido");
			}
		}
		System.out.println();
	}
}
