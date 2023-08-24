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
    
    
    public static ArrayList<Produto> carregarProdutos(){
        
        
        ProdutoDAO p = new ProdutoDAO();
        return p.getProduto();
    }
    
    
    public void cadastrarProduto(Produto produto){
        ProdutoDAO p = new ProdutoDAO();
        p.cadastrarProduto(produto);
    }
    
    
    
    
    
    
    public static Produto procurarProduto(int cod){
        ArrayList<Produto> lista = carregarProdutos();
         for(Produto pe:lista){
                if(pe.getCodigo() == cod){
                    return pe;
                }
                else{
                    
                }
                
         }
         JOptionPane.showMessageDialog(null, "ID do produto não encontrado");
         return null;
    }
    
    public void RemoverProduto(int cod){
        ArrayList<Produto> lista = carregarProdutos();
        Produto p = ProdutoController.procurarProduto(cod);
        ProdutoDAO pd = new ProdutoDAO();
        pd.excluir(p);
        JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
        
    }
    
    public void editarProduto(Produto produto){
        ProdutoDAO p = new ProdutoDAO();
        p.editar(produto);
        JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
    }
    
}
    
    
    
    

