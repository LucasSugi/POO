/**
*Esta classe representa o placar de um jogo de Bozó. Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
*@author Sugi
*/
public class Placar{
	
	/*Atributos*/
	int[] posicaoPlacar = null;
	boolean[] ocupadoPlacar = null;
	
	
	/*Construtor*/	
	/**
	*Inicialmente todos as posicoes do placar sao inicializadas com o valor 0.
	*Há um vetor auxiliar que indicara se a posicao estara ocupada ou nao. 
	*/
	public Placar(){
		posicaoPlacar = new int[10];
		ocupadoPlacar = new boolean[10];
		for(int i=0;i<posicaoPlacar.length;i++){
			posicaoPlacar[i] = 0;
			ocupadoPlacar[i] = false;
		}
	}
	
	/*Funcao auxiliar para verificar as posicoes externas do bozo que devem ser preenchidas dadas*/	
	private void verificaAdd(int pos, int inc, int[] dados){
	
		int i;

		for(i = 0;i<dados.length;i++){
			if(dados[i] == inc){
				posicaoPlacar[pos] += inc;	
			}
		}
		ocupadoPlacar[pos] = true;
	}
	
	/*Verifica se os dados formam um full*/
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
						ocupadoPlacar[6] = true;
						posicaoPlacar[6] = 15;
						break;
					}
				}
			}	
		}	
	}
	
	/*Verifica se os dados formam uma sequencia*/			
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
			ocupadoPlacar[7] = true;
			posicaoPlacar[7] = 20;
		}
	}
	
	/*Verifica se os dados formam uma quadra*/		
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
				ocupadoPlacar[8] = true;
				posicaoPlacar[8] = 30;
				break;
			}
		}

	}
	
	/*Verifica se os dados formar uma quina*/
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
				ocupadoPlacar[9] = true;
				posicaoPlacar[9] = 40;
				break;
			}
		}
	}
	
	/**Adiciona uma sequencia de dados em uma determinada posição do placar. Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	@param Recebe a posicao em que o jogador quer colocar os dados e recebe os dados	
	*/	
	public void add(int posicao, int[] dados){
			

		/*Verificando qual a posicao que deve ser armazenado os dados*/
		if(posicao == 1){
			if(ocupadoPlacar[0] == false) verificaAdd(0,1,dados);	
		}	
		else if(posicao == 2){
			if(ocupadoPlacar[1] == false) verificaAdd(1,2,dados);	
		}
		else if(posicao == 3){
			if(ocupadoPlacar[2] == false) verificaAdd(2,3,dados);	
		}
		else if(posicao == 4){
			if(ocupadoPlacar[3] == false) verificaAdd(3,4,dados);	
		}
		else if(posicao == 5){
			if(ocupadoPlacar[4] == false) verificaAdd(4,5,dados);	
		}
		else if(posicao == 6){
			if(ocupadoPlacar[5] == false) verificaAdd(5,6,dados);	
		}
		else if(posicao == 7){
			if(ocupadoPlacar[6] == false) verificaFull(dados);
		}
		else if(posicao == 8){
			if(ocupadoPlacar[7] == false) verificaSequencia(dados);
		}
		else if(posicao == 9){
			if(ocupadoPlacar[8] == false) verificaQuadra(dados);
		}
		else if(posicao == 10){
			if(ocupadoPlacar[9] == false) verificaQuina(dados);
		}
	
	}

	/** Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
	@return O valor da soma
	*/
	public int getScore(){

		int i,resultado = 0;
		
		/*Percorrendo todas as posicoes verificando quais estao ocupadas para somar o resultado*/
		for(i=0;i<posicaoPlacar.length;i++){
			if(ocupadoPlacar[i] == true){
				resultado += posicaoPlacar[i];
			}	
		}
		
		return resultado;
	}

	@Override
	/**A representação na forma de string, mostra o placar completo, indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas. 
	*/
	public String toString(){
			
		int i = 0;
		int contador1 = 0,contador2 = 0;
		String placar = "";
		
		/*Verificando quais posicoes do bozo estao ocupadas*/
		while(contador1 < 9){
			if(ocupadoPlacar[i] == true){
				placar += " " +  posicaoPlacar[i] + " ";
			}
			else{
				placar += "(" + (i + 1) + ")"; 
			}
			
			if(contador2 == 0){
				i += 6;
				placar += "    |   ";
			}
			else if(contador2 == 1){
				i -= 3;
				placar += "    |   ";
			}
			else if(contador2 == 2){
				i  = (contador1+1) / 3;
				placar += "\n";
				placar += "--------------------------\n";
				contador2 = -1;
			}
		
			contador1++;
			contador2++;
		}
		placar += "        |   ";
		if(ocupadoPlacar[9] == true){
			placar += posicaoPlacar[9];
		}	
		else{
			placar += "(10)";
		}
		placar += "   |\n       +----------+\n";
		
		return placar;
	}
}
