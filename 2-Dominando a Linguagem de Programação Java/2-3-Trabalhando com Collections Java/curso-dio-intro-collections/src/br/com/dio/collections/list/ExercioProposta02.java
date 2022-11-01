package br.com.dio.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercioProposta02 {
    public static void main(String[] args) {
        /*
        * Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa
        * sobre um crime. As perguntas são:
        * 1.  Telefonou para a vítima ?
        * 2. Esteve no local do crime ?
        * 3. Mora perto da vítima ?
        * 4. Devia para a vítima ?
        * 5. Já trabalhou com a vítima ?
        * Se a pessoa responder positivamente para 2 questões ela deve ser classificada
        * como "Supeita", entre 3 e 4 classificada como "Cúmplice" e 5 como "Assasina".
        * Caso contrário, ela será classificada como "Inocente".
        * */
        Scanner entrada = new Scanner(System.in);
        List<String> perguntas = new ArrayList<String>();
        perguntas.add("1.  Telefonou para a vítima ?");
        perguntas.add("2. Esteve no local do crime ?");
        perguntas.add("3. Mora perto da vítima ?");
        perguntas.add("4. Devia para a vítima ?");
        perguntas.add("5. Já trabalhou com a vítima ?");

        List<Boolean> respostas = new ArrayList<Boolean>();

        Iterator<String> iterator = perguntas.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("Sim (S) Não (N): ");
            char resposta = entrada.nextLine().toUpperCase().charAt(0);
            if (resposta == 'S') {
                respostas.add(true);
            } else {
                respostas.add(false);
            }
        }

        int contador = 0;
        Iterator<Boolean> iterator1 = respostas.listIterator();
        while (iterator1.hasNext()) {
            boolean afirmativo = iterator1.next();
            if (afirmativo) contador++;
        }


        String msg = "Pessoas considerada ";

        if (contador == 2) {
            msg += "Suspeita";
        } else if (contador > 2 && contador < 5) {
            msg += "Cúmplice";
        } else if (contador == 5) {
            msg += "Assasina";
        } else {
           msg +="Inocente";
        }

        System.out.println(msg);


    }
}
