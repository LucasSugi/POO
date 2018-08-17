/*
 * Classe responsável por gerar dois valores aleatórios 
 * Nome: Lucas Yudi Sugi
 * Número USP: 9293251
 */

public class TwoRandomNumber{


	public static void main(String[] args) throws Exception {
		
		int i;
		int randomNumber1 = 0, randomNumber2 = 0, semente1 = 0, semente2 = 0;
		int contador = 1;
		boolean numeroIgual = false, entradaCorreta = false;
		
		//Criação do objeto Random
		Random rand1 = new Random();

		//Criação do outro objeto
		Random rand2 = new Random();
		
		//Criação do outro objeto
		Random rand3 = new Random();
			
		//Verificando se a entrada é correta
		while(entradaCorreta == false){
			try{
				//Informando o usuário para digitar um valor na finalidade de gerar uma semente
				System.out.print("Digite um inteiro para usá-lo na criação da primeira semente: ");
			
				//Armazenando a primeira semente digitada pelo usuário
				semente1 = EntradaTeclado.leInt();
		
				//Se a entrada é correta então outras intruções serão executadas
				entradaCorreta = true;
					
				//Setando a nova semente
				rand1.setSemente(semente1);
			}
			catch(Exception e){
				//Informando o usuário que sua entrada é inválida
				System.out.println("Entrada inválida, por favor digite novamente");
			}

		}
		//Verificando se a entrada é correta
		entradaCorreta = false;
		while(entradaCorreta == false){
			try{
				//Informando o usuário para digitar um valor na finalidade de gerar uma semente
				System.out.print("Digite um inteiro para usá-lo na criação da segunda semente: ");

				//Armazenando a segunda semente digitada pelo usuário
				semente2 = EntradaTeclado.leInt();
			
				//Se a entrada é correta então outras intruções serão executadas
				entradaCorreta = true;
				
				//Setando a nova semente
				rand2.setSemente(semente2);
			}
			catch(Exception e){
				//Informando o usuário que sua entrada é inválida
				System.out.println("Entrada inválida, por favor digite novamente");
			}
		}
		
		//Geração dos valores
		while(numeroIgual == false){
			//Gerando primeiro valor aleatório
			randomNumber1 = rand1.getIntRand(500) + 1;
			
			//Gerando segundo valor aleatório
			randomNumber2 = rand2.getIntRand(500) + 1;
				
			//Verificando se os valores gerados são iguais
			if(randomNumber1 == randomNumber2){
				System.out.println("As duas sementes conseguiram gerar um valor igual após " + contador + " iterações");
				System.out.println("O valor gerado foi: " + randomNumber1);
				System.out.println();
				numeroIgual = true;		
			}
			else{
				contador++;
			}
		}
		
		//Geração dos valores
		numeroIgual = false;
		contador = 1;
		while(numeroIgual == false){
			//Gerando primeiro valor aleatório
			randomNumber1 = rand1.getIntRand(500) + 1;
			
			//Gerando segundo valor aleatório
			randomNumber2 = rand3.getIntRand(500) + 1;
				
			//Verificando se os valores gerados são iguais
			if(randomNumber1 == randomNumber2){
				System.out.println("A sua primeira semente e a semente do sistema geraram um valor igual após " + contador + " iterações");
				System.out.println("O valor gerado foi: " + randomNumber1);
				System.out.println();
				numeroIgual = true;		
			}
			else{
				contador++;
			}
		}
			
		//Geração dos valores
		numeroIgual = false;
		contador = 1;
		while(numeroIgual == false){
			//Gerando primeiro valor aleatório
			randomNumber1 = rand2.getIntRand(500) + 1;
			
			//Gerando segundo valor aleatório
			randomNumber2 = rand3.getIntRand(500) + 1;
				
			//Verificando se os valores gerados são iguais
			if(randomNumber1 == randomNumber2){
				System.out.println("A sua segunda semente e a semente do sistema geraram um valor igual após " + contador + " iterações");
				System.out.println("O valor gerado foi: " + randomNumber1);
				numeroIgual = true;		
			}
			else{
				contador++;
			}
		}
		
	}
}
