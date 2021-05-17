/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helpers.compararCom;
import Model.Jogador;
import java.util.ArrayList;

/**
 *
 * @author leanddro
 */
public class JogadorController {
  public static ArrayList<Jogador> jogadores = new ArrayList<>();
  
  public static void ordenar(){
    compararCom cc = new compararCom();
    jogadores.sort(cc);
  }
  
  public static void main(String[] args) {
    JogadorController.jogadores.add(new Jogador("leanddro", 220.00));
    JogadorController.jogadores.add(new Jogador("vinicius", 120.00));
    JogadorController.jogadores.add(new Jogador("jonata", 130.00));
    JogadorController.jogadores.add(new Jogador("luchaos", 400.00));
    
    
    System.out.println(JogadorController.jogadores);
    JogadorController.ordenar();
    System.out.println(JogadorController.jogadores);
  }
}
