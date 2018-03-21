package br.com.stream.impl;


public class Main {
	
	    public static void main(String[] args) {
	        //para estar com outro texto alterar a entrada abaixo
	    	char resul = LocalizaVogal.primeiroCaracter(new CaracterStream("aAbBABacafe"));
	        if(resul != LocalizaVogal.VAZIO) {
	            System.out.println("\nCaracter encontrado: " + resul);
	        } else {
	            System.out.println("\nCaracter nao localizado.");
	        }
	    }
	}


