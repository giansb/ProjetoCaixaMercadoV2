/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author gianb
 */
public class ProdutoController {
    private Produto p ;
    
    
    public ArrayList<Produto> carregarProdutos(){
        Produto p = new Produto();
        return p.carregarProdutos();
    }

    public static Produto procurarProduto(int cod){
        Produto p = new Produto();
        return p.procurarProduto(cod);
    }
    
    public void RemoverProduto(int cod){
        Produto p = new Produto();
        boolean ver = p.RemoverProduto(cod);
        
        if(ver == true){
            JOptionPane.showMessageDialog(null, "Produto removido");
        } else{
            JOptionPane.showMessageDialog(null, "Ops! Erro na remoção do produto");
        }
        
    }
    
    public void editarProduto(Produto produto){
        Produto p = new Produto();
        boolean ver = p.editarProduto(produto);
        
        if(ver == true){
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
        } else{
            JOptionPane.showMessageDialog(null, "Ops! Erro na atualização do produto");
        }
        
    }
    
      public void cadastrarProduto(Produto produto){
        Produto p = new Produto();
        boolean ver = p.cadastrarProduto(produto);
        
        if(ver == true){
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        } else{
            JOptionPane.showMessageDialog(null, "Ops! Erro no cadastro do produto");
        }
    }
      
   
    
}
    
    
    
    

