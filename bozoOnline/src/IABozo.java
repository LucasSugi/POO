/**
 *  Classe responsável por realizar a IA do jogo bozo.
 *
 */

public class IABozo{
	
	//Atributos
	private boolean[] busy;
	private int[] score;
	private StringBuilder[] choice;
	private double[] prob;
	
	/**
	 * Constroi uma inteligencia artificial para o jogo bozo.
	 */
	public IABozo(){
		score = new int[10];
		choice = new StringBuilder[10];
		prob = new double[10];
		busy = new boolean[10];	
		for(int i=0;i<10;i++) { busy[i] = false; }
	}	

	/**
	 * Realiza um split na string
	 * @param s String que receberá o split.
	 * @return  String com o split.
	 */
	public String split(String s){
		
		int i;	
		String split = "";
		
		for(i=0;i<s.length();i++){
			split += s.charAt(i);	
			split += " ";
		}

		return split;
	}

	/**
	 * Transforma a string dos dados em um vetor de inteiros.
	 * @param s String contendo a representacao dos dados.
	 * @return Vetor contendo a representacao dos dados.
	 */
	public int[] convertToInt(String s){
		
		int i,counter;	
		int[] vetorDados = new int[5];	
		
		i = counter = 0;
		while(counter < 5){
			if(s.charAt(i) != ' '){
				vetorDados[counter] = s.charAt(i) - 48;
				counter++;
			}		
			i++;
		}
		
		return vetorDados;
	}

	/**
	 * Funcao auxiliar para verificar as posicoes externas do bozo que devem ser preenchidas dadas.
	 * @param pos Posicao em que o score deve armazenar.
	 * @param inc Incremento que deve ser utilizado.
	 * @param dados Vetor de dados que deve ser analisado.
	 */	
	private void verificaAdd(int pos, int inc, int[] dados){
	
		int i;

		for(i = 0;i<dados.length;i++){
			if(dados[i] == inc){
				score[pos] += inc;	
			}
		}
	}
	
	/**
	 * Verifica se os dados formam um full.
	 * @param dados Vetor de dados que deve ser analisado.
	 */
	private void verificaFull(int[] dados){
		
		int i,j;
		int []full = new int[6];

		/*Populando o vetor*/
		for(i=0;i<full.length;i++){
			full[i] = 0;
		}
		
		/*Percorrendo as faces do dado para saber quantas sao iguais*/
		for(i=0;i<dados.length;i++){
			if(dados[i] == 1){
				full[0]++;
			}
			else if(dados[i] == 2){
				full[1]++;
			}
			else if(dados[i] == 3){
				full[2]++;
			}
			else if(dados[i] == 4){
				full[3]++;
			}
			else if(dados[i] == 5){
				full[4]++;
			}
			else if(dados[i] == 6){
				full[5]++;
			}
		}
	
		/*Verificando se as faces dos dados formam um full*/
		for(i=0;i<full.length;i++){
			if(full[i] == 3){
				for(j=0;j<full.length;j++){
					if(j != i && full[j] == 2){
						score[6] = 15;
						break;
					}
				}
			}	
		}	
	}
	
	/**
	 * Verifica se os dados formam uma sequencia.
	 * @param dados Vetor de dados que deve ser analisado.
	 */			
	private void verificaSequencia(int[] dados){
		
		int i, sobra = 0, contador = 0;
		int[] seq = new int[6];	
	
		/*Preenchendo vetor com uma sequencia de 1 a 6*/
		for(i=0;i<seq.length;i++){
			seq[i] = i + 1;
		}	

		/*Comparando a sequencia criada com a sequencia das faces dos dados*/
		for(i=0;i<dados.length;i++){
			if(dados[i] == 1){
				seq[0] = 0;
			}	
			else if(dados[i] == 2){
				seq[1] = 0;
			}
			else if(dados[i] == 3){
				seq[2] = 0;
			}
			else if(dados[i] == 4){
				seq[3] = 0;
			}
			else if(dados[i] == 5){
				seq[4] = 0;
			}
			else if(dados[i] == 6){
				seq[5] = 0;
			}
		}

		/*Vericando se existe uma sequencia ou nao*/
		for(i=0;i<seq.length;i++){
			if(seq[i] == 0){
				contador++;
			}
			else{
				sobra = seq[i];	
			}
		}	
		if(contador == 5 && (sobra == 5 || sobra == 6)){
			score[7] = 20;
		}
	}
	
