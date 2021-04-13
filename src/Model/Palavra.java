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
  private int[] position;
  private Orientacao orientacao;
  private int[] coord;
  private boolean descoberta = false;

  public Palavra(String palavra, int[] position, Orientacao orientacao, int[] coord) {
    this.palavra = palavra;
    this.position = position;
    this.orientacao = orientacao;
    this.coord = coord;
  }

  public String getPalavra() {
    return palavra;
  }

  public void setPalavra(String palavra) {
    this.palavra = palavra;
  }

  public int[] getPosition() {
    return position;
  }

  public void setPosition(int[] position) {
    this.position = position;
  }

  public Orientacao getOrientacao() {
    return orientacao;
  }

  public void setOrientacao(Orientacao orientacao) {
    this.orientacao = orientacao;
  }

  public int[] getCoord() {
    return coord;
  }

  public void setCoord(int[] coord) {
    this.coord = coord;
  }

  public boolean isDescoberta() {
    return descoberta;
  }

  public void setDescoberta(boolean descoberta) {
    this.descoberta = descoberta;
  }
  
}
