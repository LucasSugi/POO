/**
* Classe responsável por gerenciar várias contas bancárias
* @author Sugi
*/

public class Contas{
	
	/**
	* Adiciona uma conta especial
	* @return Retorna a referência para as contas especiais.
	* @param  ce Recebe a referência para as contas especias.
	*/
	public static ContaEspecial[] addContaEspecial(ContaEspecial[] ce){
		
		String nome = null;
		int conta = 0, i;
		double limite = 0;
		boolean entradaValida = false;
		ContaEspecial[] ceAux = null;
		

		/*Verificação da entrada*/
		while(entradaValida == false){
			try{
				System.out.print("Informe o nome da pessoa: ");
				nome = EntradaTeclado.leString();
				System.out.print("Informe o número da conta: ");
				conta = EntradaTeclado.leInt();		
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
		if(ce == null){
			ce = new ContaEspecial[1];
			ce[0] = new ContaEspecial(nome,conta,limite);
		}
		else{
			ceAux = ce;
			ce = new ContaEspecial[ce.length + 1];
			for(i=0;i<ceAux.length;i++){
				ce[i] = ceAux[i];	
			}
			ce[i] = new ContaEspecial(nome,conta,limite);
			ceAux = null;
		}
		
		/*Informando o usuário que tudo ocorreu de maneira correta*/
		System.out.println("A nova conta foi adicionada com sucesso\n");

		return ce;
	}
	
	/**
	* Adiciona uma conta especial
	* @return Retorna a referência para as contas poupanças. 
	* @param  cp Recebe a referência para as contas poupanças.
	*/
	public static ContaPoupanca[] addContaPoupanca(ContaPoupanca[] cp){
		
		String nome = null;
		int conta = 0, dia = 0, i;
		boolean entradaValida = false;
		ContaPoupanca[] cpAux = null;
		

		/*Verificação da entrada*/
		while(entradaValida == false){
			try{
				System.out.print("Informe o nome da pessoa: ");
				nome = EntradaTeclado.leString();
				System.out.print("Informe o número da conta: ");
				conta = EntradaTeclado.leInt();		
				System.out.print("Informe o dia do vencimento da conta: ");
				dia = EntradaTeclado.leInt();		
				entradaValida = true;
			}
			catch(Exception e){
				/*Informando que o usuário digitou uma entrada inválida*/
				System.out.println("Entrada inválida. Por favor digite tudo novamente.");
			}
		}
		
		/*Adicionando a conta*/
		if(cp == null){
			cp = new ContaPoupanca[1];
			cp[0] = new ContaPoupanca(nome,conta,dia);
		}
		else{
			cpAux = cp;
			cp = new ContaPoupanca[cp.length + 1];
			for(i=0;i<cpAux.length;i++){
				cp[i] = cpAux[i];	
			}
			cp[i] = new ContaPoupanca(nome,conta,dia);
			cpAux = null;
		}
		
		/*Informando o usuário que tudo ocorreu de maneira correta*/
		System.out.println("A nova conta foi adicionada com sucesso\n");

		return cp;
	}
	
	/**
	* Saca dinheiro da conta
	* @param ce Referência para a conta especial.
	* @param cp Referência para a conta poupança.
	*/	
	public static void sacarDinheiro(ContaEspecial[] ce,ContaPoupanca[] cp){
	
		int op = 0, conta = 0;
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
				System.out.print("Informe o tipo da conta(1 - Conta Especial/2 - Conta Poupança): ");
				op = EntradaTeclado.leInt();
				if(op == 1 || op == 2) entradaValida = true;
				else System.out.println("Entrada inválida. Por favor digite novamente.");
							
			}
			catch(Exception e){
				/*Informando que o usuário digitou uma entrada inválida*/
				System.out.println("Entrada inválida. Por favor digite tudo novamente.");
			}
		}					
			
		/*Verificando o tipo de conta*/
		if(op == 1){
			if(ce != null){
				for(int i=0;i<ce.length;i++){
					if(ce[i].getConta() == conta){
						ce[i].saca(saque);
						contaExistente = true;	
					}
				}
			}
		}	
		else{	
			if(cp != null){
				for(int i=0;i<cp.length;i++){
					if(cp[i].getConta() == conta){
						cp[i].saca(saque);
						contaExistente = true;	
					}
				}
			}
		}

		if(contaExistente == false) System.out.println("Essa conta não existe nos nossos registros\n");
	}
	
