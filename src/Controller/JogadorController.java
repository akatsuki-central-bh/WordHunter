/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helpers.Recorde;
import Model.Jogador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leanddro
 */
public class JogadorController implements Serializable {

    public static ArrayList<Jogador> jogadores = new ArrayList<>();

    public static ArrayList<Jogador> rankiar() {
        load();
        Recorde cc = new Recorde();
        jogadores.sort(cc);
        return jogadores;
    }

    public static void add(Jogador jogador) {
        load();
        jogadores.add(jogador);
        save();
    }

    private static void load() {
        try {
            FileInputStream arquivoLeitura = new FileInputStream("jogadores.txt");
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            jogadores = (ArrayList<Jogador>) objLeitura.readObject();
            objLeitura.close();
            arquivoLeitura.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    private static void save() {

        try {
            FileOutputStream arquivoGrav = new FileOutputStream("jogadores.txt");

            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(jogadores);
            objGravar.flush();
            objGravar.close();
            arquivoGrav.flush();
            arquivoGrav.close();
            System.out.println("Objeto gravado com sucesso!");

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }
}
