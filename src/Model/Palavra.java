/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

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

  public Palavra(String palavra) {
    setPalavra(palavra);
  }

  public String getPalavra() {
    StringBuilder sb = new StringBuilder();
    Random r = new Random();
    
    if(r.nextBoolean()){
      sb.append(palavra);
      return sb.reverse().toString();
    }
    return palavra;
  }

  public void setPalavra(String palavra) {
    palavra = palavra.toUpperCase();
    Random r = new Random();
    
    
    if(r.nextBoolean()){
      this.orientacao = Orientacao.HORIZONTAL;
    }else{
      this.orientacao = Orientacao.VERTICAL;
    }
    
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

  public String getPalavra1() {
	  return palavra;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
}
