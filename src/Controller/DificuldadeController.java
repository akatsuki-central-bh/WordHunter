package Controller;

import Model.Dificuldade;

public class DificuldadeController {

    private static int colunas;
    private static int linhas;

    public static void gerarDificuldade(Dificuldade dificuldade) {
        switch (dificuldade) {
            case DIFICIL:
                linhas = 25;
                colunas = 25;
                break;
            case MEDIO:
                linhas = 20;
                colunas = 20;
                break;
            case FACIL:
                linhas = 15;
                colunas = 15;
                break;
        }
    }

    public static int getColunas() {
        return colunas;
    }

    public static void setColunas(int colunas) {
        DificuldadeController.colunas = colunas;
    }
    
    public static int getLinhas() {
        return linhas;
    }

    public static void setLinhas(int linhas) {
        DificuldadeController.linhas = linhas;
    }

}
