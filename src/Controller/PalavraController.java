/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.Palavra;

/**
 *
 * @author leanddro
 */
public class PalavraController {
	private static ArrayList<Palavra> palavras = new ArrayList<Palavra>();
	
	public static void gerarPalavras() throws FileNotFoundException {
		File entradaArquivo = new File("src/Data/palavras.txt");
		Random randomico = new Random();
		ArrayList<String> listaPalavras = new ArrayList<String>();
		
		Scanner lerArq = new Scanner(entradaArquivo, "UTF-8");
		String linha = lerArq.nextLine();
		String[] palavrasVetor = linha.split(";");
		
		while (palavras.size()<5) {
		      String palavra = palavrasVetor[randomico.nextInt(palavrasVetor.length)];
		      if (!listaPalavras.contains(palavra) && palavra.length() <= 10) {
		        listaPalavras.add(palavra);
		        Palavra p = new Palavra(palavra);
		        palavras.add(p);
		      }	
		}
	}
	
	public void add (Palavra palavra) {
		palavras.add(palavra);
	}
	
	
	public static ArrayList<Palavra> getArrayPalavras (){
		return palavras;
	}
	
	public static String listarPalavras() {
		return palavras.toString();
	}
}
