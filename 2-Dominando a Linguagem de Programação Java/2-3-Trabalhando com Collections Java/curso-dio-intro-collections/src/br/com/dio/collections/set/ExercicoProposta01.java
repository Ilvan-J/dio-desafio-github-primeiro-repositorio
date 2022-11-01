package br.com.dio.collections.set;

import java.util.*;

public class ExercicoProposta01 {
    public static void main(String[] args) {
        Set<String> coresArcoIres = new HashSet<>(){{
            add("vermelho");
            add("laranja");
            add("amarela");
            add("verde");
            add("azul");
            add("azul-escuro");
            add("violeta");
        }};

        System.out.println("Exibe todas as cores uma abaixo da outra");
        for (String cor: coresArcoIres) System.out.println(cor);

        System.out.println("Exiba a quantidade de cores que o arco-íris têm: " + coresArcoIres.size());

        System.out.println("Exiba as cores em ordem alfabética");
        Set<String> coresArcoIres1 = new TreeSet<>(coresArcoIres);
        for (String cor: coresArcoIres1) System.out.println(cor);

        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
        TreeSet<String> coresArcoIres2 = new TreeSet<String>(coresArcoIres1);
        for (String cor: coresArcoIres2.descendingSet()) System.out.println(cor);

        System.out.println("Exibe as cores que começam com a letra  \"v\": ");
        Iterator<String> iterator = coresArcoIres.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.toUpperCase().charAt(0) == 'V') System.out.println(next);
        }

        System.out.println("Remova todas as cores que começam com a letra \"v\": ");
        Iterator<String> iterator1 = coresArcoIres.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            if (next.toUpperCase().charAt(0) == 'V') iterator1.remove();
        }

        for (String cor: coresArcoIres) System.out.println(cor);

        System.out.println("Remova todas as cores que não começam com a letra \"v\": ");
        Iterator<String> iterator2 = coresArcoIres1.iterator();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            if (next.toUpperCase().charAt(0) != 'V') iterator2.remove();
        }

        for (String cor: coresArcoIres1) System.out.println(cor);

        System.out.println("Limpe o conjunto: ");
        coresArcoIres.clear();

        System.out.println("Confira se o conjunto está vazio");

        System.out.println(coresArcoIres);

    }
}
