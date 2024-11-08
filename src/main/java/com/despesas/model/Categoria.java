
package com.despesas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    //
    public Categoria() {
        this.setId(0);
        this.setNome("sem nome");
    }

    public Categoria(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }
    
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"SEM NOME":nome.toUpperCase();
    }

    @Override
    public String toString() {
        return "Categoria{" + "nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        return this.id == other.id;
    }
    
    
}
