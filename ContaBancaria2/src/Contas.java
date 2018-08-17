/**
* Classe responsável por gerenciar várias contas bancárias
* @author Sugi
*/

import java.util.Arrays;

public class Contas{
	
	/**
	* Adiciona uma conta especial
	* @return Retorna a referência para as contas bancárias.
	* @param  cb Recebe a referência para as contas bancárias.
	*/
	public static ContaBancaria[] addContaEspecial(ContaBancaria[] cb){
		
		String nome = null;
		int i, conta = 0;
		double limite = 0;
		boolean entradaValida = false;
		ContaBancaria[] cbAux = null;
		

		/*Verificação da entrada*/
		while(entradaValida == false){
			try{
				System.out.print("Informe o nome da pessoa: ");
				nome = EntradaTeclado.leString();
				System.out.print("Informe o limite da conta: ");
				limite = EntradaTeclado.leDouble();		
				entradaValida = true;
			}
			catch(Exception e){
				/*Informando que o usuário digitou uma entrada inválida*/
				System.out.println("Entrada inválida. Por favor digite tudo novamente.");
			}
		}
		
		/*Adicionando a conta*/
		if(cb == null){
			cb = new ContaBancaria[1];
			cb[0] = new ContaEspecial(nome,limite);
		}
		else{
			cbAux = cb;
			cb = new ContaBancaria[cb.length + 1];
			for(i=0;i<cbAux.length;i++){
				cb[i] = cbAux[i];	
			}
			cb[i] = new ContaEspecial(nome,limite);
			cbAux = null;
		}
		
		/*Retornando o número da conta criado*/
		conta = ContaBancaria.getProximaConta()-1;
		
		/*Informando o usuário que tudo ocorreu de maneira correta*/
		System.out.println("A nova conta foi adicionada com sucesso. Esse é seu número da conta: " + conta  + ".\n");

		return cb;
	}
	
	/**
	* Adiciona uma conta especial
	* @return Retorna a referência para as contas bancárias. 
	* @param  cb Recebe a referência para as contas bancárias.
	*/
	public static ContaBancaria[] addContaPoupanca(ContaBancaria[] cb){
		
		String nome = null;
		int dia = 0, i, tipo = 0, conta = 0;
		boolean entradaValida = false;
		ContaBancaria[] cbAux = null;
		

		/*Verificação da entrada*/
		while(entradaValida == false){
			try{
				System.out.print("Informe o nome da pessoa: ");
				nome = EntradaTeclado.leString();
				System.out.print("Informe o tipo de conta:\n1 - Poupança ouro.\n2 - Poupança simples.\n");
				System.out.print("Opção digitada: ");
				tipo = EntradaTeclado.leInt();
				System.out.print("Informe o dia do vencimento da conta: ");
				dia = EntradaTeclado.leInt();
				if(tipo == 1 || tipo == 2) entradaValida = true;
				else System.out.print("Entrada inválida. Por favor digite novamente\n");
			}
			catch(Exception e){
				/*Informando que o usuário digitou uma entrada inválida*/
				System.out.println("Entrada inválida. Por favor digite tudo novamente.");
			}
		}
		
		/*Verificando o tipo de poupança*/
		if(tipo == 1){
			/*Adicionando a conta*/
			if(cb == null){
				cb = new ContaBancaria[1];
				cb[0] = new ContaPoupancaOuro(nome,dia);
			}
			else{
				cbAux = cb;
				cb = new ContaBancaria[cb.length + 1];
				for(i=0;i<cbAux.length;i++){
					cb[i] = cbAux[i];	
				}
				cb[i] = new ContaPoupancaOuro(nome,dia);
				cbAux = null;
			}
		}
		else{
			/*Adicionando a conta*/
			if(cb == null){
				cb = new ContaBancaria[1];
				cb[0] = new ContaPoupancaSimples(nome,dia);
			}
			else{
				cbAux = cb;
				cb = new ContaBancaria[cb.length + 1];
				for(i=0;i<cbAux.length;i++){
					cb[i] = cbAux[i];	
				}
				cb[i] = new ContaPoupancaSimples(nome,dia);
				cbAux = null;
			}
		}
		
		/*Retornando o número da conta criado*/
		conta = ContaBancaria.getProximaConta()-1;
		
		/*Informando o usuário que tudo ocorreu de maneira correta*/
		System.out.println("A nova conta foi adicionada com sucesso. Esse é seu número da conta: " + conta + ".\n");

		return cb;
	}
	
