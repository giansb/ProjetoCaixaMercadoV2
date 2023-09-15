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
import javax.swing.table.DefaultTableModel;
import model.ItemPedido;
import model.Produto;

/**
 *
 * @author 182210120
 */
public class ItemPedidoController {
    static int cont = 0;
    
    public ItemPedido cadastrarItemPedido(int cod, DefaultTableModel model){
        boolean verificador = false;
        
        ItemPedido ip = new ItemPedido();
        Produto pi = new Produto();
        ArrayList<Produto> lista = pi.getProduto();
        System.out.println(lista);
        
        for(Produto p : lista){
            if(p.getCodigo() == cod){
                PedidoController pc = new PedidoController();
                ip.setId_has(this.indiceItemPedido());
                ip.setProduto_nome(p.getNome());
                ip.setQntd(ip.getQntd());
                ip.setPrecoTotal(p.getPreco());
                ip.setIdProduto(p.getCodigo());
                ip.registrarItemPedido(p);
                
            String[] coluna = {"","","","",""};
            coluna[0] = String.valueOf(cont);
            coluna[1] = String.valueOf(ip.getIdProduto());
            coluna[2] = String.valueOf(ip.getProduto_nome());
            coluna[3] = String.valueOf(1);
            coluna[4] = String.valueOf(ip.getPrecoTotal());
            model.addRow(coluna);
            verificador = true;
            cont++;
            
            
        }
           
        }
        
        if(!verificador){
                JOptionPane.showMessageDialog(null, "nenhum item cadastrado com esse codigo");
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
