package View;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Controller.PalavraController;
import Model.Orientacao;
import Model.Palavra;
import Model.Posicao;

public class LabelMapa extends JLabel{
	//PALETA
	Color principalColor = Color.WHITE; 
	Color corBordaEntered = new Color(232,57, 95);
	//Color corBordaExit = new Color (161, 91, 158);
	Color corBordaExit = new Color(60,165,232);
	Color textoColor =  new Color(161, 91, 158);
	Border bordaBtnEntered = BorderFactory.createMatteBorder(1, 1,1,1, corBordaEntered);
	Border bordaBtnExit = BorderFactory.createMatteBorder(1, 1,1,1, corBordaExit);
	
	
	//ATTS
	private Posicao posicao, posicaoInicial, posicaoFinal;
	static boolean pressed;
	//GET SET
	public Posicao getPosicao() {
		return posicao;
	}
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	public boolean isPressed() {
		return pressed;
	}
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	public Posicao getPosicaoInicial() {
		return posicaoInicial;
	}
	public void setPosicaoInicial(Posicao posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}
	public Posicao getPosicaoFinal() {
		return posicaoFinal;
	}
	public void setPosicaoFinal(Posicao posicaoFinal) {
		this.posicaoFinal = posicaoFinal;
	}
	
	public LabelMapa(String letra,Posicao posicao) {
		super();
		this.setPosicao(posicao);
		this.setForeground(textoColor);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		this.setBorder(bordaBtnExit);
		this.setText(letra);
		this.setOpaque(true);
		setBackground(principalColor);
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setPressed(true);
				setPosicaoInicial(getPosicao());
				System.out.println("INICIAL: "+getPosicaoInicial());
				setBorder(bordaBtnEntered);
				setBackground(corBordaEntered);
				setForeground(Color.WHITE);
				setBorder(bordaBtnEntered);
				setBackground(corBordaEntered);
				setForeground(Color.WHITE);
			}
			public void mouseEntered(MouseEvent e) {
				if (isPressed()) {					
					setPosicaoFinal(getPosicao());
					System.out.println("FINAL: "+getPosicaoFinal());
					setBorder(bordaBtnEntered);
					setBackground(corBordaEntered);
					setForeground(Color.WHITE);
					setBorder(bordaBtnEntered);
					setBackground(corBordaEntered);
					setForeground(Color.WHITE);
				}
				
			}
			public void mouseExited(MouseEvent e) {
				setBorder(bordaBtnExit);
				setForeground(textoColor);
				setBackground(principalColor);
				setPosicaoFinal(getPosicao());
			}
			public void mouseReleased(MouseEvent e) {
				setPressed(false);
			}
			
		});
		
	}
	
	/*
	 * public boolean palavraChecar() { for(Palavra palavra :
	 * PalavraController.getArrayPalavras()) {
	 * if(palavra.getPosicaoInicial()==this.getPosicaoInicial() &&
	 * palavra.getPosicaoFinal() == this.getPosicaoFinal()) {
	 * if(palavra.getOrientacao() == Orientacao.HORIZONTAL) { int tamanhoPalavra =
	 * palavra.toString().length(); int posicaoLinha =
	 * palavra.getPosicaoFinal().getX(); for(int i=0;i<tamanhoPalavra;i++) {
	 * 
	 * } } } } }
	 */
}
