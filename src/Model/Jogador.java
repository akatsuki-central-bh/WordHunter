/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author leanddro
 */
public class Jogador implements Serializable {

    private String apelido = "anonimo";
    private double tempo;
    private Dificuldade dificuldade;

    public Jogador(String apelido, double tempo, Dificuldade dificuldade) {
        this.apelido = apelido;
        this.tempo = tempo;
        this.dificuldade = dificuldade;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public String toString() {
        return apelido + tempo;
    }
}
