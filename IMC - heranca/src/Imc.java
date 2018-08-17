/**
 * Classe principal que será responsável por fazer o controle do(s) Imc's da(s) pessoa(s) 
 * @author Sugi
 */

public class Imc{

	public static void main(String[] args) throws Exception{
			
		/*Criação do objeto pessoa mulher*/
		PessoaMulher pm = new PessoaMulher(50.3,1.56,45);

		/*Verificando o imc*/
		System.out.println(pm.classificaObesidade());
			
	}
}
