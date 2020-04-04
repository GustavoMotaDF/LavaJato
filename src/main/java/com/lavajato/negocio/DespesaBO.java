/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.negocio;

import com.lavajato.entidades.Caixa;
import com.lavajato.entidades.Despesa;
import com.lavajato.entidades.Funcionario;
import com.lavajato.entidades.Servicos;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.SimpleFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class DespesaBO {
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("LavajatoPU");
    
    public List<Despesa> getDespesas() throws Exception{
        List<Despesa>despesas;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        despesas = em.createQuery("from Despesa").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(despesas==null || despesas.isEmpty() || despesas.equals("") ){
            throw new Exception("Sem Despesas cadastrados!");            
        }
        
        return despesas;
    }
    public void InserirDespesa (String despesa, String valor, String tipodespesa, String datadespesa) throws Exception{ 
        EntityManager em = emf.createEntityManager();
         
        
        em.getTransaction().begin();
        
        Despesa despesas = new Despesa();       
        despesas.setDespesa(despesa);
        despesas.setValor(Double.valueOf(valor));
        despesas.setTipodespesa(tipodespesa);         
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(datadespesa,formatter); 
        despesas.setDatadespesa(date);
        em.persist(despesas);
        em.getTransaction().commit();
        
        em.clear();
        em.close();      
        
        
    }
    
     public void EditarDespesa (String id, String despesa, String valor, String tipodespesa, String datadespesa) throws Exception{
        EntityManager em = emf.createEntityManager();
        
        if(despesa==null || despesa.isEmpty() || despesa.equals("") ){
            throw new Exception ("Não foi informado o nome da Despesa!"); 
            
        }
        if(valor==null || valor.isEmpty() || valor.equals("") ){
            throw new Exception("Não foi informado o valor da Despesa!");            
        }
        if(tipodespesa==null || tipodespesa.isEmpty() || tipodespesa.equals("") ){
            throw new Exception("Não foi informado o tipo de despesa da Despesa!");            
        }
        
        em.getTransaction().begin();
        
        Despesa despesas = em.find(Despesa.class, Long.valueOf(id));       
        despesas.setDespesa(despesa);
        despesas.setValor(Double.valueOf(valor));
        despesas.setTipodespesa(tipodespesa);         
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(datadespesa,formatter); 
        despesas.setDatadespesa(date);
        em.persist(despesas);
        em.getTransaction().commit();
        
        em.clear();
        em.close();      
        
                          
    }
     
     public Boolean ExcluirDespesa(String id)throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Despesa despesa = em.getReference(Despesa.class, Long.valueOf(id));
        em.remove(despesa);
        
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Erro ao Excluir Despesa, id não informado");            
        }
        
        return true;
        
    }
     
      public Despesa getDespesa(String id)throws Exception{
       
        EntityManager em = emf.createEntityManager();
         if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Erro ao carregar Despesa, id não foi informado");            
        }
        em.getTransaction().begin();
        
        Despesa despesa = em.find(Despesa.class,Long.valueOf(id));
        em.getTransaction().commit();
        em.clear();
        em.close();
        
       
        
        return despesa;
    }
}
