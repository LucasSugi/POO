/*
 * Classe que tem como principal finalidade informar se uma pessoa está com obesidade ou não
 * Nome: Lucas Yudi Sugi
 * Número USP: 9293251
 */

public class ObesidadePessoa{
	
	//Atributos da classe ObesidadePessoa
	private double peso;
	private double altura;

	//Método para atualizar o peso
	public void setPeso(double novoPeso){
		peso = novoPeso;	
	}

	//Método para atualizar a altura
	public void setAltura(double novaAltura){
		altura = novaAltura / 100 ;
	}

	//Método para retornar o peso atual
	public double getPeso(){
		return peso;
	}	

	//Método para retornar o altura atual
	public double getAltura(){
		return altura;
	}

	//Método para IMC da pessoa
	public double calculaIMC(){

		double peso;
		double altura;
		
		//Recebendo o peso atual
		peso = getPeso();

		//Recebendo o altura atual
		altura = getAltura();

		return peso / (altura * altura);
	}	
	
	//Método para definir se a pessoa tem obesidade ou não
	public void defineObesidade(){
		
		double imc;
		
		//Recebendo o icm da pessoa
		imc = calculaIMC();	
		
		//Fazendo a verificação da condição física da pessoa
		if(imc > 25){
			System.out.println("Risco de obesidade");
		}
		else{
			System.out.println("Não há risco de obesidade");
		}
	}
}
