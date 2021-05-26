package Componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonMenu extends JButton {

    //PALETA PURPLE
    Color principalColor = new Color(21, 21, 21);
    Color corBordaEntered = new Color(232, 57, 95);
    Color corBordaExit = new Color(161, 91, 158);
    Color textoColor = new Color(232, 57, 95);

    //PALETA DE CORES DARK
    /*
	 * Color principalColor = new Color(21,21,21); Color corBordaEntered = new
	 * Color(100, 88, 150); Color corBordaExit = new Color (100, 88, 107); Color
	 * textoColor = Color.LIGHT_GRAY;
     */
    //BORDA
    Border bordaBtnExit = BorderFactory.createMatteBorder(2, 2, 2, 2, corBordaExit);
    Border bordaBtnentered = BorderFactory.createMatteBorder(2, 2, 2, 2, corBordaEntered);

    public ButtonMenu(String textButton) {
        super();
        this.setFocusable(false);
        this.setText(textButton);
        this.setContentAreaFilled(false);
        this.setFont(new Font("Roboto Light", Font.PLAIN, 25));
        this.setBounds(0, 30, 261, 73);
        this.setBackground(principalColor);
        this.setForeground(textoColor);
        this.setBorder(bordaBtnExit);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(bordaBtnentered);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(bordaBtnExit);
            }
        });
    }

    public void ButtonHover() {
    }

}
