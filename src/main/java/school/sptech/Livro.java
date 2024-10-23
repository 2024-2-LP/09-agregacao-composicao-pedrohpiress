package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro{

    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Livro() {
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao, List<Avaliacao> avaliacoes) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if (descricao != null && !descricao.isBlank()){
            if (qtdEstrelas != null && (qtdEstrelas >= 0 && qtdEstrelas <= 5)){
                avaliacoes.add(new Avaliacao(descricao, qtdEstrelas));
            }
        }
    }

    public Double calcularMediaAvaliacoes(){
        Double media = 0.0;

        if (!avaliacoes.isEmpty()){
            for (Avaliacao mediaPercorrendo : avaliacoes) {
                media += mediaPercorrendo.getQtdEstrelas();
            }
            return media / avaliacoes.size();
        } else {
            return 0.0;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicaçao) {
        this.dataPublicacao = dataPublicaçao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
