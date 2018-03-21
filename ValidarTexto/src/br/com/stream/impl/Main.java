package br.com.stream.impl;


public class Main {
	
	    public static void main(String[] args) {
	        //para estar com outro texto alterar a entrada abaixo
	    	char resul = LocalizaVogal.primeiroCaracter(new CaracterStream("aAbBABacafe"));
	        if(resul != LocalizaVogal.VAZIO) {
	            System.out.println("Caracter encontrado: " + resul);
	        } else {
	            System.out.println("Caracter nao localizado.");
	        }
	    }
	}


