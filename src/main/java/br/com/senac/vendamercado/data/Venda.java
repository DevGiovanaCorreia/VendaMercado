/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.vendamercado.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 *
 * @author vitor
 */

@Entity
public class Venda {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
       @ManyToOne
      private Cliente cliente;
      private LocalDateTime data_venda;
      private double total;

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getData_venda() {
        return data_venda;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData_venda(LocalDateTime data_venda) {
        this.data_venda = data_venda;
    }

    public void setTotal(double total) {
        this.total = total;
    }
      
      
      
      
      
      
      
      
    
}
