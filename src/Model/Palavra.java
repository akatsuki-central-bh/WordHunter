/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author leanddro
 */
public class Palavra{
  private String palavra;
  private int[][] position;
  private Orientacao orientacao;
  private boolean descoberta = false;

  public Palavra(String palavra, int[][] position, Orientacao orientacao) {
    this.palavra = palavra;
    this.position = position;
    this.orientacao = orientacao;
  }

  public String getPalavra() {
    return palavra;
  }

  public void setPalavra(String palavra) {
    this.palavra = palavra;
  }

  public int[][] getPosition() {
    return position;
  }

  public void setPosition(int[][] position) {
    this.position = position;
  }

  public Orientacao getOrientacao() {
    return orientacao;
  }

  public void setOrientacao(Orientacao orientacao) {
    this.orientacao = orientacao;
  }

  public boolean isDescoberta() {
    return descoberta;
  }

  public void setDescoberta(boolean descoberta) {
    this.descoberta = descoberta;
  }
  
  public String toString(){
    return palavra;
  }
  
  public static void main(String[] args) {
    int[][] posicao = {{0}, {0}};
    Palavra p = new Palavra("BUG", posicao, Orientacao.HORIZONTAL);
    ArrayList<Palavra> palavras = new ArrayList<>();
    palavras.add(p);
    Mapa mapa = new Mapa(3, 3, palavras);
    mapa.alocarPalavras();
//    String[][] mapa = 
//      {{"A","B","C"},{"D","E","F"},{"G","H","I"}};
    
    
    
    System.out.println(mapa);
  }
  
}
