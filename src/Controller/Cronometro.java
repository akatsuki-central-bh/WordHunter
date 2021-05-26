/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leanddro
 */
public class Cronometro extends Thread {
    private double tempo;
    @Override
    public void run() {
        while(true){
            try {
                tempo++;
                sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public double getTempo() {
        return tempo;
    }
}
