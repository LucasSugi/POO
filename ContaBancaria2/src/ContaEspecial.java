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
	public ContaEspecial(String nome,double limite){
		/*Chamada para o construtor da superclasse - ContaBancaria*/
		super(nome);
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
	
	@Override	
	/*
	* Não atualiza o saldo
	*/
	public void atualizaSaldo(double taxa){

	}	
	
	/**
	* Altera o limite da conta da pessoa
	* @param limite Novo limite da conta.
	*/ 
	public void setLimite(int limite){
		this.limite = limite;
	}

	@Override
	/**
	* Comparação entre dois objetos
	*
	*/	
	public int compareTo(ContaBancaria b){
		
		/*Se for Conta Especial compara com o saldo*/	
		if(b instanceof ContaEspecial){
			double x = this.getSaldo();
			double y = b.getSaldo();

			if(x > y){
				return 1;
			}
			if(x == y){
				return 0;
			}
			return -1;
		}
		/*Poupança ouro ou poupanca simples é maior que Conta Especial*/
		return -1;
	}
}
