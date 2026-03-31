/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.vendamercado.dao;

import br.com.senac.vendamercado.data.Item_venda;
import br.com.senac.vendamercado.data.JPAUtil;
import br.com.senac.vendamercado.data.Produto;
import br.com.senac.vendamercado.data.Venda;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author vitor
 */
public class VendaDAO {
    
    public void salvarVendaCompleta(Venda venda, List<Item_venda> itens) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            
            em.persist(venda);

           
            for (Item_venda item : itens) {
                item.setVenda(venda);
                em.persist(item);

                Produto p = item.getProduto();
                p.setEstoque(p.getEstoque() - item.getQuantidade());
                em.merge(p);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    
    public List<Venda> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Venda> lista = em.createQuery(
                "FROM Venda", Venda.class
        ).getResultList();

        em.close();
        return lista;
    }

 
    public Venda buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Venda venda = em.find(Venda.class, id);

        em.close();
        return venda;
    }

   
    public void atualizar(Venda venda) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(venda);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    
    public void deletar(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Venda venda = em.find(Venda.class, id);

        if (venda != null) {
            try {
                em.getTransaction().begin();
                em.remove(venda);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        }

        em.close();
    }

    
    public List<Venda> listarComItens() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Venda> lista = em.createQuery(
                "SELECT DISTINCT v FROM Venda v LEFT JOIN FETCH v.itens",
                Venda.class
        ).getResultList();

        em.close();
        return lista;
    }

  
    public List<Venda> ultimasVendas() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Venda> lista = em.createQuery(
                "FROM Venda v ORDER BY v.dataVenda DESC",
                Venda.class
        )
        .setMaxResults(10)
        .getResultList();

        em.close();
        return lista;
    }
}

