/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gianb
 */
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
    
    
    public void cadastrarItemPedido(ItemPedido ip){
        String sql = "INSERT INTO produto_has_pedido(id_produto_has_pedido, qtd, precototal, produto_idproduto, pedido_idpedido) VALUES("
                + "" + ip.getId_has() + ","
                + "" + ip.getQntd() + ","
                + "" + ip.getPrecoTotal() + ","
                + "" + ip.getIdProduto() + ","
                + "" + ip.getIdPedido() + ")";
        Conexao.executar(sql);
    }
    public void editarItemPedido(ItemPedido ip){
        String sql = "UPDATE produto_has_pedido SET"
                + "produto_idproduto = " + ip.getIdProduto() + ","
                + "pedido_idpedido = " + ip.getIdPedido() + ","
                + "qtd = " + ip.getQntd() + ","
                + "precototal = " + ip.getPrecoTotal() + ","
                + "WHERE id_produto_has_pedido = " + ip.getId_has();
        Conexao.executar(sql);
    }
    
    public void excluirItemPedido(int cod){
        String sql = "DELETE FROM produto_has_pedido WHERE id_produto_has_pedido = " + cod;
        Conexao.executar(sql);
    }
    
    public static ArrayList<ItemPedido> carregarItensPedido(){
        ArrayList<ItemPedido> lista = new ArrayList();
        String sql = "SELECT produto_has_pedido.id_produto_has_pedido, produto_has_pedido.pedido_idpedido, produto.nome, produto.idproduto, pedido.idpedido, produto_has_pedido.qtd, produto_has_pedido.precototal FROM produto_has_pedido, produto, pedido"
                    + "WHERE produto_has_pedido.pedido_idpedido = pedido.idpedido AND produto_has_pedido.produto_idproduto = produto.idproduto"
                    + "ORDER BY id_produto_has_pedido";
        ResultSet rs = Conexao.consultar(sql);
        
        if(rs != null){
            try {
                int cont = 0;
                while(rs.next()){
                    int cod = rs.getInt("produto_has_pedido.id_produto_has_pedido");
                    String produto_nome = rs.getString("produto.nome");
                    int id_produto = rs.getInt("produto.idproduto");
                    int id_pedido = rs.getInt("pedido.idpedido");
                    int qtd = rs.getInt("produto_has_pedido.qtd");
                    double preco_total = rs.getDouble("produto_has_pedido.precototal");
                    
                    ItemPedido ip = new ItemPedido(cod,cont,id_produto,id_pedido,qtd,produto_nome,preco_total);
                    lista.add(ip);
                    cont++;
                    
                }
            } catch (Exception e) {
            }
        }
        return lista;
    }
    
}
