/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author leanddro
 */
public class Teste {
  public static void main(String[] args) {
    Integer[][] sas = new Integer[10][10];
    for(int x = 0; x < 10; x++){
      for(int y = 0; y-1 < x; y++){
        sas[x][y] = y;
        sas[y][x] = y;
      }
    }
    
    // 0 0
    // 1 0, 0 1
    // 2 0, 1 1, 0 2
    // 3 0, 2 1, 
    
//    System.out.println(b);
    
    for(int i = 9; i > 0; i--){
      for(int j = 9; j > i; j--){
//        sas[i][j] = j;
      }
    }
    
    for(Integer[] sa : sas)
      System.out.println(Arrays.toString(sa));
  }
}
