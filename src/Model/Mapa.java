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
      encaixarAqui(palavra.getPalavra().split(""));
    }
  }
  
  private String[] concatenar(String[] arr1, String[] arr2, int posicao){
    int j = 0;
    for(int i = 0; i < largura; i++){
      if(i >= posicao && j <= arr2.length -1){
        arr1[i] = arr2[j];
        j++;
      }
    }

    return arr1;
  }
  
  private int linhaLivre(int n, int tamanho){
    Random randomico = new Random();
    int contador = 0;
    for(String letra : casas[n]){
      contador++;
      if(contador == tamanho){
        return n;
      }
          
      if (!letra.equals(".")){
        return linhaLivre(randomico.nextInt(largura), tamanho);
      }
    }
    return n;
  }
  
  private boolean encaixarAqui(String[] palavra){
    Random randomico = new Random();
    int rangePossivel = largura - palavra.length;
    int linhaIndex = linhaLivre(randomico.nextInt(altura), palavra.length);
    int colunaIndex = randomico.nextInt(rangePossivel);
        
    int range = colunaIndex + palavra.length;
    for(int i = colunaIndex; i < range; i++){
      if(!casas[linhaIndex][i].equals("."))
        return encaixarAqui(palavra);
    }
    
    casas[linhaIndex] = concatenar(casas[linhaIndex], palavra, colunaIndex);
    
    return true;
  }
  
  @Override
  public String toString(){
    String result = "";
    for(String[] linha : casas){
      result += Arrays.toString(linha) + "\n";
    }     

    return result;
  }
  
  public static void main(String[] args) {    
    ArrayList<Palavra> palavras = new ArrayList<>();
    Palavra p = new Palavra("BUG", Orientacao.HORIZONTAL);
    
    for(int i = 0; i< 10; i++)
      palavras.add(p);
    
    Mapa mp = new Mapa(10, 10, palavras);
    
    mp.alocarPalavras();
    System.out.println(mp);
    
  }
}
