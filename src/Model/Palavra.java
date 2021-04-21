/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author leanddro
 */
public class Palavra{
  private String palavra;
  private int x;
  private int y;
  private Orientacao orientacao;
  private boolean descoberta = false;

  public Palavra(String palavra, Orientacao orientacao) {
    this.palavra = palavra;
    this.orientacao = orientacao;
  }

  public String getPalavra() {
    return palavra;
  }

  public void setPalavra(String palavra) {
    this.palavra = palavra;
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

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
  
  
  
  public static void main(String[] args) {
    int[][] posicao = {{0}, {0}};
//    Palavra p = new Palavra("BUG", posicao, Orientacao.HORIZONTAL);
//    ArrayList<Palavra> palavras = new ArrayList<>();
//    palavras.add(p);
//    Mapa mapa = new Mapa(3, 3, palavras);
//    mapa.alocarPalavras();
//    String[][] mapa = 
//      {{"A","B","C"},{"D","E","F"},{"G","H","I"}};
    
    
    
//    System.out.println(mapa);
  }
  
}