	/**
	* Saca dinheiro da conta
	* @param ce Referência a conta especial.
	* @param cp Referência a conta poupança.
	*/	
	public static void depositarDinheiro(ContaEspecial[] ce,ContaPoupanca[] cp){
	
		int op = 0, conta = 0;
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
				System.out.print("Informe o tipo de conta(1 - Conta Especial/2 - Conta Poupança): ");
				op = EntradaTeclado.leInt();
				if(op == 1 || op == 2) entradaValida = true;
				else System.out.println("Entrada inválida. Por favor digite novamente.");
							
			}
			catch(Exception e){
				/*Informando que o usuário digitou uma entrada inválida*/
				System.out.println("Entrada inválida. Por favor digite novamente.");
			}
		}					
			
		/*Verificando o tipo de conta*/
		if(op == 1){
			if(ce != null){
				for(int i=0;i<ce.length;i++){
					if(ce[i].getConta() == conta){
						ce[i].deposita(deposito);
						contaExistente = true;	
					}
				}
			}
		}	
		else{
			if(cp != null){
				for(int i=0;i<cp.length;i++){
					if(cp[i].getConta() == conta){
						cp[i].deposita(deposito);
						contaExistente = true;	
					}
				}
			}
		}
			
		/*Quebra de linha*/
		System.out.println();

		if(contaExistente == false) System.out.println("Essa conta não existe nos nossos registros\n");
	}
					
	/**
	* Atualiza todas as contas poupanças de um determinado dia
	* @param cp Recebe a referência da conta poupança.
	*/
	public static void atualizaContaPoupanca(ContaPoupanca[] cp){
				
		int dia = 0;
		double taxa = 0;
		boolean entradaValida = false;


		if(cp == null){
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

		for(int i=0;i<cp.length;i++){
			if(cp[i].getVencimento() == dia){
				cp[i].atualizaSaldo(taxa);
			}
		}

		/*Informando ao usuário que o processo terminou*/
		System.out.println("A atualização acabou. Nenhum erro ocorreu durante o processo.\n");
	}


	/**
	* Mostra o saldo de todas as contas
	* @param ce Referência as contas especiais.
	* @param cp Referência as contas poupanças.
	*/	
	public static void mostrarSaldo(ContaEspecial[] ce, ContaPoupanca[] cp){
	
		int i;
				
		/*Impressão*/
		if(ce != null){
			System.out.println("Conta Especial\n");
			for(i=0;i<ce.length;i++){
				System.out.println("Número da conta: " + ce[i].getConta() + "\tSaldo: " + ce[i].getSaldo());
			}
			System.out.println();
		}

		/*Impressão*/
		if(cp != null){
			System.out.println("Conta Poupança\n");
			for(i=0;i<cp.length;i++){
				System.out.println("Número da conta: " + cp[i].getConta() + "\tSaldo: " + cp[i].getSaldo());
			}
			System.out.println();
		}
	}
	
	/*Método principal*/
	public static void main(String[] args){
	
		int op = 0;
		boolean executarPrograma = true, entradaValida = false;
		
		ContaEspecial[] ce = null;	
		ContaPoupanca[] cp = null;

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
					System.out.println("Qual a conta ser criada ?\t1 - Conta especial.\t2 - Conta poupança.");	
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
					if(op == 1)ce = addContaEspecial(ce);				
					else cp = addContaPoupanca(cp);
					break;

				case 2:
					/*Saca o dinheiro de uma determinada conta*/
					sacarDinheiro(ce,cp);
					break;
				case 3:
					/*Depositar dinheiro na conta*/
					depositarDinheiro(ce,cp);
					break;
				case 4:
					/*Atualizar todas as contas poupanças de um determinado dia*/
					atualizaContaPoupanca(cp);
					break;
				case 5:
					/*Mostar o saldo de todas as contas*/
					mostrarSaldo(ce,cp);
					break;
			}
		
		}	
		
	}
}