	/**
	 * Verifica se os dados formam uma quadra.
	 * @param dados Vetor de dados que deve ser analisado.
	 */		
	private void verificaQuadra(int[] dados){
	
		int i;
		int[] quadra = new int[6];

		/*Preenchendo o vetor da quadra*/
		for(i=0;i<quadra.length;i++){
			quadra[i] = 0;
		}

		/*Percorrendo as faces do dado para saber quantas sao iguais*/
		for(i=0;i<dados.length;i++){
			if(dados[i] == 1){
				quadra[0]++;
			}
			else if(dados[i] == 2){
				quadra[1]++;
			}
			else if(dados[i] == 3){
				quadra[2]++;
			}
			else if(dados[i] == 4){
				quadra[3]++;
			}
			else if(dados[i] == 5){
				quadra[4]++;
			}
			else if(dados[i] == 6){
				quadra[5]++;
			}
		}

		/*Verificando se existe uma face que se repetiu 4 vezes*/
		for(i=0;i<quadra.length;i++){
			if(quadra[i] == 4){
				score[8] = 30;
				break;
			}
		}

	}
	
	/**
	 * Verifica se os dados formar uma quina.
	 * @param dados Vetor de dados que deve ser analisado.
	 */
	private void verificaQuina(int[] dados){

		int i;
		int[] quina = new int[6];

		/*Preenchendo o vetor da quadra*/
		for(i=0;i<quina.length;i++){
			quina[i] = 0;
		}

		/*Percorrendo as faces do dado para saber quantas sao iguais*/
		for(i=0;i<dados.length;i++){
			if(dados[i] == 1){
				quina[0]++;
			}
			else if(dados[i] == 2){
				quina[1]++;
			}
			else if(dados[i] == 3){
				quina[2]++;
			}
			else if(dados[i] == 4){
				quina[3]++;
			}
			else if(dados[i] == 5){
				quina[4]++;
			}
			else if(dados[i] == 6){
				quina[5]++;
			}
		}

		/*Verificando se existe uma face que se repetiu 4 vezes*/
		for(i=0;i<quina.length;i++){
			if(quina[i] == 5){
				score[9] = 40;
				break;
			}
		}
	}
	
	/**
	 * Seleciona a melhor posicao para o placar.
	 * @param s String contendo a representacao dos dados.
	 * @param turn Turno atual do jogo.
	 * @return String contendo informacoes de quais dados devem ser rolados.
	 */	
	public String add(String s, int turn){
			
		int i, max = -1, pos = 0;
		int[] dados;
		
		dados = convertToInt(s);

		for(i=0;i<score.length;i++) { score[i] = 0; } 

		/*Verificando qual a posicao que deve ser armazenado os dados*/
		if(busy[0] == false) verificaAdd(0,1,dados);	
		if(busy[1] == false) verificaAdd(1,2,dados);	
		if(busy[2] == false) verificaAdd(2,3,dados);	
		if(busy[3] == false) verificaAdd(3,4,dados);	
		if(busy[4] == false) verificaAdd(4,5,dados);	
		if(busy[5] == false) verificaAdd(5,6,dados);	
		if(busy[6] == false) verificaFull(dados);
		if(busy[7] == false) verificaSequencia(dados);
		if(busy[8] == false) verificaQuadra(dados);
		if(busy[9] == false) verificaQuina(dados);
		
		/*Verifica a melhor posicao*/	
		for(i=0;i<10;i++){
			if(busy[i] == false){
				if(score[i] > max){
					max = score[i];
					pos = i;
				}
			}	
		}
		busy[pos] = true;
		s = "P" + turn + " ";
		s += (pos+1);

		return s;
	}        
	
	/**
	 * Calcula o fatorial de um número.
	 * @param num Numero que sera calculado o fatorial.
	 * @return Fatorial do numero. 
	 */
	public int fat(int num){
	
		int i;	
		
		if(num == 0) return 1;

		for(i=num-1;i>0;i--){
			num = num * i;	
		}
		return num;
	}
	
	/**
	 * Probabilidade uma jogada ocorrer.
	 * @param free Quantidade de dados livres que podem ser rolados
	 * @param n Quantidade de dados que estao sendo ocupados.
	 * @return Probabilidade da jogada.
	 */
	public double probability(int free, int n){
		
		double p;

		p = (Math.pow(5,n) * fat(free)) / (Math.pow(6,free) * fat(n) * fat(free-n)); 
		return p;
	}
	
