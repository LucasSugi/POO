/*
 * Classe principal que será responsável por fazer o controle do(s) Imc's da(s) pessoa(s) 
 * Nome: Lucas Yudi Sugi
 * Número USP: 9293251
 */

public class Imc{

	public static void main(String[] args) throws Exception{
			
		double peso = 0,altura = 0;
		int op = 0;
		boolean executarPrograma = true, entradaCorreta = false;
		
		//Criação do objeto
		ObesidadePessoa ImcPessoa = new ObesidadePessoa();

		//Controle do menu
		while (executarPrograma == true){
			//Verificação da entrada do usuário
			while(entradaCorreta == false){
				try{
					//Informando o usuário para digitar seu peso	
					System.out.println("Digite seu peso em kg para calcular o seu IMC:");
			
					//Armazenando peso
					peso = EntradaTeclado.leInt();
					
					//Se a entrada for válida então outras intruções serão passadas
					entradaCorreta = true;	
				}
				catch(Exception e){
					System.out.println("Entrada inválida, por favor digite novamente");		
				}	
			}
			//Verificação da entrada do usuário
			entradaCorreta = false;
			while(entradaCorreta == false){
				try{
					//Informando o usuário para digitar seu peso e altura a fim de armazená-los	
					System.out.println("Digite sua altura em cm para calcular o seu IMC:");

					//Armazenando altura
					altura = EntradaTeclado.leInt();	
					
					//Se a entrada for válida então outras intruções serão passadas
					entradaCorreta = true;	
				}
				catch(Exception e){
					System.out.println("Entrada inválida, por favor digite novamente");		
				}
			}			

			//Armazenando peso e altura no objeto
			ImcPessoa.setPeso(peso);
			ImcPessoa.setAltura(altura);

			//Informando a pessoa da sua condição física
			ImcPessoa.defineObesidade();
			
			//Verificação da entrada do usuário
			entradaCorreta = false;
			while(entradaCorreta == false){
				try{
					//Verificando se o programa deve ser executado novamente ou não
					System.out.println("Para finalizar o programa digite 0, para calcular outro IMC digite qualquer outro número");
					//Armazenando a opção
					op = EntradaTeclado.leInt();
	
					//Se a entrada for correta outras intruções serão realizadas
					entradaCorreta = true;
				}
				catch(Exception e){
					System.out.println("Entrada inválida, por favor digite novamente");		
				}
			}

			//Verificando a opção
			if(op == 0){
				executarPrograma = false;
			}
			else{
				System.out.println();
			}
		}	
	}
}