	/**
	* Saca dinheiro da conta
	* @param cb Referência para as contas bancárias.
	*/	
	public static void sacarDinheiro(ContaBancaria[] cb){
	
		int conta = 0;
		double saque = 0;
		boolean entradaValida = false, contaExistente = false;

		/*Armazenando o resultado*/
		entradaValida = false;
		while(entradaValida == false){
			try{
				System.out.print("Informe o número da conta: ");
				conta = EntradaTeclado.leInt();
				System.out.print("Informe o valor a ser sacado: ");
				saque = EntradaTeclado.leDouble();
				entradaValida = true;
							
			}
			catch(Exception e){
				/*Informando que o usuário digitou uma entrada inválida*/
				System.out.println("Entrada inválida. Por favor digite tudo novamente.");
			}
		}		

		/*Verificando o tipo de conta*/
		if(cb != null){
			for(int i=0;i<cb.length;i++){
				if(cb[i].getConta() == conta){
					cb[i].saca(saque);
					contaExistente = true;	
				}
			}
		}

		if(contaExistente == false) System.out.println("Essa conta não existe nos nossos registros\n");
	}
	
	/**
	* Saca dinheiro da conta
	* @param cb Referência a conta bancárias.
	*/	
	public static void depositarDinheiro(ContaBancaria[] cb){
	
		int conta = 0;
		double deposito = 0;
		boolean entradaValida = false, contaExistente = false;

		/*Armazenando o resultado*/
		entradaValida = false;
		while(entradaValida == false){
			try{
				System.out.print("Informe o número da conta: ");
				conta = EntradaTeclado.leInt();
				System.out.print("Informe a quantia a ser depositada: ");
				deposito = EntradaTeclado.leDouble();
				entradaValida = true;
							
			}
			catch(Exception e){
				/*Informando que o usuário digitou uma entrada inválida*/
				System.out.println("Entrada inválida. Por favor digite novamente.");
			}
		}					
		
		/*Verificando o tipo de conta*/
		if(cb != null){
			for(int i=0;i<cb.length;i++){
				if(cb[i].getConta() == conta){
					cb[i].deposita(deposito);
					contaExistente = true;	
				}
			}
		}
		
		/*Quebra de linha*/
		System.out.println();

		if(contaExistente == false) System.out.println("Essa conta não existe nos nossos registros\n");
	}
					
	/**
	* Atualiza todas as contas poupanças de um determinado dia
	* @param cb Recebe a referência da contai bancárias.
	*/
	public static void atualizaContaPoupanca(ContaBancaria[] cb){
				
		int dia = 0;
		double taxa = 0;
		boolean entradaValida = false;
		ContaPoupanca cp;

		if(cb == null){
			System.out.println("Não existe nenhuma conta poupança nos nossos registros.\n");
			return;
		}

		/*Verificando se a entrada é valida*/
		while(entradaValida == false){
			try{
				System.out.print("Informe o dia de vencimento das contas a serem atualizadas: ");
				dia = EntradaTeclado.leInt();
				System.out.print("Informe a taxa que deve ser utilizada para atualizar os saldos: ");
				taxa = EntradaTeclado.leDouble();
				entradaValida = true;
			}
			catch(Exception e){
				/*Informando que a entrada foi inválida*/
				System.out.println("Entrada inválida. Por favor digite novamente.");
			}
		}
		
		/*Atualizando os dias*/
		System.out.println("Os dias estão sendo atualizados...");

		for(int i=0;i<cb.length;i++){
			if(cb[i] instanceof ContaPoupancaOuro || cb[i] instanceof ContaPoupancaSimples){
				cp = (ContaPoupanca) cb[i];
				if(cp.getVencimento() == dia){
					cp.atualizaSaldo(taxa);
				}	
			}
		}

		/*Informando ao usuário que o processo terminou*/
		System.out.println("A atualização acabou. Nenhum erro ocorreu durante o processo.\n");
	}


