/**
* Simula um dado de número de lados variados. Ao criar o objeto é possível estabelecer o número de lados. A rolagem do dado é feita por meio de um gerador de números aleatórios 
* @author Sugi
*/

public class Dado{

		/*Atributos*/	
		private int numFaces;
		private int faceAtual;	
			
		/*Criação do objeto randômico*/
		Random rd = new Random();
		
		/**Cria um dado com 6 lados(um cubo)*/
		public Dado(){
			numFaces = 7;
			faceAtual = 0;
		}
		
		/**Cria objeto com um número qualquer de lados
		@param n numero de lados do dado
		*/
		public Dado(int n){
			numFaces = n + 1;
			faceAtual = 0;
		}
	
		/**Recupera o ultimo número selecionado
		@return o numero do ultimo lado selecionado
		*/
		public int getLado(){
			return faceAtual;
		}
		
		/**Seta uma nova semente para ferar a face do dado*/	
		public void novaSemente(long novaS){
			rd.setSemente((int)novaS);
		}

		/**Simula a rolagem do dado por meio de um gerador aleatório. O número selecionado pode posteriormente ser recuperado com a chamada a getLado()
		@return o número que foi sorteado
		*/
		public int rolar(){
	
			/*Exlcuindo a face 0 que não existe no dado*/
			do{
				faceAtual = rd.getIntRand(numFaces);
		
			}while(faceAtual == 0);			

			return faceAtual;
		}
			
		/**Transforma representação do dado em String. É mostrada uma representação do dado que está para cima. Note que só funciona corretamente para dados de 6 lados*/
		@Override
		public String toString(){
			
			String desenhoFace = "O dado não possui 6 lados";
	
			if(numFaces-1 == 6){
				if(faceAtual == 1){
					desenhoFace = "+-----+\n|     |\n|  *  |\n|     |\n+-----+";
				}
				else if(faceAtual == 2){
					desenhoFace = "+-----+\n|   * |\n|     |\n| *   |\n+-----+";	
				}
				else if(faceAtual == 3){
					desenhoFace = "+-----+\n|   * |\n|  *  |\n| *   |\n+-----+";	
				}
				else if(faceAtual == 4){
					desenhoFace = "+-----+\n| * * |\n|     |\n| * * |\n+-----+";	
				}
				else if(faceAtual == 5){
					desenhoFace = "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+";
				}
				else if(faceAtual == 6){
					desenhoFace = "+-----+\n| *** |\n|     |\n| *** |\n+-----+";	
				}
			}
			return desenhoFace;
		}
}
