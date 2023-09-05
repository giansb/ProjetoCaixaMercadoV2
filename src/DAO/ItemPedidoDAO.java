/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.ItemPedido;

/**
 *
 * @author 182210120
 */
public class ItemPedidoDAO {
    
    
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
                + "WHERE produto_idproduto = " + ip.getId_has();
        
        Conexao.executar(sql);
        
    }
    
    public void excluirItemPedido(int cod){
        String sql = "DELETE FROM produto_has_pedido WHERE id_produto_has_pedido = " + cod;
        Conexao.executar(sql);
    }
    
    public ArrayList<ItemPedido> carregarItensPedido(){
        ArrayList<ItemPedido> lista = new ArrayList();
        String sql = "SELECT produto_has_pedido.id_produto_has_pedido, produto_has_pedido.pedido_idpedido, produto.nome, produto.idproduto, produto_has_pedido.qtd, produto_has_pedido.precototal, pedido.idpedido FROM produto_has_pedido, produto, pedido"
                    + " WHERE produto_has_pedido.pedido_idpedido = pedido.idpedido AND produto_has_pedido.produto_idproduto = produto.idproduto"
                    + " ORDER BY id_produto_has_pedido";
        System.out.println("abcd");
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
                    
                    ItemPedido ip = new ItemPedido(cod,id_produto,id_pedido,qtd,produto_nome,preco_total);
                    lista.add(ip);
                    cont++;
                    
                }
            } catch (Exception e) {
            }
        }
        return lista;
    }
}