	/**
	 * Monta a string das posicoes internas a ser utilizada para rolar os dados.
	 * @param num Face do dado que foi analisada.
	 * @param dados Representacao dos dados.
	 */
	public void mountStringInt(int num, int[] dados){
	
		int i;
		
		//Monta a string
		for(i=0;i<dados.length;i++){
			if(dados[i] != num){
				choice[num-1].setCharAt(i+1,'1');
			}	
		}	
	}

	/**
	 * Vefifica se eh possivel obter um resultado melhor que o atual para as posicoes externas.
	 * @param num Face a ser analisada.
	 * @param max Melhor score atual.
	 * @param dados Representacao dos dados.
	 */
	public void posExt(int num, int max, int[] dados){
	
		int i,n,free;
		int flag = 0;	

		//Verificando quantos valores "num" existem nos dados
		n = 0;
		for(i=0;i<dados.length;i++){
			if(dados[i] == num) {
				n++;	
			}
		}	

		//Posicoes que livres
		free = 5 - n;
		
		//Verificando se eh possivel conseguir uma pontuacao maior	
		for(i=1;i<=free;i++){
			if(num*(i+n) > max){
				//Calcula a probabilidade disso ocorrer
				prob[num-1] = probability(free,free-i);
				score[num-1] = (i+n) * num;
				mountStringInt(num,dados);
				flag = 1;
				break;
				}	
			flag = 2;
		}
		if(flag == 0) score[num-1] = n * num;
		if(free == 0) prob[num-1] = 1;
	}
	
	/**
	 * Monta a string para a ser utilizada para rolar os dados.
	 * @param amnt Quantidade de vezes que a face aparece. 
	 * @param counter Quantas vezes a troca deve ser realizada.
	 * @param amount Vetor contendo a quantidade de vezes que cada face aparece. 
	 * @param dados Representacao dos dados.
	 * @param type Posicao em que deve ser armazenada a string.
	 */
	public void mountString1(int amnt, int counter, int[] amount, int[] dados, int type){
	
		int i;
	

		//Mounta String para o full
		for(i=0;i<dados.length;i++){
			if(amount[dados[i]-1] == amnt && counter>0){
				choice[type].setCharAt(i+1,'1');
				counter--;
			}	
		}
	}
	
	/**
	 * Monta a string para a quadra a ser utilizada para rolar os dados.
	 * @param amnt1 Quantidade de vezes que a face aparece. 
	 * @param amnt2 Quantidade de vezes que a face aparece. 
	 * @param counter1 Quantas vezes a troca deve ser realizada.
	 * @param counter2 Quantas vezes a troca deve ser realizada.
	 * @param amount Vetor contendo a quantidade de vezes que cada face aparece. 
	 * @param dados Representacao dos dados.
	 * @param type Posicao em que deve ser armazenada a string.
	 */
	public void mountString2(int amnt1, int amnt2, int counter1, int counter2, int[] amount, int[] dados, int type){
			
		int i,j;
		int aux1,aux2;

		aux1 = aux2 = -1;
		for(i=0;i<dados.length;i++){
			if(amount[dados[i]-1] == amnt1 && dados[i] != aux2 && counter1>0){
				for(j=i;j<dados.length;j++){
					if(dados[i] == dados[j] && counter1>0){
						choice[type].setCharAt(j+1,'1');
						counter1--;
					}	
				}
				aux1 = dados[i];	
			}
			else if(amount[dados[i]-1] == amnt2 && dados[i] != aux1 && counter2>0){
				choice[type].setCharAt(i+1,'1');	
				counter2--;
				aux2 = dados[i];
			}
		}	
	}
	
