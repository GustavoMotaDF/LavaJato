/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.entidades;

import java.io.Serializable;
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
@SQLDelete(sql = "update tb_caixa set ativo = 1 where id = ?")
@Table(name="tb_caixa")
public class Caixa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idvenda;
    
    @Column(name="formato")
    private String formato;
    
    @ManyToOne
    @JoinColumn(name="id_servico")
    private Servicos servico;
    
    @Column(name="valortotal")
    private Double valortotal;
    
    @Column(name="data_hora_venda")
    private LocalDateTime dahoravenda;
    
    @Column(name="data_hora_ult_mod")
    private LocalDateTime datahoraultmod;
    
    private Boolean ativo;

    public LocalDateTime getDahoravenda() {
        return dahoravenda;
    }

    public void setDahoravenda(LocalDateTime dahoravenda) {
        this.dahoravenda = dahoravenda;
    }

    public LocalDateTime getDatahoraultmod() {
        return datahoraultmod;
    }

    public void setDatahoraultmod(LocalDateTime datahoraultmod) {
        this.datahoraultmod = datahoraultmod;
    }
    

    public Long getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Long idvenda) {
        this.idvenda = idvenda;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idvenda);
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
        final Caixa other = (Caixa) obj;
        if (!Objects.equals(this.idvenda, other.idvenda)) {
            return false;
        }
        return true;
    }

    public Caixa(Long idvenda, String formato, Servicos servico, Double valortotal, LocalDateTime dahoravenda, LocalDateTime datahoraultmod, Boolean ativo) {
        this.idvenda = idvenda;
        this.formato = formato;
        this.servico = servico;
        this.valortotal = valortotal;
        this.dahoravenda = dahoravenda;
        this.datahoraultmod = datahoraultmod;
        this.ativo = ativo;
    }

     

    public Caixa() {
    }
    
    
    
}
