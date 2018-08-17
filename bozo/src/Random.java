/**
 * Gerador simples de números aleatórios
 * @author Sugi
 */

import java.util.Calendar;

public class Random{
	
	//Parâmetros da geração do número randomico
	private long p = 2147483648l;	
	private long m = 843314861;	
	private long a = 453816693;
	
	//Parâmetro para a semente
	private long xi;

	/**Construtor sem parametro - A semente será gerada atraves da funcao Calendar.getInstance()*/
	public Random(){
		//Criação do objeto
		Calendar calendar = Calendar.getInstance();
		//Setando a semente
		xi = calendar.getTimeInMillis() % p;
	}
	
	/**Construtor com parametro - A semente será passada pelo usuário*/
	public Random(int k){
		xi = k;
	}
		
	/**Permite gerar um valor aleatório no intervalo [0,1)*/
	public double getRand(){
		
		double random; 

		//Cálculo do próximo xi
		xi = (a + (m * xi)) % p;
		
		//'Casting' 
		random = xi;
		
		//Restringindo o valor entre 0 e 1
		//Como xi recebeu mod de p, então basta dividiros por 'p' para obter um valor entre 0 e 1
		random /= p;
		
		return random;
	}

	/**Permite gerar valores aleatórios entre [0,max) em que max será fornecido*/
	public int getIntRand(int max){
		
		double random;
		
		//Gerando um valor randomico entre 0 e 1		
		random = getRand();

		//Valor aleatório em inteiro	
		random *= max;
	
		return (int)random;
	}	

	/**Permite setar uma nova semente*/
	public void setSemente(int semente){
		xi = semente;
	}
}
