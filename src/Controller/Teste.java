/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dificuldade;
import Model.Mapa;
import Model.Palavra;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leanddro
 */
public class Teste {
  public static void main(String[] args) {
    Dificuldade dificuldade = Dificuldade.FACIL;

    DificuldadeController.gerarDificuldade(dificuldade);
    PalavraController.gerarPalavras();

    System.out.println("Dificuldade: " + dificuldade);
    System.out.println("Linhas: " + DificuldadeController.getLinhas());
    System.out.println("C: " + DificuldadeController.getColunas());
    
    ArrayList<Palavra> palavras = PalavraController.getArrayPalavras();
//    System.out.println("Palavras escolhidas: " + PalavraController.getArrayPalavras());

    Mapa mp = new Mapa(DificuldadeController.getLinhas(), DificuldadeController.getColunas(), PalavraController.getArrayPalavras());

    mp.alocarPalavras();
    System.out.println(mp);
    
    Scanner scan = new Scanner(System.in);
    
    ArrayList<String> acertos = new ArrayList<>();
    
    while(acertos.size() != palavras.size()){
      System.out.println("Informe uma palavra:");
      String input = scan.nextLine().toUpperCase();
      if(PalavraController.contem(input)){
        System.out.println("Acertou!!");
        acertos.add(input);
      }else{
        System.out.println("Errrrrou!!");
      }
    }
    System.out.println("Parabéns vc ganhou!!");
  }
}
