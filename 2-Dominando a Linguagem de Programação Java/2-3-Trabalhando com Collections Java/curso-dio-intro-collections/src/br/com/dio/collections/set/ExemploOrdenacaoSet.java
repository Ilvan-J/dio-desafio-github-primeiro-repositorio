package br.com.dio.collections.set;

import java.util.*;

public class ExemploOrdenacaoSet {
    /*
    * Dados os seguintes informações sobre minhas séries favoritas,
    * crie um conjunto e ordene este conjunto exibindo:
    * (nome - genero - tempo de episódio):
    *
    * Serie 1 = Nome: got, gênero: fantasia, tempoEpisodio: 60
    * Serie 2 = Nome: dark, gênero: drama, tempoEpisodio: 60
    * Serie 3 = Nome: that '70 show, gênero: comédia, tempoEpisodio: 25
    * */
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70 show", "comédia", 25));
        }};

        for (Serie serie: minhasSeries) System.out.println(serie.getNome() + " - "
        + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem inserção\t--");

        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70 show", "comédia", 25));
        }};

        for (Serie serie: minhasSeries1) System.out.println(serie.getNome() + " - "
        + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem natural (temporEpisodio)\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries2) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem Nome/Gênero/tempoEpisodio\t--");

        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());

    }
}
