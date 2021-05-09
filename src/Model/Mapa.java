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
  }
  
  public void limpar(){    
    for(int x = 0; x < largura; x++){
      String[] linha = new String[altura];
      for(int y = 0; y < altura; y++){
        linha[y] = ".";
      }
      casas[x] = linha;
    }
  }
  
  public boolean alocarPalavras(){
    limpar();
//    Random randomico = new Random();
    
    for(Palavra palavra : palavras){
      if(palavra.getOrientacao() == Orientacao.VERTICAL){
        if(!encaixarAqui(palavra.getPalavra())){
          return alocarPalavras();
        }
          
      }
    }
    
    girar();
    
    for(Palavra palavra : palavras){
      if(palavra.getOrientacao() == Orientacao.HORIZONTAL)
//        encaixarAqui(palavra.getPalavra().split(""));
        if(!encaixarAqui(palavra.getPalavra())){       
          return alocarPalavras();
        }
    }
//    finalizar();
    return true;
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
 
  
  private ArrayList<Integer> possiveisCasas(int tamanho, String palavra){
    ArrayList<Integer> casasi = new ArrayList<>();
    String[] letras = palavra.split("");
    int contador;
    
    for(int c = 0; c < casas.length; c++){
      contador = 0;
      for(int i = 0; i < casas[c].length; i++){
//      for(String letra : casas[c]){
        
        if(casas[c][i].equals(".")){
//          System.out.println(casas[c][i]+".equals("+letras[contador]+")");
          contador++;
        }else
          contador = 0;
        
        if(contador == tamanho){
          casasi.add(c);
          break;
        }
      }
    }
    
    return casasi;
  }
  
  private boolean temLinhaLivre(int tamanho){
    int contador;
    for(String[] casa : casas){
      contador = 0;
      for(String letra : casa){
        contador++;
        if(contador == tamanho){
          return true;
        }
      }     
    }
    
    return false;
  }
  
  private boolean encaixarAqui(String palavra){
    Random randomico = new Random();
    String[] letras = palavra.split("");
    int rangePossivel = largura - letras.length;
    
    if(!temLinhaLivre(letras.length)){
      return false;
    }
    
    ArrayList<Integer> possiveisCasas = possiveisCasas(letras.length, palavra);
    
    if(possiveisCasas.isEmpty()){
      return false;
    }
    
    int r = randomico.nextInt(possiveisCasas.size());    
    int linhaIndex = possiveisCasas.get(r);
    
    int colunaIndex = randomico.nextInt(rangePossivel+1);
        
    int range = colunaIndex + letras.length;
    for(int i = colunaIndex; i < range; i++){
      if(!casas[linhaIndex][i].equals("."))
        return encaixarAqui(palavra);
    }
    
    casas[linhaIndex] = concatenar(casas[linhaIndex], letras, colunaIndex);
    
    return true;
  }
  
  public void girar(){
    String[][] sas = new String[altura][largura];
    for(int x = 0; x < casas.length; x++){
      for(int y = 0; y < casas[x].length; y++){
        sas[y][x] = casas[x][y];
      }
    }
    
    casas = sas;
  }

  public void finalizar(){
    String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
    Random r = new Random();
    
    for(int x = 0; x < casas.length; x++){
      for(int y = 0; y < casas[x].length; y++){
        if(casas[x][y].equals(".")){
          casas[x][y] = Character.toString(alfabeto.charAt(r.nextInt(alfabeto.length())));
        }
      }
    }
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
    
    palavras.add(new Palavra("ESTETOSCOPIO", Orientacao.VERTICAL));
    palavras.add(new Palavra("PROFISSIONAIS", Orientacao.VERTICAL));
    palavras.add(new Palavra("INDIVIDUAL", Orientacao.VERTICAL));
    palavras.add(new Palavra("AVENTAIS", Orientacao.VERTICAL));
    palavras.add(new Palavra("AMBIENTES", Orientacao.VERTICAL));
    palavras.add(new Palavra("PROTEÇÃO", Orientacao.VERTICAL));
    palavras.add(new Palavra("HOSPITALARES", Orientacao.VERTICAL));
    palavras.add(new Palavra("SEGURANÇA", Orientacao.VERTICAL));
    
    palavras.add(new Palavra("OJOGO", Orientacao.HORIZONTAL));
    palavras.add(new Palavra("SAÚDE", Orientacao.HORIZONTAL));
    palavras.add(new Palavra("EQUIPAMENTOS", Orientacao.HORIZONTAL));
    palavras.add(new Palavra("BUG", Orientacao.HORIZONTAL));
    
    
    Mapa mp = new Mapa(13, 13, palavras);
    mp.alocarPalavras();
    System.out.println(mp);
    
    // 
    
    
    
  }
}
