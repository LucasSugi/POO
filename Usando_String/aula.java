
public class aula{


	public static void main(String[] args) throws Exception{
		
		int i;
		int counterA = 0;
		int counterE = 0;
		int counterI = 0;
		int counterO = 0;
		int counterU = 0;

		//Informando o usuário para digitar uma frase
		System.out.println("Digite alguma coisa: ");

		//Criação do objeto que irá ler a string
		String palavra1  = EntradaTeclado.leString();
		
		//Verificando quantidade de vogais		
		for(i=0;i<palavra1.length();i++){
			if(palavra1.charAt(i) == 'a' || palavra1.charAt(i) == 'A'){
				counterA++;
			}
			else if(palavra1.charAt(i) == 'e' || palavra1.charAt(i) == 'E'){
				counterE++;
			}
			else if(palavra1.charAt(i) == 'i' || palavra1.charAt(i) == 'I'){
				counterI++;
			}
			else if(palavra1.charAt(i) == 'o' || palavra1.charAt(i) == 'O'){
				counterO++;
			}
			else if(palavra1.charAt(i) == 'u' || palavra1.charAt(i) == 'U'){
				counterU++;
			}
		}
		
		//Informando a quantidade de vogais
		System.out.println("Quantidade de vogais a: " + counterA);
		System.out.println("Quantidade de vogais e: " + counterE);
		System.out.println("Quantidade de vogais i: " + counterI);
		System.out.println("Quantidade de vogais o: " + counterO);
		System.out.println("Quantidade de vogais u: " + counterU);
	
		//Quebra de linha
		System.out.println();
	
		//Impressão da string em maiúscula
		System.out.println("String convertida para maiúscula: " + palavra1.toUpperCase());
			
		//Quebra de linha
		System.out.println();

		//Pedindo outra string para o usuário
		System.out.println("Digite outra frase: ");

		//Armazenando a frase
		String palavra2 = EntradaTeclado.leString();	

		//Verificando se a frase está contida na outra
		int estaContida = palavra1.indexOf(palavra2);
			
		if(estaContida == -1){
			System.out.println("A string não está contida.");		
		}
		else{
			System.out.println("A string está contida.");		
		}
	}

}
