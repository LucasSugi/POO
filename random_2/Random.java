/*
 * Classe responsável por gerar valores aleatórios
 * Nome: Lucas Yudi Sugi
 * Número USP: 9293251
 */

import java.util.Calendar;

public class Random{
	
	//Parâmetros da geração do número randomico
	private long p = 2147483648l;	
	private long m = 843314861;	
	private long a = 453816693;
	
	//Parâmetro para a semente
	private long xi;

	//Construtor sem parâmetro
	public Random(){
		//Criação do objeto
		Calendar calendar = Calendar.getInstance();
		//Setando a semente
		xi = calendar.getTimeInMillis() % p;
	}
		
	//Método para gerar valores aleatórios
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

	//Método para gerar valores aleatórios entre [0,max] em que m será fornecido
	public int getIntRand(int max){
		
		double random;
		
		//Gerando um valor randomico entre 0 e 1		
		random = getRand();

		//Valor aleatório em inteiro	
		random *= max;
	
		return (int)random;
	}	

	//Método para setar uma nova semente
	public void setSemente(int semente){
		xi = semente;
	}
}
