package br.com.dio.collections.map;

import java.util.*;

public class ExercicioProposto01 {
    public static void main(String[] args) {
        /*
         * Dada a popuplação estimada de alguns estados do NE brasileiro, faça:
         * Estado = PE - População = 9.616.621
         * Estado = AL - População = 3.351.543
         * Estado = CE - População = 9.187.103
         * Estado = RN - População = 3.534.265
         * - Crie um dicionário e relacione os estados e suas populações;
         * - Substitua a população do estado de RN por 3.534.165;
         * - Confira se o estado PB está no dicionário, caso não adicionar: PB - 4.039.277;
         * - Exiba a população de PE;
         * - Exiba todos os estados e suas populações na ordem que foi informado;
         * - Exiba os estados e suas populações em ordem alfabética;
         * - Exiba o estado com o menor população e sua quantidade;
         * - Exiba o estado com a maior população e sua quantidade;
         * - Exiba a soma da população desses estados;
         * - Exiba a média da população deste dicionário de estados;
         * - Remova os estados com a população menor que 4.000.000;
         * - Apague o dicionário de estados;
         * - Confira se o dicionário está vazio.
         * */

        System.out.println("Crie um dicionário e relacione os estados e suas populações");

        Map<String, Integer> estados = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 2251543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        for (Map.Entry<String, Integer> estado : estados.entrySet())
            System.out.println("Estado = " + estado.getKey() + " - " + estado.getValue());

        System.out.println("Substitua a população do estado de RN por 3.534.165");
        estados.put("RN", 3534165);

        System.out.println("Confira se o estado PB está no dicionário, caso não adicionar PB - 4.039.277:  "
                + estados.containsKey("PB"));
        estados.put("PB", 4039277);

        System.out.println("Exiba a população de PE: " + estados.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado");
        Map<String, Integer> estadoOrdemInsercao = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 2251543);
            put("CE", 9187103);
            put("RN", 3534165);
            put("PB", 4039277);
        }};
        for (Map.Entry<String, Integer> estado : estadoOrdemInsercao.entrySet())
            System.out.println("Estado = " + estado.getKey() + " - " + estado.getValue());

        System.out.println("Exiba os estados e suas populações em ordem alfabética");
        Map<String, Integer> estadosOrdemAlfabetica = new TreeMap<>(estadoOrdemInsercao);
        for (Map.Entry<String, Integer> estado : estadosOrdemAlfabetica.entrySet())
            System.out.println("Estado = " + estado.getKey() + " - " + estado.getValue());

        System.out.println("Exiba o estado com o menor população e sua quantidade");
        Integer menorPopulacao = Collections.min(estados.values());
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Integer> estado : estados.entrySet()) {
            if (estado.getValue().equals(menorPopulacao)) {
                estadoMenorPopulacao = estado.getKey();
                System.out.println("Estado = " + estadoMenorPopulacao + " - " + menorPopulacao);
            }
        }

        System.out.println("Exiba o estado com a maior população e sua quantidade");
        Integer maiorPopulacao = Collections.max(estados.values());
        String estadoMaiorPopulacao = "";
        for (Map.Entry<String, Integer> estado : estados.entrySet()) {
            if (estado.getValue().equals(maiorPopulacao)) {
                estadoMaiorPopulacao = estado.getKey();
                System.out.println("Estado = " + estadoMaiorPopulacao + " - " + maiorPopulacao);
            }
        }

        Iterator<Integer> iterator = estados.values().iterator();
        Integer soma = 0;
        while (iterator.hasNext())
            soma += iterator.next();

        System.out.println("Exiba a soma da população desses estados: " + soma);

        System.out.println("Exiba a média da população deste dicionário de estados: " + (soma / estados.size()));

        System.out.println("Remova os estados com a população menor que 4.000.000");
        Iterator<Integer> iterator1 = estados.values().iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            if (next < 4000000) {
                iterator1.remove();
            }
        }
        for (Map.Entry<String, Integer> estado : estados.entrySet())
            System.out.println("Estado = " + estado.getKey() + " - " + estado.getValue());

        System.out.println("Apague o dicionário de estados");
        estados.clear();

        System.out.println("Confira se o dicionário está vazio: " + estados.isEmpty());

    }
}