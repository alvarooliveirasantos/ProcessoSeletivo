package br.com.stream.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.interfaces.Stream;



public class LocalizaVogal {
	  
	    public static final char VAZIO = ' ';
	    private static final String VOGAIS = "(?i)[aÃ¡Ã Ã£Ã¢Ã�Ã€ÃƒÃ‚eÃ©ÃªÃ‰ÃŠiÃ­Ã�oÃ³ÃµÃ´Ã“Ã•Ã”uÃºÃš]";
	    private static final String CARACTER_ESPECIAL = "[^\\w]";
	    private static final String DIGITO = "\\d";




	    /*
	     * Metodo que inicia o processo da busca da vogal
	     */
	    public static char primeiroCaracter(Stream input) {
	        if (input == null) {
	            throw new IllegalArgumentException("Stream nãoo pode ser nula");
	        }

	        Map<Character, Boolean> vogaisEncontradas = new LinkedHashMap<Character, Boolean>();
	        Map<Character, List<Character>> predecessores = new HashMap<Character, List<Character>>();

	        char caracterAnterior = ' ';
	        while (input.hasNext()) {
	            char atualCaracter = input.getNext();

	            registraVogalCaracter(vogaisEncontradas, atualCaracter);
	            computaPredecessor(predecessores, atualCaracter, caracterAnterior);

	            caracterAnterior = atualCaracter;
	        }

	        return localizaVogal(vogaisEncontradas, predecessores);
	    }

	    /*
	     * Localiza Vogal que possui um MAP<Character, Boolean> que contem qual vogal foi encontrada
	     * e tambem um MAP <Character, List<Character>> que possui o caracter atual e seus anteriores.
	     */
	    private static Character localizaVogal(Map<Character, Boolean> vogaisEncontradas,
	                                         Map<Character, List<Character>> predecessores) {
	        for (Map.Entry<Character, Boolean> ocorrenciaVogal : vogaisEncontradas.entrySet()) {
	            if (!ocorrenciaVogal.getValue()) {
	                continue;
	            }

	            for (Character vogalPredecessora : predecessores.get(ocorrenciaVogal.getKey())) {
	                if (!isConsoante(vogalPredecessora)) {
	                    continue;
	                }

	                for (Character consoantePredecessor : predecessores.get(vogalPredecessora)) {
	                    if (isVogal(consoantePredecessor)) {
	                        return ocorrenciaVogal.getKey();
	                    }
	                }
	            }
	        }
	        return VAZIO;
	    }

	    /*
	      Computa a vogal predecessora
	     */
	    private static void computaPredecessor(Map<Character, List<Character>> predecessores,
	                                           char atualCaracter,
	                                           char caracterAnterior) {
	        List<Character> caracteres = predecessores.get(atualCaracter);
	        if (caracteres == null) {
	            caracteres = new ArrayList<Character>();
	            predecessores.put(atualCaracter, caracteres);
	        }
	        if (caracterAnterior != ' ') {
	            caracteres.add(caracterAnterior);
	        }
	    }

	    /*
	     * Registra uma vogal
	     */
	    private static void registraVogalCaracter(Map<Character, Boolean> vogaisEncontradas,
	                                                  char atualCaracter) {
	        if (!isVogal(atualCaracter)) {
	            return;
	        }
	        if (vogaisEncontradas.get(atualCaracter) == null) {
	            vogaisEncontradas.put(atualCaracter, true);
	        } else {
	            vogaisEncontradas.put(atualCaracter, false);
	        }
	    }

	    /*
	     * Verifica se o caracter é uma vogal
	     */
	    private static boolean isVogal(char caracter) {
	        return isVogal(String.valueOf(caracter));
	    }

	    /*
	     * Verifica se o caracter é uma consoante
	     */
	    private static boolean isConsoante(char vogalPredecessora) {
	        String caracter = String.valueOf(vogalPredecessora);
	        return !isVogal(caracter) &&
	                !isCaracterEspecial(caracter) &&
	                !isDigito(caracter);
	    }

	    private static boolean isVogal(String caracter) {
	        return caracter.matches(VOGAIS);
	    }

	    private static boolean isDigito(String caracter) {
	        return caracter.matches(DIGITO);
	    }

	    private static boolean isCaracterEspecial(String caracter) {
	        return caracter.matches(CARACTER_ESPECIAL);
	    }
	}



