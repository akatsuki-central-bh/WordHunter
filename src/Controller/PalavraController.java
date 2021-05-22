/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.Palavra;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leanddro
 */
public class PalavraController {

  private static ArrayList<Palavra> palavras = new ArrayList<Palavra>();

  public static void gerarPalavras() {
    try {
      File entradaArquivo = new File("src/Data/palavras.txt");
      Random randomico = new Random();
      ArrayList<String> listaPalavras = new ArrayList<String>();
      
      Scanner lerArq = new Scanner(entradaArquivo, "UTF-8");
      String linha = lerArq.nextLine();
      String[] palavrasVetor = linha.split(";");
      
      while (palavras.size() < 5) {
        String palavra = palavrasVetor[randomico.nextInt(palavrasVetor.length)];
        if (!listaPalavras.contains(palavra) && palavra.length() <= 10) {
          listaPalavras.add(palavra);
          Palavra p = new Palavra(palavra);
          palavras.add(p);
        }
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(PalavraController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void add(Palavra palavra) {
    palavras.add(palavra);
  }

  public static ArrayList<Palavra> getArrayPalavras() {
    return palavras;
  }

  public static boolean contem(String palavra_){
    for(Palavra palavra : palavras){
      if(palavra.toString().equals(palavra_)){
        return true;
      }
    }
    
    return false;
  }
}
