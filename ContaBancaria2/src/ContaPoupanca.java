/**
* Classe responsável por controlar a conta poupança de uma pessoa
* @author Sugi
*/

public abstract class ContaPoupanca extends ContaBancaria{

	/*Atributos*/
	private int vencimento;
	
	/**
	* Criação de uma conta poupanca
	* @param nome Nome da pessoa. 
	* @param conta Numero da conta da pessoa. 
	* @param dia Dia de vencimento da conta.  
	*/
	public ContaPoupanca(String nome, int dia){
		/*Construtor da super classe ContaBancaria*/
		super(nome);
		/*Armazenando o vencimento da conta*/
		vencimento = dia;
	}
	
	/**
	* Retorna o dia de vencimento da conta
	* @return Dia de vencimento
	*/
	public int getVencimento(){
		return vencimento;
	}

	/**
	* Altera o dia de vencimento da conta
	* @param vencimento O novo dia de vencimento.
	*/
	public void setVencimento(int vencimento){
		this.vencimento = vencimento;
	}
	
	@Override	
	/**
	* Atualiza o saldo
	* @param taxa A taxa de rendimento da conta.
	*/
	public void atualizaSaldo(double taxa){
		/*Recebendo saldo atual*/
		double saldo = getSaldo();
		/*Alterando o saldo*/
		setSaldo(saldo*(1 + taxa));
	}	
}
