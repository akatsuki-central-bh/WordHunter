/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Controller.DificuldadeController;
import Controller.PalavraController;

/**
 *
 * @author leanddro
 */
public class Mapa {

    private String[][] casas;
    private ArrayList<Palavra> palavras;
    private int largura, altura;
    private ArrayList<String> alfabeto = new ArrayList<>();

    //GETTER 
    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public String[][] getCasas() {
        return casas;
    }
//CONSTRUTOR

    public Mapa(int altura, int largura, ArrayList<Palavra> palavras) {
        this.casas = new String[largura][altura];
        this.palavras = palavras;

        this.largura = largura;
        this.altura = altura;

        for (Palavra palavra : palavras) {
            String[] letras = palavra.getPalavra().split("");
            for (String letra : letras) {
                if (!alfabeto.contains(letra)) {
                    alfabeto.add(letra);
                }
            }
        }
    }

    public void limpar() {
        for (int x = 0; x < largura; x++) {
            String[] linha = new String[altura];
            for (int y = 0; y < altura; y++) {
                linha[y] = ".";
            }
            casas[x] = linha;
        }
    }

    public boolean alocarPalavras() {
        limpar();

        for (Palavra palavra : palavras) {
            if (palavra.getOrientacao() == Orientacao.VERTICAL) {
                if (!encaixarAqui(palavra)) {
                    return alocarPalavras();
                }
            }
        }

        girar();

        for (Palavra palavra : palavras) {
            if (palavra.getOrientacao() == Orientacao.HORIZONTAL) {
                if (!encaixarAqui(palavra)) {
                    return alocarPalavras();
                }
            }
        }

        finalizar();
        return true;
    }

    private String[] concatenar(String[] arr1, String[] arr2, int posicao) {
        int j = 0;
        for (int i = 0; i < largura; i++) {
            if (i >= posicao && j <= arr2.length - 1) {
                arr1[i] = arr2[j];
                j++;
            }
        }

        return arr1;
    }

    private ArrayList<Integer> possiveisLinhas(String[] letras) {
        ArrayList<Integer> casasi = new ArrayList<>();
        int contador;
        int tamanho = letras.length;
        for (int c = 0; c < casas.length; c++) {
            contador = 0;
            for (int i = 0; i < casas[c].length; i++) {
                if (casas[c][i].equals(".") || casas[c][i].equals(letras[contador])) {
                    contador++;
                } else {
                    contador = 0;
                }

                if (contador == tamanho) {
                    casasi.add(c);
                    break;
                }
            }
        }

        return casasi;
    }

    public ArrayList<Integer> possiveisColunas(String[] letras, int casa) {
        ArrayList<Integer> casasi = new ArrayList<>();
        int rangePossivel = largura - letras.length;

        for (int i = 0; i < rangePossivel + 1; i++) {
            int contador = 0;
            for (int j = i; j < i + letras.length; j++) {
                if (casas[casa][j].equals(".") || casas[casa][j].equals(letras[contador])) {
                    contador++;

                    if (contador == letras.length) {
                        casasi.add(i);
                    }
                }
            }
        }

        return casasi;
    }

    private boolean encaixarAqui(Palavra palavra) {
        Random randomico = new Random();
        String[] letras = palavra.getPalavra().split("");

        ArrayList<Integer> possiveisLinhas = possiveisLinhas(letras);

        if (possiveisLinhas.isEmpty()) {
            return false;
        }

        int r = randomico.nextInt(possiveisLinhas.size());
        int linhaIndex = possiveisLinhas.get(r);

        ArrayList<Integer> possiveisColunas = possiveisColunas(letras, linhaIndex);

        if (possiveisColunas.isEmpty()) {
            return false;
        }

        r = randomico.nextInt(possiveisColunas.size());
        int colunaIndex = possiveisColunas.get(r);

        if (palavra.getOrientacao() == Orientacao.HORIZONTAL) {
            palavra.setPosicaoInicial(new Posicao(linhaIndex, colunaIndex));
            palavra.setPosicaoFinal(new Posicao(linhaIndex, colunaIndex + letras.length - 1));
        } else if (palavra.getOrientacao() == Orientacao.VERTICAL) {
            palavra.setPosicaoInicial(new Posicao(colunaIndex, linhaIndex));
            palavra.setPosicaoFinal(new Posicao(colunaIndex + letras.length - 1, linhaIndex));
        }
        
        System.out.println("-----------");
        System.out.println("Palavra: " + palavra.toString());
        System.out.println("Posicao inicial: " + palavra.getPosicaoInicial());
        System.out.println("Posicao final: " + palavra.getPosicaoFinal());
        System.out.println("Orientação: " + palavra.getOrientacao());

        casas[linhaIndex] = concatenar(casas[linhaIndex], letras, colunaIndex);

        return true;
    }

    public void girar() {
        String[][] mapa = new String[altura][largura];
        for (int x = 0; x < casas.length; x++) {
            for (int y = 0; y < casas[x].length; y++) {
                mapa[y][x] = casas[x][y];
            }
        }

        casas = mapa;
    }

    public void finalizar() {
        Random r = new Random();

        for (int x = 0; x < casas.length; x++) {
            for (int y = 0; y < casas[x].length; y++) {
                if (casas[x][y].equals(".")) {
                    casas[x][y] = alfabeto.get(r.nextInt(alfabeto.size()));
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (String[] linha : casas) {
            result += Arrays.toString(linha) + "\n";
        }

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Dificuldade dificuldade = Dificuldade.FACIL;

        DificuldadeController.gerarDificuldade(dificuldade);
        PalavraController.gerarPalavras();

        System.out.println("Dificuldade: " + dificuldade);
        System.out.println("Linhas: " + DificuldadeController.getLinhas());
        System.out.println("C: " + DificuldadeController.getColunas());

        System.out.println("Palavras escolhidas: " + PalavraController.getArrayPalavras());

        Mapa mp = new Mapa(DificuldadeController.getLinhas(), DificuldadeController.getColunas(), PalavraController.getArrayPalavras());

        mp.alocarPalavras();
        System.out.println(mp);
    }
}
