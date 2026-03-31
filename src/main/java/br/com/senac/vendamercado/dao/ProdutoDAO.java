/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.vendamercado.dao;

import br.com.senac.vendamercado.data.JPAUtil;
import br.com.senac.vendamercado.data.Produto;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ProdutoDAO {
     public void cadastrar(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();

        em.close();
    }
       public List<Produto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Produto> lista = em.createQuery(
                "FROM Produto", Produto.class
        ).getResultList();

        em.close();
        return lista;
    }

    public Produto buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Produto produto = em.find(Produto.class, id);

        em.close();
        return produto;
    }

    public void atualizar(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();

        em.close();
    }

    public void deletar(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Produto produto = em.find(Produto.class, id);

        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();

        em.close();
    }

    public List<Produto> buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Produto> lista = em.createQuery(
                "FROM Produto p WHERE p.nome LIKE :nome", Produto.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();

        em.close();
        return lista;
    } 
}
