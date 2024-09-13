/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package podcast.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author agnal
 */
public class podcDAO {
      public void cadastrar(podc p) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPA.closeEtityManager();
        }
    }

    public List<podc> listar (String filtroDescricao, String dataIni, String dataFim){
        EntityManager em =JPA.getEntityManager();
        List despesas = null;
        try {
            
            String textoQuery = "select d from Despesa d "
                    + " WHERE (:descricaoFiltro is null OR d.descricao LIKE :descricaoFiltro) "
                    + " AND (:dataInicialFiltro is null OR d.data>= :dataInicialFiltro)"
                    + " AND (:dataFinalFiltro is null OR d.data<= :dataFinalFiltro)";
                    
            Query consulta = em.createQuery(textoQuery);
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/y");
            
            consulta.setParameter("descricaoFiltro", filtroDescricao.isEmpty() ? null : "%" + filtroDescricao + "%");
            consulta.setParameter("dataInicialFiltro", dataIni.isEmpty() ? null : LocalDate.parse(dataIni,formatter));
            consulta.setParameter("dataFinalFiltro", dataFim.isEmpty() ? null : LocalDate.parse(dataFim,formatter));
            
            despesas = consulta.getResultList();
            
            
            
        } finally {
            JPA.closeEtityManager();
        }        
        return despesas;
    }
      
    public podc obter(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            return em.find(podc.class, id);
        } finally {
            JPA.closeEtityManager();
        }
    }    
    
    //construir os demais métodos do CRUD
    public void excluir(int id) {
        EntityManager em = JPA.getEntityManager();
        try {
            podc p = em.find(podc.class, id);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPA.closeEtityManager();
        }
    }

    public void atualizar(podc p) {
        EntityManager em = JPA.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPA.closeEtityManager();
        }
    }
    
    
}
