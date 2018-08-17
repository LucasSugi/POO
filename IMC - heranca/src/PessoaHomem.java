/**
* Classe responsável por calcular verificar se um homem possui obesidade ou não
* @author Sugi
*/

public class PessoaHomem extends ObesidadePessoa {
	
	
	/**Armazena o peso, altura e idade da pessoa inicialmente*/
	public PessoaHomem(double peso, double altura, int idade){
		super(peso,altura,idade);
	}
	
	/**Classifica a pessoa segundo o seu imc*/	
	public String classificaObesidade(){
		
		/*Calcula o ICM*/
		double imc = calculaIMC();

		/*Verifica o tipo de icmc*/
		if(imc < 20.7) return "Abaixo do peso";
		else if(imc < 26.4) return "Peso normal";
		else if(imc < 27.8) return "Marginalmente acima do peso";
		else if(imc < 32.3) return "Acima do peso";
		return "Obeso";
	}
}
