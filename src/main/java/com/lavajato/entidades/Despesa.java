/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;

/**
 *
 * @author gustavo
 */
@Entity
//@SQLDelete(sql = "update tb_despesas set ativo = 1 where id = ?")
@Table(name="tb_despesas")
public class Despesa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="despesa")
    private String despesa;
    @Column(name="valor")
    private Double valor;
    @Column(name="tipodespesa")
    private String tipodespesa;
    @Column(name="data_despesa")
    private LocalDate datadespesa;
    
    @ManyToOne
    @JoinColumn(name="nome")
    private Funcionario funcionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipodespesa() {
        return tipodespesa;
    }

    public void setTipodespesa(String tipodespesa) {
        this.tipodespesa = tipodespesa;
    }

    public LocalDate getDatadespesa() {
        return datadespesa;
    }

    public void setDatadespesa(LocalDate datadespesa) {
        this.datadespesa = datadespesa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Despesa(Long id, String despesa, Double valor, String tipodespesa, LocalDate datadespesa, Funcionario funcionario) {
        this.id = id;
        this.despesa = despesa;
        this.valor = valor;
        this.tipodespesa = tipodespesa;
        this.datadespesa = datadespesa;
        this.funcionario = funcionario;
    }

    public Despesa() {
    }
    
    
    
}
