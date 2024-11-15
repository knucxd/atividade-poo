
package com.despesas.model;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tb_despesa")
public class Despesa implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "vencimento", nullable = false)
    private LocalDate vencimento;
    @Column(name = "valor", nullable = false, scale = 2)
    private double valor;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_categoria", nullable = false, referencedColumnName = "id")
    private Categoria categoria;
    @Column(name = "paga", nullable = false)
    private boolean paga;
    //

    public Despesa() {
        this.setId(0);
        this.setVencimento(LocalDate.now());
        this.setValor(0);
        this.setCategoria(null);
        this.setPaga(true);
    }

    public Despesa(int id, LocalDate vencimento, double valor, Categoria categoria, boolean paga) {
        this.setId (id);
        this.setVencimento (vencimento);
        this.setValor (valor);
        this.setCategoria (categoria);
        this.setPaga (paga);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento==null?LocalDate.now():vencimento;
    }

    public void setValor(double valor) {
        this.valor = valor<0?0:valor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria==null?new Categoria():categoria;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getVencimento() {
        return this.vencimento;
    }

    public double getValor() {
        return this.valor;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public boolean isPaga() {
        return this.paga;
    }

    @Override
    public String toString() {
        return "Despesa{" + "vencimento=" + vencimento + ", valor=" + valor + ", paga=" + paga + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Despesa other = (Despesa) obj;
        return this.id == other.id;
    }
    
}
