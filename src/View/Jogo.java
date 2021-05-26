package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DificuldadeController;
import Controller.PalavraController;
import Model.Dificuldade;
import Model.Mapa;
import Model.Palavra;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Jogo extends JFrame {

	private JPanel contentPane;
	private JTextField txtDigiteAPalavra;
	private int acertos = 0;
	Mapa mp;
	/**
	 * Launch the application.
	 */
	public Jogo() {
		Dificuldade dificuldade = Dificuldade.FACIL;
		DificuldadeController.gerarDificuldade(dificuldade);
		PalavraController.gerarPalavras();
		
		mp = new Mapa(DificuldadeController.getLinhas(), DificuldadeController.getColunas(), PalavraController.getArrayPalavras());
		mp.alocarPalavras();
		
		initComponents();
		
	}

	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setFont(new Font("Arial", Font.BOLD, 12));
		setTitle("WordHunter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtDigiteAPalavra = new JTextField();
		txtDigiteAPalavra.setBounds(44, 540, 397, 20);
		txtDigiteAPalavra.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigiteAPalavra.setForeground(Color.GRAY);
		txtDigiteAPalavra.setColumns(10);
		
		JTextArea textAreaPalavras = new JTextArea();
		textAreaPalavras.setBounds(44, 76, 397, 325);
		textAreaPalavras.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textAreaPalavras.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaPalavras.setEditable(false);
		
		JTextArea textAreaAcertos = new JTextArea();
		textAreaAcertos.setBounds(590, 78, 177, 306);
		textAreaAcertos.setLineWrap(true);
		
		JLabel lblNewLabel = new JLabel("Caça-Palavras");
		lblNewLabel.setBounds(171, 20, 108, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblTituloAcertos = new JLabel("Acertos");
		lblTituloAcertos.setBounds(648, 52, 47, 15);
		lblTituloAcertos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textAreaPalavras.setText(mp.toString());//printar o mapa no jtextarea
		
		JButton btn_Enviar = new JButton("Enviar");
		btn_Enviar.setBounds(518, 536, 132, 27);
		btn_Enviar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_Enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String palavra = txtDigiteAPalavra.getText().toUpperCase();
				if (PalavraController.contem(palavra)) {
					textAreaAcertos.append(palavra+"\n");
					PalavraController.remover(palavra);
					acertos++;
					
				}
				txtDigiteAPalavra.setText("");
			}
		});
		
		if (acertos==5) {
			
		}
		contentPane.setLayout(null);
		contentPane.add(txtDigiteAPalavra);
		contentPane.add(textAreaPalavras);
		contentPane.add(btn_Enviar);
		contentPane.add(textAreaAcertos);
		contentPane.add(lblNewLabel);
		contentPane.add(lblTituloAcertos);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
