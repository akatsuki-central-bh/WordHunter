/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author leanddro
 */
public class Mapa {
  private String[][] casas;
  private ArrayList<Palavra> palavras;
  private int largura, altura;
  
  public Mapa(int altura, int largura){
    this.casas = new String[largura][altura];
    this.largura = largura;
    this.altura = altura;
    
    for(int x = 0; x < largura; x++){
      String[] linha = new String[largura];
      for(int y = 0; y < altura; y++){
        linha[y] = ".";
      }
      casas[x] = linha;
    }
  }
  public Mapa(int altura, int largura, ArrayList<Palavra> palavras) {
    this.casas = new String[largura][altura];
    this.palavras = palavras;
    
    this.largura = largura;
    this.altura = altura;
    
    for(int x = 0; x < largura; x++){
      String[] linha = new String[altura];
      for(int y = 0; y < altura; y++){
        linha[y] = ".";
      }
      casas[x] = linha;
    }
  }
  
  public void alocarPalavras(){
    Random randomico = new Random();
    
    for(Palavra palavra : palavras){
      if(palavra.getOrientacao() == Orientacao.HORIZONTAL){
        int linha = linhaLivre(randomico.nextInt(altura));
        
        if(palavra.getPalavra().length() == this.altura){
          casas[linha] = palavra.getPalavra().split("");
          
        }else if(palavra.getPalavra().length() < this.altura){
          String[] letras = palavra.getPalavra().split("");
          int range = largura - letras.length;
          String[] concat = Arrays.copyOfRange(casas[linha], 0, range);
          casas[linha] = concatenar(casas[linha], letras, 1);
          
        }
      }
    }
  }
  
  private String[] concatenar(String[] arr1, String[] arr2, int posicao){
      int j = 0;
      for(int i = 0; i < largura-1; i++){
        if(i >= posicao && j < arr2.length){
          arr1[i] = arr2[j];
          j++;
        }
          
      }
      
      return arr1;
    }
  
  private int linhaLivre(int n){
    Random randomico = new Random();
    for(String letra : casas[n]){
      if (!letra.equals(".")){
        return linhaLivre(randomico.nextInt(largura));
      }
    }
    return n;
  }
  
  @Override
  public String toString(){
    String result = "";
    for(String[] linha : casas){
      result += Arrays.toString(linha) + "\n";
    }     

    return result;
  }
  
  private int incrementador = 0;
  public int proximaPosicao(int co){
    Random randomico = new Random();
    co -= incrementador;
    incrementador = randomico.nextInt(3)+1;
    
    return co;
  }
  
  public static void main(String[] args) {
//    int co = 10;
//    Random randomico = new Random();

//    int a = 0;
//    while(co-a > 0){
//      co -= a;
////      System.out.println(co);
//      a = randomico.nextInt(3)+1;
//    }
    
    ArrayList<Palavra> palavras = new ArrayList<>();
    Palavra p = new Palavra("BUG", Orientacao.HORIZONTAL);
    
    palavras.add(p);
    palavras.add(p);
    palavras.add(p);
    
    Mapa mp = new Mapa(5, 5, palavras);
    mp.alocarPalavras();
    
    System.out.println(mp);
  }
}
