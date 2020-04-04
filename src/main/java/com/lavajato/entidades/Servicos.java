/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.entidades;

import java.io.Serializable;
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
@SQLDelete(sql = "update tb_servico set ativo = 0 where id = ?")
@Table(name="tb_servico")
public class Servicos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="valor")
    private Double valor;
    
    private Boolean ativo;
    
    @OneToMany(mappedBy = "servico")
    private List<Caixa> caixa ;

    public List<Caixa> getCaixa() {
        return caixa;
    }

    public void setCaixa(List<Caixa> caixa) {
        this.caixa = caixa;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Servicos other = (Servicos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Servicos(Long id, String nome, Double valor, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ativo = ativo;
    }
    
     public Servicos(){
         
     }
    
}
