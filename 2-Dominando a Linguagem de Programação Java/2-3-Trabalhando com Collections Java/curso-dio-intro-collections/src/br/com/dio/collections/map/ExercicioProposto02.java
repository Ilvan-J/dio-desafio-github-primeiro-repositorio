package br.com.dio.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExercicioProposto02 {
    public static void main(String[] args) {

        /*
          Faça um programa que simule um lançamento de dados.
          Lance o dado 100 vezes e armazene.
          Depois, mostre quantas vezes cada valor foi inserido.
         */

        Random random = new Random();
        Map<String, Integer> dados = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            String chave = String.valueOf(random.nextInt(6) + 1);
            if (dados.containsKey(chave)) {
                dados.put(chave, dados.get(chave) + 1);
            } else {
                dados.put(chave, 1);
            }
        }

        for (Map.Entry<String, Integer> dado : dados.entrySet())
            System.out.printf("\nValor %s foi inserido %d vezes", dado.getKey(), dado.getValue());

    }
}
