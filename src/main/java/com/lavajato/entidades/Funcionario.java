/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;

/**
 *
 * @author gustavo
 */

@Entity
@SQLDelete(sql = "update tb_funcionario set ativo = 0 where id = ?")
@Table(name="tb_funcionario")
public class Funcionario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="telefone")
    private Long telefone;
    
    @Column(name="salario")
    private Double salario;
    
    @Column(name="data_cadastramento")
    private LocalDate datacadastramento;
    
    @OneToMany(mappedBy = "funcionario")
    private List<Despesa> despesas ;
    
    private Boolean ativo;

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }    

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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDatacadastramento() {
        return datacadastramento;
    }

    public void setDatacadastramento(LocalDate datacadastramento) {
        this.datacadastramento = datacadastramento;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Funcionario(Long id, String nome, Long telefone, LocalDate datacadastramento, Double salario) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.datacadastramento = datacadastramento;
        this.salario = salario;
    }

    public Funcionario() {
        
    }
         
}
