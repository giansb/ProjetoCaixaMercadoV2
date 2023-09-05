/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ItemPedidoDAO;
import DAO.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ItemPedido;
import model.Produto;

/**
 *
 * @author 182210120
 */
public class ItemPedidoController {
    
    public ItemPedido cadastrarItemPedido(int cod){
        
        ItemPedido ip = new ItemPedido();
        Produto pi = new Produto();
        ArrayList<Produto> lista = pi.getProduto();
        System.out.println(lista);
        
        for(Produto p : lista){
            if(p.getCodigo() == cod){
                PedidoController pc = new PedidoController();
                ip.setProduto_nome(p.getNome());
                ip.setQntd(ip.getQntd());
                ip.setPrecoTotal(p.getPreco());
            ip.registrarItemPedido(p);
            
            
        }
           
        }
        return ip;
        
    }
    
    
    public void atualizarItemPedido(ItemPedido ip){
        ItemPedidoDAO ipd = new ItemPedidoDAO();
        ipd.editarItemPedido(ip);
    }
    
    public int indiceItemPedido(){
        ItemPedido ip = new ItemPedido();
        int indice = ip.indiceItemPedido();
        return indice;
    }
    
    
}
