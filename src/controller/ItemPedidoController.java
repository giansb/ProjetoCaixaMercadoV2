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
    //DefaultTableModel model
    public ItemPedido cadastrarItemPedido(int cod, ArrayList<ItemPedido> array){
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
                ip.setQntd(1);
                ip.setPrecoTotal(p.getPreco());
                ip.setIdProduto(p.getCodigo());
                ip.registrarItemPedido(p);
                
            //String[] coluna = {"","","","",""};
            //coluna[0] = String.valueOf(cont);
            //coluna[1] = String.valueOf(ip.getIdProduto());
            //coluna[2] = String.valueOf(ip.getProduto_nome());
            //coluna[3] = String.valueOf(1);
            //coluna[4] = String.valueOf(ip.getPrecoTotal());
            //model.addRow(coluna);
            array.add(ip);
            verificador = true;

            
            
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
    
    public void removerLinhas(DefaultTableModel model){
        cont = 0;
        
            for(int i=0;i<model.getRowCount();i++){
                model.removeRow(0);
            
        }
    }
    
    public void atualizarTabela(DefaultTableModel model, ArrayList<ItemPedido> array){
        for(ItemPedido p : array){
            String[] coluna = {"","","","",""};
            coluna[0] = String.valueOf(cont);
            coluna[1] = String.valueOf(p.getIdProduto());
            coluna[2] = String.valueOf(p.getProduto_nome());
            coluna[3] = String.valueOf(p.getQntd());
            coluna[4] = String.valueOf(p.getPrecoTotal());
            model.addRow(coluna);
            cont++;
        }
    }
    
    
}
