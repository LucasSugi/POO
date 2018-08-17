/**
* Classe responsável por calcular verificar se uma mulher possui obesidade ou não
* @author Sugi
*/

public class PessoaMulher extends ObesidadePessoa {
	
	
	/**Armazena o peso, altura e idade da pessoa inicialmente*/
	public PessoaMulher(double peso, double altura, int idade){
		super(peso,altura,idade);
	}
	
	/**Classifica a pessoa segundo o seu imc*/	
	public String classificaObesidade(){
		
		/*Calcula o ICM*/
		double imc = calculaIMC();

		/*Verifica o tipo de icmc*/
		if(imc < 19.1) return "Abaixo do peso";
		else if(imc < 25.8) return "Peso normal";
		else if(imc < 27.3) return "Marginalmente acima do peso";
		else if(imc < 31.1) return "Acima do peso";
		return "Obeso";
	}
}
