package br.com.dio.collections.set;

import java.util.*;

public class ExercicioProposta02 {
    public static void main(String[] args) {

        System.out.println("Crie uma classe LinguagemFavorita que possua os atributos nome,"
        + "anoDeCriacao e ide. Em seguida crie um conjunto com 3 linguagens e faça um programa"
        + "que ordene esse conjunto por: ");

        Set<LinguagemFavorita> linguagemFavoritaSet = new HashSet<>(){{
            add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
            add(new LinguagemFavorita("Python", 1989, "PyCharm"));
            add(new LinguagemFavorita("JavaScript", 1995, "VSCode"));
        }};

        for (LinguagemFavorita linguagemFavorita: linguagemFavoritaSet) System.out.println(linguagemFavorita);

        System.out.println("-- \tOrdem de inserção\t --");

        Set<LinguagemFavorita> linguagemFavoritaSet1 = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
            add(new LinguagemFavorita("Python", 1989, "PyCharm"));
            add(new LinguagemFavorita("JavaScript", 1995, "VSCode"));
        }};

        for (LinguagemFavorita linguagemFavorita: linguagemFavoritaSet1) System.out.println(linguagemFavorita.getNome() + " - "
        + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());

        System.out.println("-- \tOrdem natural (nome)\t --");
        Set<LinguagemFavorita> linguagemFavoritaSet2 = new TreeSet<>(linguagemFavoritaSet1);
        for (LinguagemFavorita linguagemFavorita: linguagemFavoritaSet2) System.out.println(linguagemFavorita.getNome() + " - "
        + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());

        System.out.println("-- \tIde\t --");
        Set<LinguagemFavorita> linguagemFavoritaSet3 = new TreeSet<>(new ComparatorIdeLinguagemFavorita());
        linguagemFavoritaSet3.addAll(linguagemFavoritaSet);
        for (LinguagemFavorita linguagemFavorita: linguagemFavoritaSet3) System.out.println(linguagemFavorita.getNome()
        + " - " + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());

        System.out.println("-- \tAno de criação e nome\t --");
        Set<LinguagemFavorita> linguagemFavoritaSet4 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagemFavoritaSet4.addAll(linguagemFavoritaSet);

        for (LinguagemFavorita linguagemFavorita: linguagemFavoritaSet4) System.out.println(linguagemFavorita.getNome()
                + " - " + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());

        System.out.println("-- \tNome, ano de criação e IDE");
        Set<LinguagemFavorita> linguagemFavoritaSet5 = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
        linguagemFavoritaSet5.addAll(linguagemFavoritaSet);

        for (LinguagemFavorita linguagemFavorita: linguagemFavoritaSet5) System.out.println(linguagemFavorita.getNome()
                + " - " + linguagemFavorita.getAnoDeCriacao() + " - " + linguagemFavorita.getIde());

    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome) && anoDeCriacao.equals(that.anoDeCriacao) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide;
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        int nome = this.getNome().compareTo(linguagemFavorita.getNome());
        if (nome != 0) return nome;
        return Integer.compare(this.getAnoDeCriacao(), linguagemFavorita.getAnoDeCriacao());
    }
}

class ComparatorIdeLinguagemFavorita implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ide = l1.getIde().compareTo(l2.getIde());
        if (ide != 0) return ide;
        return l1.getNome().compareTo(l2.getNome());
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if (anoCriacao != 0) return anoCriacao;

        return l1.getNome().compareTo(l2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome());

        if (nome != 0) return nome;

        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());

        if (anoCriacao != 0) return anoCriacao;

        return l1.getIde().compareTo(l2.getIde());
    }
}