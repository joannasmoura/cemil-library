package br.com.cemil.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "livro")
public class Livro implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long isbn;

    @Column(nullable = false)
    private Integer edicao;

    @Column(nullable = false)
    private Boolean locado;

    @JsonIgnoreProperties("livro")
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CopiaLivro> copiaLivros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Boolean getLocado() {
        return locado;
    }

    public void setLocado(Boolean locado) {
        this.locado = locado;
    }

    public List<CopiaLivro> getCopiaLivros() {
        return copiaLivros;
    }

    public void setCopiaLivros(List<CopiaLivro> copiaLivros) {
        this.copiaLivros = copiaLivros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                '}';
    }
}
