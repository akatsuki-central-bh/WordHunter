package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Dificuldade;
import javax.swing.JButton;

public class SelecaoDificuldade extends JFrame {

	private JPanel contentPane;
	private static Dificuldade dificuldade;

	public SelecaoDificuldade() {
		initComponents();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setMinimumSize(new Dimension(800, 600));
		setResizable(false);
		setLocationRelativeTo(null);

		// PALLETA
		Color corFundo = Color.WHITE;

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 86);
		contentPane.add(panel);
		panel.setBackground(corFundo);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 475, 784, 86);
		contentPane.add(panel_1);
		panel_1.setBackground(corFundo);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 85, 784, 391);
		panel_2.setBackground(corFundo);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(corFundo);
		panel_2.add(panel_3);
		// PANEL DE BUTTONS--------------------------------------
		JPanel panel_buttons = new JPanel();
		panel_2.add(panel_buttons);
		panel_buttons.setLayout(new GridLayout(3, 1, 0, 10));
		panel_buttons.setBackground(corFundo);

		JButton btnFacil = new ButtonMenu("FÁCIL");
		panel_buttons.add(btnFacil);

		JButton btnMedio = new ButtonMenu("MÉDIO");
		panel_buttons.add(btnMedio);

		JButton btndificil = new ButtonMenu("DIFÍCIL");
		panel_buttons.add(btndificil);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(corFundo);
		panel_2.add(panel_5);

		btnFacil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dificuldade = Dificuldade.FACIL;
				Jogo jogo = new Jogo();
				jogo.setVisible(true);
				dispose();

			}
		});

		btnMedio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dificuldade = Dificuldade.MEDIO;
				Jogo jogo = new Jogo();
				jogo.setVisible(true);
				dispose();

			}
		});

		btndificil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dificuldade = Dificuldade.DIFICIL;
				Jogo jogo = new Jogo();
				jogo.setVisible(true);
				dispose();

			}
		});
	}

	public static Dificuldade getDificuldade() {
		return dificuldade;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecaoDificuldade frame = new SelecaoDificuldade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
