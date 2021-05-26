package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class Creditos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creditos frame = new Creditos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Creditos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 794, 80);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("APS 2021");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 141, 794, 241);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 8, 0));
		
		JLabel lblNewLabel_2 = new JLabel("BY");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("CAUÃ ROCHA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("LEANDRO COUTO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LEONARDO WALDOMIRO");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SERGIO RAMIRO");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("VICTOR DA SILVA");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 443, 794, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("UNIP 2021 3° SEMESTRE CIÊNCIA DA COMPUTAÇÃO");
		panel_2.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		Border bordaBtn = BorderFactory.createMatteBorder(2, 2,2,2, Color.BLACK);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFocusable(false);
		btnVoltar.setBounds(689, 525, 89, 29);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorder(bordaBtn);
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.setForeground(Color.BLACK);
		contentPane.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Principal.menu.setVisible(true);
				
			}
		});
		
		
		
		
	}
}
