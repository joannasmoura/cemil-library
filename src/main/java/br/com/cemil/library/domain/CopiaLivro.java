package br.com.cemil.library.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="copia")
public class CopiaLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_livro_fk")
    private Livro livro;

    @ManyToMany(mappedBy = "copiaLivros")
    private List<Pessoa> pessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Pessoa> getPessoa() {
        return pessoas;
    }

    public void setPessoa(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CopiaLivro copiaLivro = (CopiaLivro) o;
        return Objects.equals(id, copiaLivro.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CopiaLivro{" +
                "id=" + id +
                '}';
    }
}
