/**
 * Classe que tem como principal finalidade informar se uma pessoa está com obesidade ou não
 * @author Sugi
 */

public class ObesidadePessoa{
	
	/*Atributos da classe ObesidadePessoa*/
	private double peso;
	private double altura;
	private int idade;

	/**Inicializa os parâmetros da pessoa*/
	public ObesidadePessoa(double peso,double altura,int idade){
		this.peso = peso;
		this.altura = altura;
		this.idade = idade;	
	}

	/**Atualizar o peso*/
	public void setPeso(double novoPeso){
		peso = novoPeso;	
	}

	/**Atualizar a altura*/
	public void setAltura(double novaAltura){
		altura = novaAltura / 100 ;
	}

	/**Retornar o peso atual*/
	public double getPeso(){
		return peso;
	}	

	/**Retornar o altura atual*/
	public double getAltura(){
		return altura;
	}

	/**Calcula o IMC da pessoa*/
	public double calculaIMC(){

		double peso;
		double altura;
		
		/*Recebendo o peso atual*/
		peso = getPeso();

		/*Recebendo o altura atual*/
		altura = getAltura();

		return peso / (altura * altura);
	}	
	
	/**Definir se a pessoa tem obesidade ou não*/
	public void defineObesidade(){
		
		double imc;
		
		/*Recebendo o icm da pessoa*/
		imc = calculaIMC();	
		
		/*Fazendo a verificação da condição física da pessoa*/
		if(imc > 25){
			System.out.println("Risco de obesidade");
		}
		else{
			System.out.println("Não há risco de obesidade");
		}
	}
}
