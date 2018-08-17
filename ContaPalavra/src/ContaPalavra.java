import java.lang.Integer;
import java.util.*;
import java.io.File;

public class ContaPalavra{

	//Atributos
	private String nomeArquivo;
	HashMap <String,Integer> mapa;
	private Vector<String> p;

	/**
	 * @param nomeArquivo - Recebe o nome do arquivo texto a ser manipulado.
	 */
	  public ContaPalavra(String nomeArquivo){
	 	this.nomeArquivo = nomeArquivo;	
	       	p = new Vector<String>();	
	 	mapa = new HashMap<String,Integer>(); 
	  }
	
	 /**
	  * Armazena as ocorrências das palavras de um arquivo texto.
	  */ 
	  public void criaMapa(){

		int ocorrencia = 0, ocorrenciaAtual = 0;
		Scanner entrada = null;
		Integer inteiro;
	
		//Verificando se é possível abrir o arquivo
		try{	
			//Abertura do arquivo texto	
			entrada = new Scanner(new File(this.nomeArquivo)); 
		}
		catch(Exception e){
			System.out.println("Arquivo de dados não existe.");
			return;
		}
			
		//Enquanto ouver palavras para serem mapeadas a execução não irá terminar
		while(entrada.hasNext()){
			//Pegando próxima palavra do arquivo
			String palavra = entrada.next();	

			//Verificando se a palavra já existe no mapa
			if(mapa.containsKey(palavra)){
				//Armazenando a quantidade de ocorrencias atual
				inteiro = mapa.get(palavra);	
				inteiro++;

				//Atualizar o valor
				mapa.replace(palavra,inteiro);	
			}
			else{
				inteiro = 1;
				mapa.put(palavra,inteiro);
				p.add(palavra);
			}
		}
	  }
		
  	 /**
	  * Mostra as ocorrências das palavras no arquivo texto.
	  */
	  public void mostrarMapa(){
		
		//Ordenando as palavras do texto
		p.sort(null);

		//Impressão de forma ordenada
		Iterator<String> i = p.iterator();
		
		while(i.hasNext()){
			String palavra = i.next();
			Integer inteiro = mapa.get(palavra);
			System.out.println("Palavra encontrada no  texto: " + palavra + "\tOcorrência: " + inteiro);
		}
	  }
}
