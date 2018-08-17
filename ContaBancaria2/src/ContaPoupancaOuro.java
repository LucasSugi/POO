/**
* Classe responsável por controlar a conta poupança ouro de uma pessoa
* @author Sugi
*/

public class ContaPoupancaOuro extends ContaPoupanca{
	
	
	
	/**
        * Criação de uma conta poupanca ouro
        * @param nome Nome da pessoa. 
        * @param conta Numero da conta da pessoa. 
        * @param dia Dia de vencimento da conta.  
        */
        public ContaPoupancaOuro(String nome, int dia){
                /*Construtor da super classe ContaBancaria*/
                super(nome,dia);
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
		setSaldo(saldo*(1.5 + taxa));
	}	

	@Override
        /**
        * Comparação entre dois objetos
        *
        */
        public int compareTo(ContaBancaria b){

                /*Se for Conta Poupanca ouro compara com o saldo*/
                if(b instanceof ContaPoupancaOuro){
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
		/*Conta especial é sempre menor que qualquer outra conta*/
		else if(b instanceof ContaEspecial){
			return 1;
		}
		/*Poupanca ouro é menor que poupanca simples*/
		else if(b instanceof ContaPoupancaSimples){
			return -1;	
		}
		return 0;
        }
}
