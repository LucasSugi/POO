/**
* Classe responsável por controlar a conta poupança ouro de uma pessoa
* @author Sugi
*/

public class ContaPoupancaSimples extends ContaPoupanca{
	
	
	
	/**
        * Criação de uma conta poupanca ouro
        * @param nome Nome da pessoa. 
        * @param conta Numero da conta da pessoa. 
        * @param dia Dia de vencimento da conta.  
        */
        public ContaPoupancaSimples(String nome, int dia){
                /*Construtor da super classe ContaBancaria*/
                super(nome,dia);
        }

	@Override
        /**
        * Comparação entre dois objetos
        *
        */
        public int compareTo(ContaBancaria b){

                /*Se for Conta Poupanca Simples compara com o saldo*/
                if(b instanceof ContaPoupancaSimples){
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
		/*Poupanca simples é maior que todas as outras contas*/
		return 1;
        }
}
