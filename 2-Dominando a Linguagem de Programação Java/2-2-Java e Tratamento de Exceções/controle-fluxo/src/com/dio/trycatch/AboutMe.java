package com.dio.trycatch;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        try {

            System.out.println("Digite seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite seu sobrenome: ");
            String sobrenome = scanner.nextLine();

            System.out.println("Digite sua idade: ");
            int idada = scanner.nextInt();

            System.out.println("Digite sua altura: ");
            double altura = scanner.nextInt();

            System.out.println("Olá, me chamo  " + nome.toUpperCase() + " " + sobrenome);
            System.out.println("Tenho " + idada + " anos ");
            System.out.println("Minha altura é " + altura + "cm ");
        } catch (InputMismatchException e) {
            System.err.println("Os campos idade e altura precisam ser numéricos");
        }

        scanner.close();
    }
}
