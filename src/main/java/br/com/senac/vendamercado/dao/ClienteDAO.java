/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.vendamercado.dao;

import br.com.senac.vendamercado.data.Cliente;
import br.com.senac.vendamercado.data.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author vitor
 */
public class ClienteDAO {
      public void cadastrar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        em.close();
    }
       public List<Cliente> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Cliente> lista = em.createQuery(
                "FROM Cliente", Cliente.class
        ).getResultList();

        em.close();
        return lista;
    }

    public Cliente buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Cliente cliente = em.find(Cliente.class, id);

        em.close();
        return cliente;
    }

    public void atualizar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();

        em.close();
    }

    public void deletar(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        Cliente cliente = em.find(Cliente.class, id);

        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();

        em.close();
    }

    public List<Cliente> buscarPorNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Cliente> lista = em.createQuery(
                "FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();

        em.close();
        return lista;
    }
}
