/**
* Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente. Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
* @author Sugi
*/

import java.util.Calendar;

public class RolaDados{
	

	/*Atributos*/
	private Dado[] variosDados = null;	
	
	/*Criacao do objeto calendario*/
	Calendar calendar = Calendar.getInstance();

	/**Construtor que cria e armazena vários objetos do tipo Dado.
	@param Recebe a quantidade de dados que devem ser criados	
	*/
	public RolaDados(int n){
		variosDados = new Dado[n];
		for(int i=0;i<n;i++){
			variosDados[i] = new Dado();
			variosDados[i].novaSemente(((calendar.getTimeInMillis() % 2147483648l)/(i+1)));
		}
	}
	
	/**Rolar todos os dados.
	@return retorna um vetor de inteiros contendo os dados	
	*/
	public int[] rolar(){
	
		int i;
		int[] vetorDados = new int[variosDados.length];
		
		/*Rolando todos os dados*/
		for(i=0;i<variosDados.length;i++){
			vetorDados[i] = variosDados[i].rolar();	
		}
		
		return vetorDados;
	}

	/**Rolar alguns dados.
	@param Recebe um vetor booleano contendo a informacao de quais dados devem ser rolados
	@return Retorna um vetor de inteiro contendo os dados com
	*/
	public int[] rolar(boolean[] quais){
		
		int i;
		int[] vetorDados = new int[quais.length];
		
		/*Rolando alguns dos dados*/
		for(i=0;i<quais.length;i++){
			if(quais[i] == true){
				vetorDados[i] = variosDados[i].rolar();	
			}
			else{
				vetorDados[i] = variosDados[i].getLado();
			}
		}
		
		return vetorDados;
	} 

	/**Rolar alguns dos dados.
	@param Recebe uma string contendo os valores de quais faces devem ser roladas
	@return retornar um vetor de inteiro contendo os dados
	*/
	public int[] rolar(java.lang.String s){
		
		int i,j;
		int dado;
		String aux;
		int[] vetorDados = new int[variosDados.length];
		
		/*Armazenado as faces atuais no vetor*/
		for(i=0;i<variosDados.length;i++){
			vetorDados[i] = variosDados[i].getLado();
		}
		
		/*Alterando as faces segundo a string digitada pelo usuário*/
		for(i=0;i<s.length();i++){
			/*Procurando pelo espaco*/
			j = i;
			while(i<s.length() && s.charAt(i) != ' '){
				i++;
			}
			
			/*Armazenando o número em string*/	
			aux = s.substring(j,i);

			/*Convertendo a string em inteiro*/
			dado = Integer.parseInt(aux);
				
			/*Verificando se a face existe*/
			if(dado > 0 && dado <= variosDados.length){
				vetorDados[dado-1] = variosDados[dado-1].rolar();
			}
			
		}
		
		return vetorDados;
	}

	@Override
	/**Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto.
	@return Retorna uma string contendo a representacao dos dados
	*/
	public String toString(){
		
		int i,j,comeco = 0, fim = 7;
		String dado = null;	
		String resultante = "";	
		
		/*Armazenando os valores das faces*/
		for(i=0;i<variosDados.length;i++){
			/*Verificando qual e' a face*/
			j = i + 1;		
	
			/*Concatenando a face*/
			resultante += j; 
				
			/*Concatenando os espacos*/
			if(i+1 != variosDados.length){
				resultante += "             ";
			}
		}
		resultante += '\n';
		
	
		/*Criando a representacao dos dados*/	
		for(i=0;i<5;i++){	
			for(j=0;j<variosDados.length;j++){
				dado = variosDados[j].toString();
				
				/*Armazenando substring do dado*/
				resultante += dado.substring(comeco,fim);

				/*Concatenando os espacos*/
				if(j+1 != variosDados.length){
					resultante += "       ";
				}
			}	
			comeco += 8;
			fim += 8;
			resultante += "\n";
		}			

		return resultante;
	}	
}	
