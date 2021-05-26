package View;

import javax.swing.JFrame;

public class Principal {
	protected static Menu menu;
	
	public static void main(String[] args) {
		menu = new Menu();
		menu.setVisible(true);
	}
}
