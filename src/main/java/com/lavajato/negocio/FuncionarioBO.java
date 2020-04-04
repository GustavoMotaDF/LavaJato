/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.negocio;

import com.lavajato.entidades.Funcionario;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class FuncionarioBO {
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("LavajatoPU");
    
    public List<Funcionario> getFuncionarios() throws Exception{
        List<Funcionario>funcionarios;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        funcionarios = em.createQuery("from Funcionario where ativo = 1").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(funcionarios==null || funcionarios.isEmpty() || funcionarios.equals("") ){
            throw new Exception("Sem Funcionarios cadastrados!");            
        }
        
        return funcionarios;
    }
    public void IncluirFuncionario (String nome, String telefone, String salario) throws Exception{ 
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if(nome==null || nome.isEmpty() || nome.equals("") ){
            throw new Exception("Não foi informado o nome do Funcionario!"); 
            
        }
        if(telefone==null || telefone.isEmpty() || telefone.equals("") ){
            throw new Exception("Não foi informado o telefone do Funcionario!");            
        }
        if(salario==null || salario.isEmpty() || salario.equals("") ){
            throw new Exception("Não foi informado o salario do Funcionario!");            
        }
        Funcionario funcionarios = new Funcionario();
        funcionarios.setNome(nome);
        funcionarios.setTelefone(Long.valueOf(telefone));
        funcionarios.setSalario(Double.valueOf(salario));   
        funcionarios.setDatacadastramento(LocalDate.now());
        funcionarios.setAtivo(true);
         
        em.persist(funcionarios);
        em.getTransaction().commit();
        
        em.clear();
        em.close();
        
        
        
    }
    
    public void EditarFuncionario (String id, String nome, String telefone, String salario) throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Funcionario funcionarios = em.find(Funcionario.class, Long.valueOf(id));
        funcionarios.setNome(nome);
        funcionarios.setTelefone(Long.valueOf(telefone));
        funcionarios.setSalario(Double.valueOf(salario));
        
        em.merge(funcionarios);
        em.getTransaction().commit();        
        em.clear();
        em.close();
        
        if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Não foi informado o id do Funcionario!");            
        }
        if(nome==null || nome.isEmpty() || nome.equals("") ){
            throw new Exception("Não foi informado o nome do Funcionario!");            
        }
        if(telefone==null || telefone.isEmpty() || telefone.equals("") ){
            throw new Exception("Não foi informado o telefone do Funcionario!");            
        }
        if(salario==null || salario.isEmpty() || salario.equals("") ){
            throw new Exception("Não foi informado o salario do Funcionario!");            
        }
        
    }
    
    public Boolean ExcluirFuncionario(String id)throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Funcionario funcionario = em.getReference(Funcionario.class, Long.valueOf(id));
        em.remove(funcionario);
        
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Erro ao desativar Funcionario, id não foi informado");            
        }
        
        return true;
        
    }
    
    public Funcionario getFuncionario(String id)throws Exception{
        Funcionario funcionario;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        funcionario = em.find(Funcionario.class,Long.valueOf(id));
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(id==null || id.isEmpty() || id.equals("") ){
            throw new Exception("Erro ao desativar Funcionario, id não foi informado");            
        }
        
        return funcionario;
    }
}
