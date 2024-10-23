package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca extends Livro{

    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {
    }

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        if (livro != null) {
            if (livro.getTitulo() != null && !livro.getTitulo().isBlank()) {
                if (livro.getAutor() != null && !livro.getAutor().isBlank()){
                    if (livro.getDataPublicacao() != null) {
                        livros.add(livro);
                    }
                }
            }
        }
    }

    public void removerLivroPorTitulo(String titulo){
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                livros.remove(i);
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo){
        if (titulo != null && !titulo.isBlank()) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }
        return null;
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosFiltrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                livrosFiltrados.add(livro);
            }
        }

        return livrosFiltrados;
    }

    public List<Livro> retornarTopCincoLivros(){
        return livros.stream()
                .sorted(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed())
                .limit(5)
                .toList();
    }

}

