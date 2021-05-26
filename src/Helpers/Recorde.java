/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Model.Jogador;
import java.util.Comparator;

/**
 *
 * @author leanddro
 */
public class Recorde implements Comparator<Jogador> {

    @Override
    public int compare(Jogador t1, Jogador t2) {
        if (t1.getTempo() < t2.getTempo()) {
            return -1;
        }

        if (t1.getTempo() > t2.getTempo()) {
            return +1;
        }

        return 0;
    }

}
