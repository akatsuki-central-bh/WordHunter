package Componentes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LabelMapa extends JLabel {
    //PALETA

    Color principalColor = Color.WHITE;
    Color corBordaEntered = new Color(232, 57, 95);
    //Color corBordaExit = new Color (161, 91, 158);
    Color corBordaExit = new Color(60, 165, 232);
    Color textoColor = new Color(161, 91, 158);

    Border bordaBtnEntered = BorderFactory.createMatteBorder(1, 1, 1, 1, corBordaEntered);
    Border bordaBtnExit = BorderFactory.createMatteBorder(1, 1, 1, 1, corBordaExit);

    public LabelMapa(String letra) {
        super();

        this.setForeground(textoColor);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setBorder(bordaBtnExit);
        this.setText(letra);
        this.setOpaque(true);
        setBackground(principalColor);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(bordaBtnEntered);
                setBackground(corBordaEntered);
                setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(bordaBtnExit);
                setForeground(textoColor);
                setBackground(principalColor);

            }
        });
    }
}
