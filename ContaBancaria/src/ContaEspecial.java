/**
* Classe responsável por controlar a conta especial de uma pessoa
* @author Sugi
*/

public class ContaEspecial extends ContaBancaria{

	/*Atributos*/
	private double limite;
	
	/**
	* Construindo o objeto ContaEspecial	
	* @param nome Nome da pessoa.
	* @param conta Número da conta da pessoa.
	* @param limite Limite do saque da conta.
	*/
	public ContaEspecial(String nome, int conta, double limite){
		/*Chamada para o construtor da superclasse - ContaBancaria*/
		super(nome,conta);
		/*Armazenando o limite da conta*/
		this.limite = limite;
	}
	
	@Override
	/**
	* Saca dinheiro
	* @param saque Recebe a quantia a ser sacada.
	*/
	public void saca(double saque){
		if(saque >= getSaldo() + limite){
			System.out.println("O seu saldo é insuficiente para realizar essa operação");
		}
		else{
			setSaldo(getSaldo()-saque);
			System.out.println("Saque efetuado com sucesso.\n");
		}
	}
	
	/**
	* Retorna o limite da conta da pessoa
	* @return Limite da conta
	*/
	public double getLimite(){
		return this.limite;
	}	
	
	/**
	* Altera o limite da conta da pessoa
	* @param limite Novo limite da conta.
	*/ 
	public void setLimite(int limite){
		this.limite = limite;
	}
}
