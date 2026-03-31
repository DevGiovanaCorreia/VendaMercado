/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.vendamercado.dao;

import br.com.senac.vendamercado.data.Item_venda;
import br.com.senac.vendamercado.data.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author vitor
 */
public class Item_vendaDAO {
      public void cadastrar(Item_venda item) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

   
    public List<Item_venda> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Item_venda> lista = em.createQuery(
                "FROM Item_venda", Item_venda.class
        ).getResultList();

        em.close();
        return lista;
    }

   
    public Item_venda buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Item_venda item = em.find(Item_venda.class, id);

        em.close();
        return item;
    }


    public void atualizar(Item_venda item) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(item);
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

        Item_venda item = em.find(Item_venda.class, id);

        if (item != null) {
            try {
                em.getTransaction().begin();
                em.remove(item);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        }

        em.close();
    }

 
    public List<Item_venda> buscarPorVenda(int vendaId) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Item_venda> lista = em.createQuery(
                "FROM Item_venda iv WHERE iv.venda.id = :id",
                Item_venda.class)
                .setParameter("id", vendaId)
                .getResultList();

        em.close();
        return lista;
    }

    
    public List<Item_venda> buscarPorProduto(int produtoId) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Item_venda> lista = em.createQuery(
                "FROM Item_venda iv WHERE iv.produto.id = :id",
                Item_venda.class)
                .setParameter("id", produtoId)
                .getResultList();

        em.close();
        return lista;
    }
}
