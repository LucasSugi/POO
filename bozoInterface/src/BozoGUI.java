import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class BozoGUI extends JFrame{
	
	//Atributos
	private JLabel msn1, msn2, msn3;
	private JTextField texto;
	private String faceDado;
	private Icon[] icones;
	private JLabel[][] imagens;
	private JLabel[] AuxImg, AuxPlacar;
	private RolaDados dados;
	private Placar placar;
	private int[] variosDados;
	private int rodada, jogada;

	//Construtor
	public BozoGUI(){
		//Chamda para a super classe
		super("Jogo bozo");	
		
		//Painel
		JPanel jp = (JPanel) getContentPane();
	
		//Definindo tamanho da janela
		setBounds(400,100,550,550);
		
		/*CRIACAO*/
		
		//Criacao das mensagens para o usuario
		msn1 = new JLabel("Informe quais os dados que você deseja rolar:");
		msn2 = new JLabel("Dados atuais");
		msn3 = new JLabel("Placar");
	
		//Criacao do placar
		placar = new Placar();

		//Criacao da variavel auxiliar que realizara impressao do placar
		AuxPlacar = new JLabel[8];

		//Criacao da caixa de texto
		texto = new JTextField(5);
		
		//Inicializando as rodadas e as jogadas
		rodada = 0;
		jogada = 0;

		//Criacao das imagens
		imagens = new JLabel[6][5];

		//Criacao dos dados
		dados = new RolaDados(5);

		//Criacao de um vetor auxiliar
		AuxImg = new JLabel[5];


		/*ACTIONS*/
		texto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				faceDado = texto.getText();	
				if(rodada != 3){
					variosDados = dados.rolar(faceDado);
					apagaDados(AuxImg);
					repaint();
					imprimeDado(variosDados);
					rodada++;
				}
				if(rodada == 2){
					msn1.setText("Digite a posição em que se deve armazenar a sua pontuação");
					rodada++;
				}
				else if(rodada == 3){
					int n = Integer.parseInt(faceDado);
					placar.add(n,variosDados);
					desenhaPlacar(0,0);
					rodada = 0;	
					msn1.setText("Informe quais os dados que voce deseja rolar:");
					jogada++;
				}
				if(jogada == 1){
					apagaDados(AuxImg);
					apagaTela();
					apagaPlacar();
					msn1.setText("Esse foi o placar final");
					msn1.setBounds(200,0,450,20);
					add(msn1);
					desenhaPlacar(-150,200);
					repaint();
				}
			}
		});

		/*SETS e INICIALIZACOES*/
		setLayout(null);
		
		//Plano de fundo	
		jp.setBackground(Color.GREEN);

		//Inicializando os icones
		for(int i=0;i<5;i++){
			imagens[0][i] = new JLabel(new ImageIcon("picture/dado1.gif"));
			imagens[1][i] = new JLabel(new ImageIcon("picture/dado2.gif"));
			imagens[2][i] = new JLabel(new ImageIcon("picture/dado3.gif"));
			imagens[3][i] = new JLabel(new ImageIcon("picture/dado4.gif"));
			imagens[4][i] = new JLabel(new ImageIcon("picture/dado5.gif"));
			imagens[5][i] = new JLabel(new ImageIcon("picture/dado6.gif"));
		}
		
		//Rolar os dados
		variosDados = dados.rolar();

		//Imprime os dados
		imprimeDado(variosDados);
		
		//Inicia a tela
		iniciaTela();	
		
		//Inicia o placar
		iniciaPlacar();

		//Desenha o placar
		desenhaPlacar(0,0);

		//Ao fechar a janela finalizar o programa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * Impressão do dado.
	 */	
	public void imprimeDado(int []variosDados){
		
		int pos = 10,j = 0;
		int im1,im2,im3,im4,im5,im6;
		
		im1 = im2 = im3 = im4 = im5 = im6 = 0;
		//Percorre o vetor de dados e verifica quais sao necessarios imprimir
		for(int i=0;i<variosDados.length;i++){
			if(variosDados[i] == 1){
				AuxImg[j++] = imagens[0][im1];
				add(imagens[0][im1++]);	
				imagens[0][im1-1].setBounds(pos,150,70,70);	
				pos += 80;
			}	
			else if(variosDados[i] == 2){
				AuxImg[j++] = imagens[1][im2];
				add(imagens[1][im2++]);	
				imagens[1][im2-1].setBounds(pos,150,70,70);	
				pos += 80;
			}	
			else if(variosDados[i] == 3){
				AuxImg[j++] = imagens[2][im3];
				add(imagens[2][im3++]);	
				imagens[2][im3-1].setBounds(pos,150,70,70);	
				pos += 80;
			}	
			else if(variosDados[i] == 4){
				AuxImg[j++] = imagens[3][im4];
				add(imagens[3][im4++]);	
				imagens[3][im4-1].setBounds(pos,150,70,70);	
				pos += 80;
			}	
			else if(variosDados[i] == 5){
				AuxImg[j++] = imagens[4][im5];
				add(imagens[4][im5++]);	
				imagens[4][im5-1].setBounds(pos,150,70,70);	
				pos += 80;
			}	
			else if(variosDados[i] == 6){
				AuxImg[j++] = imagens[5][im6];
				add(imagens[5][im6++]);	
				imagens[5][im6-1].setBounds(pos,150,70,70);	
				pos += 80;
			}	
		}
	}
	
	/*
	 * Desenha o placar
	 */
	public void desenhaPlacar(int x,int y){
		
		String s = placar.toString();	
		int i = 0, j = 0, aux = 0, inc = 270;	
		
		while(j<8){		
			while(s.charAt(i) != '\n'){
				i++;
			}
			AuxPlacar[j].setText(s.substring(aux,i));
			add(AuxPlacar[j]);
			AuxPlacar[j].setBounds(50-x,inc-y,200,30);
			aux = i;
			inc += 30;
			i++;
			j++;
		}
	}

	/*
	 * Inicia o placar
	 */
	public void iniciaPlacar(){
		
		for(int i=0;i<8;i++){
			AuxPlacar[i] = new JLabel();
		}
	}

	/*
	 * Inicializa a tela
	 */
	public void iniciaTela(){
		
		//Adicionando mensagem no painel
		add(msn1);
		add(msn2);
		add(msn3);
	
		//Adicionando a caixa de texto no painel
		add(texto);
		
		//Posicao e dimensao da caixa de texto	
		texto.setBounds(0,20,330,20);	

		//Posicao e dimensao da mensagem
		msn1.setBounds(0,0,450,20);
		msn2.setBounds(0,120,100,20);	
		msn3.setBounds(0,250,50,20);
	}


	/*
	 * Apaga os dados da tela
	 */
	public void apagaDados(JLabel[] AuxImg){
		for(int i=0;i<5;i++){
			remove(AuxImg[i]);
		}	
	}
	
	/*
	 * Apaga o placar
	 */
	public void apagaPlacar(){
		for(int i=0;i<8;i++){
			AuxPlacar[i].setText("");
		}	
	}

	/*
	 * Apaga a tela
	 */
	public void apagaTela(){
		remove(texto);
		remove(msn1);
		remove(msn2);
		remove(msn3);
	}
	
	/*
	 * Main
	 */
	static public void main(String[] args){
		
		BozoGUI bozo = new BozoGUI();	
		bozo.setVisible(true);
	}
}