	/**
	 * Vefifica se eh possivel obter um resultado melhor que o atual para uma posicao interna.
	 * @param max Score maximo.
	 * @param dados Representacao dos dados.
	 */
	public void posInt(int max, int[] dados){
	
		int i,j,flag;	
		int[] amount;

		amount = new int[6];
		for(i=0;i<6;i++) { amount[i] = 0; }
		
		//Verificando quantas vezes cada face aparece nos dados	
		for(i=0;i<5;i++){
			if(dados[i] == 1){
				amount[0]++;
			}
			if(dados[i] == 2){
				amount[1]++;
			}
			if(dados[i] == 3){
				amount[2]++;
			}
			if(dados[i] == 4){
				amount[3]++;
			}
			if(dados[i] == 5){
				amount[4]++;
			}
			if(dados[i] == 6){
				amount[5]++;
			}
		}
		
		//Verificando as configuracoes possiveis dos dados	
		flag = 0;
		for(i=0;i<6;i++){
			if(amount[i] == 2){
				for(j=0;j<6;j++){
					if(amount[j] == 2 && i!=j){
						if(busy[6] == false && flag == 0) {prob[6] = (double)1/3;    mountString1(1,1,amount,dados,6);}
						if(busy[7] == false && flag == 0) {prob[7] = (double)1/6;    mountString2(2,2,1,1,amount,dados,7);}
						if(busy[8] == false && flag == 0) {prob[8] = (double)15/216; mountString2(2,1,2,1,amount,dados,8);}
						if(busy[9] == false && flag == 0) {prob[9] = (double)1/216;  mountString2(2,1,2,1,amount,dados,9);}
						flag = 1;
					}
					else if(amount[j] == 3){
						if(busy[6] == false && flag == 0) {prob[6] = (double)1;}
						if(busy[7] == false && flag == 0) {prob[7] = (double)1/9;    mountString2(3,2,2,1,amount,dados,7);}
						if(busy[8] == false && flag == 0) {prob[8] = (double)10/36;  mountString1(2,2,amount,dados,8);}
						if(busy[9] == false && flag == 0) {prob[9] = (double)1/36;   mountString1(2,2,amount,dados,9);}
						flag = 1;
					}
				}	
				if(busy[6] == false && flag == 0) {prob[6] = (double)1/36;    mountString1(1,2,amount,dados,6);}
				if(busy[7] == false && flag == 0) {prob[7] = (double)1/3;     mountString1(2,1,amount,dados,7);}
				if(busy[8] == false && flag == 0) {prob[8] = (double)15/216;  mountString1(1,3,amount,dados,8);}
				if(busy[9] == false && flag == 0) {prob[9] = (double)1/216;   mountString1(1,3,amount,dados,9);}
				flag = 1;
			}
			else if(amount[i] == 3){
				for(j=0;j<6;j++){
					if(amount[j] == 2){
						if(busy[6] == false && flag == 0) {prob[6] = (double)1;}
						if(busy[7] == false && flag == 0) {prob[7] = (double)1/9;   mountString2(3,2,2,1,amount,dados,7);}
						if(busy[8] == false && flag == 0) {prob[8] = (double)10/36; mountString1(2,2,amount,dados,8);}
						if(busy[9] == false && flag == 0) {prob[9] = (double)1/36;  mountString1(2,2,amount,dados,9);}
						flag = 1;
					}
				}
				if(busy[6] == false && flag == 0) {prob[6] = (double)1/6;   mountString1(1,1,amount,dados,6);}
				if(busy[7] == false && flag == 0) {prob[7] = (double)1/6;   mountString1(3,2,amount,dados,7);}
				if(busy[8] == false && flag == 0) {prob[8] = (double)10/36; mountString1(1,2,amount,dados,8);}
				if(busy[9] == false && flag == 0) {prob[9] = (double)1/36;  mountString1(1,2,amount,dados,9);}
				flag = 1;
			}
			else if(amount[i] == 4){
				if(busy[6] == false && flag == 0) {prob[6] = (double)1/6;   mountString1(4,1,amount,dados,6);}
				if(busy[7] == false && flag == 0) {prob[7] = (double)1/9;   mountString1(4,3,amount,dados,7);}
				if(busy[8] == false && flag == 0) {prob[8] = (double)1;}
				if(busy[9] == false && flag == 0) {prob[9] = (double)1/6;   mountString1(1,1,amount,dados,9);}
				flag = 1;
			}
			else if(amount[i] == 5){
				if(busy[6] == false && flag == 0) {prob[6] = (double)1/36;   mountString1(5,2,amount,dados,6);}
				if(busy[7] == false && flag == 0) {prob[7] = (double)5/36;   mountString1(5,4,amount,dados,7);}
				if(busy[8] == false && flag == 0) {prob[8] = (double)5/6;    mountString1(5,1,amount,dados,8);}
				if(busy[9] == false && flag == 0) {prob[9] = (double)1;}
				flag = 1;
			}
		}
		if(busy[6] == false && flag == 0) {prob[6] = (double)3/216;    mountString1(1,3,amount,dados,6);}
		if(busy[7] == false && flag == 0) {prob[7] = (double)1;}
		if(busy[8] == false && flag == 0) {prob[8] = (double)20/1296;  mountString1(1,4,amount,dados,8);}
		if(busy[9] == false && flag == 0) {prob[9] = (double)1/1296;   mountString1(1,4,amount,dados,9);}
	}	

