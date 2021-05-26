package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends javax.swing.JFrame {

	/**
	 * Creates new form Menu
	 */
	public Menu() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));

		//PALETA DE CORES PUPLE
		  Color principalColor = Color.WHITE; 
		  Color tituloFundoColor = new Color(32,136,203);
		  Color textoColor = Color.WHITE;
		 
		//PALETA DE CORES DARK
		/*
		 * Color principalColor = new Color(21,21,21); Color textoColor =
		 * Color.LIGHT_GRAY;
		 */
		//
		setVisible(true);
		setResizable(false);
		pack();
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 784, 100);
		getContentPane().add(panelTitulo);
		panelTitulo.setLayout(new GridLayout(0, 1, 0, 0));
		panelTitulo.setBackground(tituloFundoColor);
		
		JLabel lblTitulo = new JLabel("WORD HUNTER");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 46));
		lblTitulo.setForeground(textoColor);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(lblTitulo);
		
		JPanel panelParteDeBaixo = new JPanel();
		panelParteDeBaixo.setBounds(0, 100, 784, 461);
		getContentPane().add(panelParteDeBaixo);
		panelParteDeBaixo.setLayout(new GridLayout(0, 3, 0, 0));
		panelParteDeBaixo.setBackground(principalColor);
		
		JPanel panelBaixoEsqueda = new JPanel();
		panelBaixoEsqueda.setBackground(principalColor);
		panelParteDeBaixo.add(panelBaixoEsqueda);
		
		JPanel panelBtns = new JPanel();
		panelBtns.setBackground(principalColor);
		panelParteDeBaixo.add(panelBtns);
		panelBtns.setLayout(null);
		//BUTTON JOGAR
		JButton btn_Jogar = new ButtonMenu("JOGAR");
		
		panelBtns.add(btn_Jogar);
		//BUTTON RECORDES
		JButton btn_Recordes = new ButtonMenu("RECORDES");
		btn_Recordes.setBounds(0, 150, 261, 73);
		panelBtns.add(btn_Recordes);
		//BUTTON CREDITOS
		JButton btn_Creditos = new ButtonMenu("CRÉDITOS");
		btn_Creditos.setBounds(0, 270, 261, 73);
		panelBtns.add(btn_Creditos);
		//
		JPanel panelBaixoDireita = new JPanel();
		panelBaixoDireita.setBackground(principalColor);
		panelParteDeBaixo.add(panelBaixoDireita);
		panelBaixoDireita.setLayout(null);
		
		btn_Creditos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Creditos creditos = new Creditos();
				creditos.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btn_Recordes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ranking ranking = new Ranking();
				ranking.setVisible(true);
				setVisible(false);
			}
		});
		
		btn_Jogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SelecaoDificuldade telaDificuldade = new SelecaoDificuldade();
				telaDificuldade.setVisible(true);
				setVisible(false);
				
			}
		});
		
		setVisible(true);
		pack();
    
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Menu().setVisible(true);
			}
		});
	}

	/*
	 * // Variables declaration - do not modify//GEN-BEGIN:variables private
	 * javax.swing.JButton btn_Creditos; private javax.swing.JButton btn_Jogar;
	 * private javax.swing.JButton btn_Recordes; private javax.swing.JLabel jLabel1;
	 */
}