package br.com.cemil.library.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telefone", nullable = false)
    private Integer telefone;

    @Column(name="endereco", nullable = false)
    private String endereco;

    @Column(name="admin", nullable = false)
    private Boolean admin;

    @Column(name="emDebito", nullable = false)
    private Boolean emDebito;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "locacao",
            joinColumns = { @JoinColumn(name = "pessoa_id") },
            inverseJoinColumns = { @JoinColumn(name = "copiaLivro_id") }
    )
    private List<CopiaLivro> copiaLivros;

    @ManyToMany(mappedBy = "pessoas")
    private List<Multa> multas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getEmDebito() {
        return emDebito;
    }

    public void setEmDebito(Boolean emDebito) {
        this.emDebito = emDebito;
    }

    public List<CopiaLivro> getcopiaLivros() {
        return copiaLivros;
    }

    public void setCopiaLivros(List<CopiaLivro> copiaLivros) {
        this.copiaLivros = copiaLivros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                '}';
    }
}
