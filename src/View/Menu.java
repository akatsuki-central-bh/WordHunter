package View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		jLabel1 = new javax.swing.JLabel();
		btn_Jogar = new javax.swing.JButton();
		btn_Recordes = new javax.swing.JButton();
		btn_Creditos = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridLayout(5, 1, 0, 10));
		setMinimumSize(new Dimension(800, 600));
		setLocationRelativeTo(null);
		
		jLabel1.setFont(new java.awt.Font("Lato Black", 1, 18)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("WORD HUNTER");
		getContentPane().add(jLabel1);

		btn_Jogar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btn_Jogar.setText("JOGAR");
		getContentPane().add(btn_Jogar);

		btn_Recordes.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btn_Recordes.setText("RECORDES");
		getContentPane().add(btn_Recordes);

		btn_Creditos.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
		btn_Creditos.setText("CR�DITOS");
		getContentPane().add(btn_Creditos);
		
		btn_Recordes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ranking ranking = new Ranking();
				ranking.setVisible(true);
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

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btn_Creditos;
	private javax.swing.JButton btn_Jogar;
	private javax.swing.JButton btn_Recordes;
	private javax.swing.JLabel jLabel1;
	// End of variables declaration//GEN-END:variables
}