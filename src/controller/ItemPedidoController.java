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
    
    public void cadastrarItemPedido(int cod){
        ItemPedido ip = new ItemPedido();
        Produto pi = new Produto();
        ArrayList<Produto> lista = pi.getProduto();
        
        for(Produto p : lista){
            if(p.getCodigo() == cod){
            ip.registrarItemPedido(p);
            JOptionPane.showMessageDialog(null, "teste");
        }
        }
        
        
    }
    
    
    public void atualizarItemPedido(ItemPedido ip){
        ItemPedidoDAO ipd = new ItemPedidoDAO();
        ipd.editarItemPedido(ip);
    }
    
    
    
    
}