	/**
	 * Verifica quais dados devem ser rolados.
	 * @param s String contendo quais dados foram rolados.
	 */
	public String rolar(String s){
	
		int max = -1,i,pos = 0;	
		int[] dados;
		double best;

		dados = convertToInt(s);
		
		//Verificando qual a melhor pontuacao atual
		for(i=0;i<score.length;i++) { score[i] = 0; } 
		if(busy[0] == false) verificaAdd(0,1,dados);	
		if(busy[1] == false) verificaAdd(1,2,dados);	
		if(busy[2] == false) verificaAdd(2,3,dados);	
		if(busy[3] == false) verificaAdd(3,4,dados);	
		if(busy[4] == false) verificaAdd(4,5,dados);	
		if(busy[5] == false) verificaAdd(5,6,dados);	
		if(busy[6] == false) verificaFull(dados);
		if(busy[7] == false) verificaSequencia(dados);
		if(busy[8] == false) verificaQuadra(dados);
		if(busy[9] == false) verificaQuina(dados);
		for(i=0;i<10;i++){
			if(busy[i] == false){
				if(score[i] > max){
					max = score[i];
				}
			}	
		}

		//Inializando
		for(i=0;i<10;i++) { prob[i] = 0; }
		for(i=0;i<10;i++) { choice[i] = new StringBuilder("T00000"); }
		
		//Verifica se eh possivel obter um melhor resultado nas posicoes externas
		if(busy[0] == false ) posExt(1,max,dados);
		if(busy[1] == false ) posExt(2,max,dados);
		if(busy[2] == false ) posExt(3,max,dados);
		if(busy[3] == false ) posExt(4,max,dados);
		if(busy[4] == false ) posExt(5,max,dados);
		if(busy[5] == false ) posExt(6,max,dados);
		posInt(max,dados);
		
		//Setando algumas probabilidades	
		score[6] = 15;
		score[7] = 20;
		score[8] = 30;
		score[9] = 40;

		//Analisando a melhor probabilidade
		best = prob[0];
		pos = 0;
		for(i=1;i<10;i++){
			if(prob[i] > best && score[i] >= max){
				best = prob[i];
				pos = i;
			}	
			else if(prob[i] == best && score[i] > score[pos]){
				best = prob[i];
				pos = i;
			}
		}
		return split(choice[pos].substring(0));
	}
	
	/**
	 * Outro tipo de IA para as posicoes externas.
	 * @param str String contendo a representacao dos dados.
	 * @return String contendo informacoes de quais dados devem ser rolados.
	 */
	public String posExt2(String str){
			
		int i,max,pos,stop,counter;
		int[] amount,dados;
		StringBuilder s = new StringBuilder("T00000");
	
		dados = convertToInt(str);

		amount = new int[6];
		for(i=0;i<6;i++) { amount[i] = 0; } 

		for(i=0;i<dados.length;i++){
			if(dados[i] == 1) { amount[0]++; }	
			else if(dados[i] == 2) { amount[1]++; }	
			else if(dados[i] == 3) { amount[2]++; }	
			else if(dados[i] == 4) { amount[3]++; }	
			else if(dados[i] == 5) { amount[4]++; }	
			else if(dados[i] == 6) { amount[5]++; }	
		}	
			
		counter = stop = 0;
		while(stop == 0 && counter++<6){
			max = amount[0];
			pos = 0;
			for(i=1;i<6;i++){
				if(max < amount[i]){
					max = amount[i];
					pos = i;
				}
				else if(max == amount[i] && i > pos){
					max = amount[i];
					pos = i;
				}
			}
			if(busy[pos] == false){
				for(i=0;i<5;i++){
					if(dados[i] != pos+1){
						s.setCharAt(i+1,'1');	
					}	
				}
				stop = 1;	
			}
			else{
				amount[pos] = -1;	
			}
		}
	
		return split(s.substring(0));
	}

	static public void main(String[] args){
		
		IABozo IA = new IABozo();
	}
}
