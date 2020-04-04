/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lavajato.negocio;

import com.lavajato.entidades.Caixa;
import com.lavajato.entidades.Servicos;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gustavo
 */
public class CaixaBO {
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("LavajatoPU");
    
    public List<Caixa> getCaixa() throws Exception{
        List<Caixa>caixa;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        caixa = em.createQuery("from Caixa").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(caixa==null || caixa.isEmpty() || caixa.equals("") ){
            throw new Exception("Sem Caixa cadastrados!");            
        }
        
        return caixa;
    }
    public void RealizarVenda (String idservico, String formato) throws Exception{ 
        EntityManager em = emf.createEntityManager();
        if(idservico==null || idservico.isEmpty() || idservico.equals("") ){
            throw new Exception ("Não foi informado o nome do Servico!"); 
            
        }
        if(formato==null || formato.isEmpty() || formato.equals("") ){
            throw new Exception("Não foi informado o telefone do Servico!");            
        }
        
        em.getTransaction().begin();
        
        Caixa caixa = new Caixa();
        Servicos servico = em.find(Servicos.class, Long.valueOf(idservico));
        caixa.setServico(servico);         
        caixa.setFormato(formato);
        caixa.setDahoravenda(LocalDateTime.now());
        caixa.setAtivo(true);
        em.persist(caixa);
        em.getTransaction().commit();
        
        em.clear();
        em.close();      
        
        
    }
    
    public void EditarVenda (String idvenda, String idservico, String formato) throws Exception{
        EntityManager em = emf.createEntityManager();
        
        if(idservico==null || idservico.isEmpty() || idservico.equals("") ){
            throw new Exception("Não foi informado o nome do Servico!"); 
            
        }
        if(formato==null || formato.isEmpty() || formato.equals("") ){
            throw new Exception("Não foi informado o formato de Pagamento!");            
        }
        
        em.getTransaction().begin();
        Caixa caixa = em.find(Caixa.class, Long.valueOf(idvenda));
        Servicos servico = em.find(Servicos.class, Long.valueOf(idservico));
        caixa.setServico(servico);         
        caixa.setFormato(formato);
        caixa.setDatahoraultmod(LocalDateTime.now());
        em.merge(caixa);
        em.getTransaction().commit();        
        em.clear();
        em.close();
         
                 
    }
    
    public Boolean ExcluirVenda(String idvenda)throws Exception{
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Caixa caixa = em.getReference(Caixa.class, Long.valueOf(idvenda));
        em.remove(caixa);
        
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(idvenda==null || idvenda.isEmpty() || idvenda.equals("") ){
            throw new Exception("Erro ao desativar Venda, id não foi informado");            
        }
        
        return true;
        
    }
    
    public Caixa getVenda(String idvenda)throws Exception{
        Caixa caixa;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        caixa = em.find(Caixa.class,Long.valueOf(idvenda));
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(idvenda==null || idvenda.isEmpty() || idvenda.equals("") ){
            throw new Exception("Erro ao carregar Venda, id não foi informado");            
        }
        
        return caixa;
    }
    public List<Caixa> relatorioAno() throws Exception{
        List<Caixa>caixa;
        int ano = LocalDateTime.now().getYear();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        caixa = em.createNativeQuery("select DISTINCT Year(ca.data_hora_venda), SUM(ser.valor) from tb_caixa ca join tb_servico ser ON ca.id_servico = ser.id GROUP BY Year(ca.data_hora_venda) order by year(ca.data_hora_venda)").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
         if(caixa==null){
            throw new Exception("Sem registros!");            
        }
        
        return caixa;
    }
    public List<Caixa> relatorioMes() throws Exception{
        List<Caixa>caixa;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        caixa = em.createNativeQuery("select DISTINCT YEAR(now()), count(DISTINCT ca.id), monthname(ca.data_hora_venda), sum(ser.valor) from tb_caixa ca join tb_servico ser on ca.id_servico = ser.id where year(now()) group by  year(ca.data_hora_venda), monthname(ca.data_hora_venda) ORDER By month(ca.data_hora_venda)").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
         if(caixa==null){
            throw new Exception("Sem Caixa cadastrados!");            
        }
        
        return caixa;
    }
    public List<Caixa> relatorio7Dias() throws Exception{
        List<Caixa>caixa;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        caixa = em.createNativeQuery("SELECT ser.nome, ca.data_hora_venda, ca.formato, ser.valor FROM tb_caixa ca join tb_servico ser on ca.id_servico = ser.id WHERE data_hora_venda BETWEEN TIMESTAMP(DATE_SUB(NOW(), INTERVAL 7 day)) AND NOW() order by ca.data_hora_venda").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(caixa==null){
            throw new Exception("Sem Registros");            
        }
        
        return caixa;
    }
    public List<Caixa> relatorioOntem() throws Exception{
        List<Caixa>caixa;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        caixa = em.createNativeQuery("SELECT ser.nome, ca.data_hora_venda, ca.formato, ser.valor FROM tb_caixa ca join tb_servico ser on ca.id_servico = ser.id where date(data_hora_venda) = date(now())-1 order by ca.data_hora_venda;").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
        if(caixa==null){
            throw new Exception("Sem Registros");            
        }
        
        return caixa;
    }
    public List<Caixa> relatorioHoje() throws Exception{
        List<Caixa>caixa;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        caixa = em.createNativeQuery("SELECT ser.nome, ca.data_hora_venda, ca.formato, ser.valor FROM tb_caixa ca join tb_servico ser on ca.id_servico = ser.id where date(data_hora_venda) = date(now()) order by ca.data_hora_venda").getResultList();
        em.getTransaction().commit();
        em.clear();
        em.close();
        
         if(caixa==null){
            throw new Exception("Sem Registros");            
        }
        
        return caixa;
    }
    
}


