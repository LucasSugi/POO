	/**
* Classe responsável por gerenciar uma conta bancária de uma pessoa
* Nela podem ser feitas saques, depósitos e consultas 
* @author Sugi
*/

public abstract class ContaBancaria implements Comparable<ContaBancaria>{

	/*Atributos*/
	private String nome;
	private int conta;
	private double saldo;
	static private int proximaConta = 0;
	
	/** Inicia uma conta de uma pessoa
	* @param nome Nome da pessoa.
	*/
	public ContaBancaria(String nome){
		this.nome = nome;		
		this.conta = this.proximaConta;
		this.saldo = 0;
		this.proximaConta++;
	}
	
	/*
	* Retorna o número da conta a ser criado
	*/
	static public int getProximaConta(){
		return proximaConta;
	}
	
	/**	
	*Seta um novo saldo
	* @param saldo Novo saldo.
	*/
	protected void setSaldo(double saldo){
		this.saldo = saldo;
	}
	
	/** 
	* Get nome
	* @return O nome da pessoa da conta
	*/
	public String getNome(){
		return nome;
	}
	
	/**
	* Get saldo
	* @return O saldo da pessoa da conta
	*/
	public double getSaldo(){
		return saldo;
	}
	
	/**
	* Get conta
	* @return A conta da pessoa
	*/
	public int getConta(){
		return conta;
	}

	/**
	* Deposita dinheiro na conta
	*@param deposito Recebe a quantia a ser depositada.
	*/
	public void deposita(double deposito){
		saldo += deposito;
	}
	
	/**
	* Atualiza o saldo da conta
	* @param taxa A taxa de rendimento da conta 
	*/
	public abstract void atualizaSaldo(double taxa);

	/**
	* Retira dinheiro da conta
	* @param saque Recebe a quantia a ser sacada.
	*/
	public void saca(double saque){
		if(saldo >= saque){
			saldo -= saque;
			System.out.println("Saque efetuado com sucesso.\n");
		}
		else{
			System.out.println("Saldo insuficiente para realizar a operação\n");
		}
	}
}
