package View;

import Componentes.LabelMapa;
import Controller.Cronometro;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import Controller.DificuldadeController;
import Controller.JogadorController;
import Controller.PalavraController;
import Model.Jogador;
import Model.Mapa;
import Model.Palavra;

import java.awt.Font;

import java.awt.Color;

import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jogo extends JFrame {

    private JPanel contentPane;
    private int acertos = 0;
    Mapa mp;
    private JTextField digitarPalvra;
    private Cronometro cnt;
    /**
     * Launch the application.
     */
    public Jogo() {

        initComponents();
        cnt = new Cronometro();
        cnt.start();

    }

    /**
     * Create the frame.
     */
    private void initComponents() {
        DificuldadeController.gerarDificuldade(SelecaoDificuldade.getDificuldade());
        PalavraController.gerarPalavras();

        mp = new Mapa(DificuldadeController.getLinhas(), DificuldadeController.getColunas(), PalavraController.getArrayPalavras());
        mp.alocarPalavras();
        System.out.println(PalavraController.getArrayPalavras().toString());
        System.out.println("Dificuldade: " + SelecaoDificuldade.getDificuldade());
        System.out.println("Acertos no inicio do jogo: " + acertos);

        setFont(new Font("Arial", Font.BOLD, 12));
        setTitle("WordHunter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);
        setBackground(new Color(32, 136, 213));
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);

        //LINHAS E COLUNAS
        int linhas = mp.getAltura();
        int colunas = mp.getLargura();

        //PALETA CORES
        Color corTituloFundo = new Color(32, 136, 213);
        Color corAcertosLbl = new Color(60, 165, 232);
        Color palavrasEncontradas = new Color(232, 57, 95);

        //Border bordaAcertos = BorderFactory.createMatteBorder(2, 2,2,2, new Color (161, 91, 158));
        Border bordaAcertos = BorderFactory.createMatteBorder(2, 2, 2, 0, corAcertosLbl);
        Border bordaBotaoEntered = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE);

        JPanel pnlTitulo = new JPanel();
        pnlTitulo.setBackground(corTituloFundo);
        pnlTitulo.setBounds(0, 0, 600, 60);
        contentPane.add(pnlTitulo);
        pnlTitulo.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblTitulo = new JLabel("CA�A PALAVRAS");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBackground(Color.BLUE);
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 21));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        pnlTitulo.add(lblTitulo);

        JPanel pnlMapa = new JPanel();
        pnlMapa.setBackground(Color.WHITE);
        pnlMapa.setBounds(0, 50, 600, 521);
        pnlMapa.setLayout(new GridLayout(linhas, colunas, 0, 0));

        for (int i = 0; i < colunas; i++) {
            for (int j = 0; j < linhas; j++) {
                pnlMapa.add(new LabelMapa(mp.getCasas()[i][j]));
            }
        }

        contentPane.add(pnlMapa);

        JPanel pnlAcertostitulo = new JPanel();
        pnlAcertostitulo.setBackground(corAcertosLbl);
        pnlAcertostitulo.setBounds(600, 0, 194, 60);
        contentPane.add(pnlAcertostitulo);
        pnlAcertostitulo.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblAcertos = new JLabel("ACERTOS");
        lblAcertos.setForeground(Color.WHITE);
        lblAcertos.setFont(new Font("Dialog", Font.BOLD, 21));
        lblAcertos.setHorizontalAlignment(SwingConstants.CENTER);
        pnlAcertostitulo.add(lblAcertos);

        JPanel pnlAcertosPalavras = new JPanel();
        pnlAcertosPalavras.setBackground(corAcertosLbl);
        pnlAcertosPalavras.setBounds(600, 59, 194, 445);
        contentPane.add(pnlAcertosPalavras);
        pnlAcertosPalavras.setLayout(null);

        JTextArea textAreaAcertos = new JTextArea();
        textAreaAcertos.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        textAreaAcertos.setBounds(0, 0, 194, 445);
        textAreaAcertos.setEditable(false);
        textAreaAcertos.setForeground(palavrasEncontradas);
        textAreaAcertos.setBorder(bordaAcertos);

        pnlAcertosPalavras.add(textAreaAcertos);

        JPanel pnlDigitar = new JPanel();
        pnlDigitar.setBackground(Color.LIGHT_GRAY);
        pnlDigitar.setBounds(600, 504, 194, 30);
        contentPane.add(pnlDigitar);
        pnlDigitar.setLayout(new GridLayout(0, 1, 0, 0));

        digitarPalvra = new JTextField();
        digitarPalvra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == 10) {
                    String palavra = digitarPalvra.getText().toUpperCase();
                    Palavra p = PalavraController.getPalavra(palavra);
                    if (PalavraController.contem(palavra) && (p != null && p.isDescoberta() == false)) {
                        textAreaAcertos.append(palavra + "\n");
                        acertos++;
                        p.setDescoberta(true);
                        System.out.println("Palavra: " + p.getPalavra() + " Descoberta: " + p.isDescoberta() + "\n");
                        System.out.println("Acertos por rodada: " + acertos);
                    }
                    digitarPalvra.setText("");
                    if (acertos == 5) {
                        cnt.interrupt();
                        String nick = JOptionPane.showInputDialog("Digite seu nick:");
                        JogadorController.add(new Jogador(nick, cnt.getTempo()));
                        JOptionPane.showMessageDialog(null, "Parabéns você venceu!");
                        dispose();
                        Principal.menu.setVisible(true);
                    }

                }
            }
        });
        digitarPalvra.setForeground(Color.LIGHT_GRAY);
        digitarPalvra.setText("Digitar Palavra");
        digitarPalvra.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                digitarPalvra.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void focusGained(FocusEvent e) {
                digitarPalvra.setForeground(palavrasEncontradas);
                digitarPalvra.setText("");
            }
        });
        digitarPalvra.setBorder(bordaAcertos);
        pnlDigitar.add(digitarPalvra);
        digitarPalvra.setColumns(10);

        JPanel pnlBtn = new JPanel();
        pnlBtn.setBackground(corAcertosLbl);
        pnlBtn.setBounds(600, 534, 194, 37);
        contentPane.add(pnlBtn);
        pnlBtn.setLayout(null);

        JButton btnChutar = new JButton("CHUTAR");
        btnChutar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnChutar.setForeground(Color.WHITE);
                btnChutar.setBorder(bordaBotaoEntered);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnChutar.setForeground(Color.WHITE);
                btnChutar.setBorder(bordaAcertos);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                String palavra = digitarPalvra.getText().toUpperCase();
                Palavra p = PalavraController.getPalavra(palavra);
                if (PalavraController.contem(palavra) && (p != null && p.isDescoberta() == false)) {
                    textAreaAcertos.append(palavra + "\n");
                    acertos++;
                    p.setDescoberta(true);
                    System.out.println("Palavra: " + p.getPalavra() + " Descoberta: " + p.isDescoberta() + "\n");
                    System.out.println("Acertos por rodada: " + acertos);
                }
                digitarPalvra.setText("");
                if (acertos == 5) {
                    JOptionPane.showMessageDialog(null, "Parab�ns voc� venceu!");
                    dispose();
                    Principal.menu.setVisible(true);
                }

            }
        });
        btnChutar.setBounds(0, 0, 194, 27);
        btnChutar.setOpaque(true);
        btnChutar.setContentAreaFilled(false);
        btnChutar.setBorder(bordaAcertos);
        btnChutar.setBackground(Color.WHITE);
        btnChutar.setForeground(Color.WHITE);
        btnChutar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlBtn.add(btnChutar);

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