	/**
	* Mostra o saldo de todas as contas
	* @param cb Referência as contas bancárias.
	*/	
	public static void mostrarSaldo(ContaBancaria[] cb){
	
		int i;
		
		/*Impressão*/
		if(cb != null){
			for(i=0;i<cb.length;i++){
				/*Verificando o tipo de conta*/
				if(cb[i] instanceof ContaEspecial){
					System.out.println("Conta Especial");
					System.out.println("Número da conta: " + cb[i].getConta() + "\tSaldo: " + cb[i].getSaldo() + "\n");
				}	
				else if(cb[i] instanceof ContaPoupancaOuro){
					System.out.println("Conta Poupança Ouro");
					System.out.println("Número da conta: " + cb[i].getConta() + "\tSaldo: " + cb[i].getSaldo() + "\n");
				}
				else if(cb[i] instanceof ContaPoupancaSimples){
					System.out.println("Conta Poupança Simples");
					System.out.println("Número da conta: " + cb[i].getConta() + "\tSaldo: " + cb[i].getSaldo() + "\n");
				}
			}
		}
	}
	
	/**	
	* Ordenação das contas
	* @param cb Referência para as contas bancárias.
	*/
	public static void ordena(ContaBancaria[] cb){
		/*Ordenação*/
		Arrays.sort(cb);
	}	

	/*Método principal*/
	public static void main(String[] args){
	
		int op = 0;
		boolean executarPrograma = true, entradaValida = false;
		
		ContaBancaria[] cb = null;	

		/*Informando a utilizadade do programa ao usuário*/
		System.out.println("Programa responsável por gerenciar várias contas bancárias.\n");
		
		/*Menu contendo as opções para o usuário*/
		while(executarPrograma == true){

			/*Informando o usuário para escolher uma opção*/
			System.out.println("Digite um opção para o programa.");	
			System.out.println("0 - Sair do programa.\n1 - Incluir uma nova conta.\n2 - Sacar dinheiro.\n3 - Depositar dinheiro.\n4 - Atualizar o valor de todas as contas poupança de um determinado dia.\n5 - Mostrar o saldo de todas as contas.");	
			System.out.print("Opção digitada: ");

			/*Armazenando a opção do usuário*/
			entradaValida = false;
			while(entradaValida == false){	
				try{
					op = EntradaTeclado.leInt();
					if(op>=0  && op<=5)entradaValida = true;
					else System.out.println("Entrada inválida. Por favor digite novamente.");
					
				}
				catch(Exception e){
					/*Informando que o usuário digitou uma entrada inválida*/
					System.out.println("Entrada inválida. Por favor digite novamente.");
				}
			}
		
			/*Quebra de linha*/
			System.out.println();

			/*Operações do programa*/
			switch(op){
				case 0:
					executarPrograma = false;
					break;	
				case 1:
					/*Informando o usuário para digitar qual a conta ser criada*/
					System.out.println("Qual a conta ser criada ?\n1 - Conta especial.\n2 - Conta poupança.");	
					System.out.print("Opção digitada: ");	

					/*Armazenando o resultado*/
					entradaValida = false;
					while(entradaValida == false){
						try{
							op = EntradaTeclado.leInt();
							if(op == 1 || op == 2) entradaValida = true;
							else System.out.println("Entrada inválida. Por favor digite novamente.");
							
						}
						catch(Exception e){
							/*Informando que o usuário digitou uma entrada inválida*/
							System.out.println("Entrada inválida. Por favor digite novamente.");
						}
					}					
					
					/*Quebra de linha*/
					System.out.println();
					
					/*Verificando o tipo de conta a ser criada*/
					if(op == 1)cb = addContaEspecial(cb);				
					else cb = addContaPoupanca(cb);
					/*Ordenando as contas*/
					ordena(cb);
					break;

				case 2:
					/*Saca o dinheiro de uma determinada conta*/
					sacarDinheiro(cb);
					break;
				case 3:
					/*Depositar dinheiro na conta*/
					depositarDinheiro(cb);
					break;
				case 4:
					/*Atualizar todas as contas poupanças de um determinado dia*/
					atualizaContaPoupanca(cb);
					break;
				case 5:
					/*Mostar o saldo de todas as contas*/
					mostrarSaldo(cb);
					break;
			}
		
		}	
		
	}
}
