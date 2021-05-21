package Controller;

import Model.Dificuldade;

public class DificuldadeController {

  private static Dificuldade dificuldade;
  private static int colunas;
  private static int linhas;

  public static void gerarDificuldade(Dificuldade dificuldade) {
    if (dificuldade == Dificuldade.DIFICIL) {
      linhas = 50;
      colunas = 50;
    } else if (dificuldade == Dificuldade.MEDIO) {
      linhas = 25;
      colunas = 25;
    } else {
      linhas = 15;
      colunas = 15;
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
