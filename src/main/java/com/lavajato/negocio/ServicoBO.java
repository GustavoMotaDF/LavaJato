/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.negocio;

import com.lavajato.entidades.Servicos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class ServicoBO {
     private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("LavajatoPU");
    
    public List<Servicos> getServicos() throws Exception{
        List<Servicos>servicos;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        servicos = em.createQuery("from Servicos where ativo = 1").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(servicos==null || servicos.isEmpty() || servicos.equals("") ){
            throw new Exception("Sem Servicos cadastrados!");            
        }
        
        return servicos;
    }
    public void IncluirServico (String nome, String valor) throws Exception{ 
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if(nome==null || nome.isEmpty() || nome.equals("") ){
            throw new Exception("Não foi informado o nome do Servico!"); 
            
        }
        if(valor==null || valor.isEmpty() || valor.equals("") ){
            throw new Exception("Não foi informado o telefone do Servico!");            
        }
        
        Servicos servicos = new Servicos();
        servicos.setNome(nome);         
        servicos.setValor(Double.valueOf(valor));           
        servicos.setAtivo(true);         
        em.persist(servicos);
        em.getTransaction().commit();
        
        em.clear();
        em.close();      
        
        
    }
    
    public void EditarServico (String id, String nome, String valor) throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Servicos servicos = em.find(Servicos.class, Long.valueOf(id));
        servicos.setNome(nome);         
        servicos.setValor(Double.valueOf(valor));
        
        em.merge(servicos);
        em.getTransaction().commit();        
        em.clear();
        em.close();
        
        if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Não foi informado o id do Servico!");            
        }
        if(nome==null || nome.isEmpty() || nome.equals("") ){
            throw new Exception("Não foi informado o nome do Servico!");            
        }
        if(valor==null || valor.isEmpty() || valor.equals("") ){
            throw new Exception("Não foi informado o valor do Servico!");            
        }
                 
    }
    
    public Boolean ExcluirServico(String id)throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Servicos servicos = em.getReference(Servicos.class, Long.valueOf(id));
        em.remove(servicos);
        
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Erro ao desativar Servico, id não foi informado");            
        }
        
        return true;
        
    }
    
    public Servicos getServico(String id)throws Exception{
        Servicos servicos;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        servicos = em.find(Servicos.class,Long.valueOf(id));
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Erro ao Carregar Servico, id não foi informado");            
        }
        
        return servicos;
    }
}


