/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ProdutoDAO;
import controller.PedidoController;
import java.util.ArrayList;

/**
 *
 * @author gianb
 */
public class Pedido {
    private int id;
    private String tipoPagamento;
    private String cpf;
    private String data;
    private double total;
    
    public Pedido(int id, String tipoPagamento, String cpf, double total) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.cpf = cpf;
        this.total = total;
    }

    public Pedido(int id, String tipoPagamento, String cpf, double total, String data) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.cpf = cpf;
        this.data = data;
        this.total = total;
    }
    
    public Pedido(){
        
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void criarPedido(){
        PedidoController pc = new PedidoController();
        pc.criarPedido();
    }
    
    
    
}
