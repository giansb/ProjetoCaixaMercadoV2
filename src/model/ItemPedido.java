/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



public class ItemPedido {
    private int id_has;
    private int id;
    private int idPedido;
    private int idProduto;
    private int qntd;
    private String produto_nome;
    private double precoTotal;

    public ItemPedido(int id_has, int id, int idPedido, int idProduto, int qntd, String produto_nome, double precoTotal) {
        this.id_has = id_has;
        this.id = id;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.qntd = qntd;
        this.produto_nome = produto_nome;
        this.precoTotal = precoTotal;
    }

    public int getId_has() {
        return id_has;
    }

    public void setId_has(int id_has) {
        this.id_has = id_has;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
    
}