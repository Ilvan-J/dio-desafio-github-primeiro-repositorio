package br.com.dio.collections.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploOrdenacaoMap {
    /*
     * 
     *Dadas as seguintes informações sobre meus livros
      favoritos e seus autores, crie um dicionário e organize
      esse dicionário:
      Exibindo (nome Autor - nome Livro);
      Autor = Marking, Stephen Livro Nome = Uma breve história do tempo Paginas = 256
      Autor = Duhigg, Charles Livro Nome = O poder do hábito paginas = 408
      Autor = Hararu, Yuval Noah Livro Nome = 21 lições para século 21 paginas = 432
    **/
    public static void main(String[] args) {
        System.out.println("-- \tOrdem aleatória\t --");
        //Map<String, Livro> meusLivros = new HashMap<>(); // não funciona no jdk 8
        Map<String, Livro> meusLivros = new HashMap<>(){{
                put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
                put("Duhigg, Charles", new Livro("O poder do hábito", 408));
                put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
            }};
        
        for(Map.Entry<String, Livro> livro: meusLivros.entrySet()) 
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        
        System.out.println("-- \tOrdem de inserção\t --");
        //Map<String, Livro> meusLivros1 = new LinkedHashMap<>(); // jdk 9+
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
                put("Hawking, Stephen", new Livro("Uma breve história no tempo",256));
                put("Duhigg, Charles", new Livro("O poder do hábito", 408));
                put("Harari, Yuval Noah", new Livro("21 lições no século 21", 432));
        }};
        
        for(Map.Entry<String, Livro> livro: meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        
        System.out.println("-- \tOrdem alfabética dos autores\t --");
        //Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1); // jdk 9+
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro: meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        
        System.out.println("--\tOrdem alfabética nome dos livros\t --");
        //Set<Map.Entry<String, Livro> meusLivros 3 = new TreeSet<>();// jdk 9+
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro: meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        
        System.out.println("-- \tOrdem das páginas\t --");
        //Set<Map.Entry<String, Livro> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro: meusLivros4)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }
    
}

class Livro {
    private String nome;
    private Integer paginas;
    
    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Integer getPaginas() {
        return this.paginas;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }
    
    @Override
    public String toString() {
        return "Livro{" +
        "nome='" + nome + "\'" +
        ", paginas='" + paginas + "\'" +
        "'}'";
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
    }
}
