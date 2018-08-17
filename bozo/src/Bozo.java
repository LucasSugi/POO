/**
* Classe principal responsavel por controlar o jogo Bozo
* Nela irá se encontrar os objetos RolaDados e Placar que serao
* utilizados de maneira auxiliar para a efetivacao do jogo
* @author Sugi
*/
 
public class Bozo{

	public static void main(String[] args) {
		
		String comeco = null, quaisDados = null;
		int rodada = 0, jogada = 0, pos = 0;
		int[] dadosAtuais = new int[5];
		boolean entradaValida = false;
				

		/*Criacao dos objetos*/
		RolaDados dados = new RolaDados(5);		
		Placar placar = new Placar();
		
		/*O jogo dura 10 rodadas, para isso um laco while sera utilizado como controle*/
		while(rodada++<10){
			
			/*Informando o usuario para comecar a rodada*/		
			System.out.println("Aperte enter para inicar a rodada");

			/*Verificando se o usuario ira entrar com o valor certo*/	
			while(entradaValida == false){
				/*Informando o usuário para entrar com o enter para iniciar a rodada*/
				try{
					comeco = EntradaTeclado.leString();	
					entradaValida = true;
				}
				catch(Exception e){
					System.out.println("Valor digitado inválido. Por favor digite novamente");
				}
			}
			entradaValida = false;

			/*Rolando os dados*/
			dados.rolar();
				
			/*Mostrando o resultado*/
			System.out.print("Esses são os dados atuais: \n" + dados.toString());
			
			while(jogada++ < 2){		
				/*Informando o usuário que deve entrar com uma sequencia de dados*/
				System.out.println("Informe quais os dados que você deseja rolar");
				
				/*Verificando se a entrada e' valida*/		
				while(entradaValida == false){
					try{
						/*Armazenando os dados que devem ser rolados*/
						quaisDados = EntradaTeclado.leString();	
						entradaValida = true;
					}
					catch(Exception e){
						System.out.println("Entrada inválida. Por favor digite novamente");
					}
				}
				entradaValida = false;			
				
				/*Qubbra de linha*/
				System.out.println("");
	
				/*Rolar os dados que o usuário informou*/
				dadosAtuais =  dados.rolar(quaisDados);
		
				/*Mostrando os dados apos a rolagem*/
				System.out.println("Esses são os dados atuais: \n" + dados.toString());
				
			}
			jogada = 0;

			/*Mostrando o placar atual*/
			System.out.println("Esse é o placar atual: \n" + placar.toString());
	
			/*Informando o usuario para digitar a posicao em que se quer armazenar a pontuacao*/
			System.out.println("\nDigite a posição em que se deve armazenar a sua pontuação");
		
			/*Verificando se a entrada digitada pelo usuario e' valida*/	
			while(entradaValida == false){
				try{
					/*Armazenando a posicao*/
					pos = EntradaTeclado.leInt();	
					if(pos<1 || pos>10){
						System.out.println("Posição digitada inválida. Por favor digite novamente");	
					}
					else{
						entradaValida = true;
					}
				}
				catch(Exception e){
					System.out.println("Entrada inválida. Por favor digite novamente");
				}
			}
			entradaValida = false;		

			/*Armazenando a pontuacao na posicao*/
			placar.add(pos,dadosAtuais);
			
			/*Quebra de linha*/
			System.out.println("");

			/*Mostrar o placar atualizado*/
			System.out.println(placar.toString());

			/*Quebra de linha*/
			System.out.print("\n\n");
		}

		/*Informando o usuario que o jogo acabou*/
		System.out.println("O jogo acabou. Essa foi a sua pontuação final:\n");
		
		/*Mostrar o placar atualizado*/
		System.out.println(placar.toString());
	}
}
