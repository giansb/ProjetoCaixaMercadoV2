/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.ProdutoDAO;
import controller.ProdutoController;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gianb
 */
public class Produto {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    public Produto(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public ArrayList<Produto> getProduto(){
        ProdutoDAO p = new ProdutoDAO();
        return p.getProduto();
        
    }
    
    public boolean RemoverProduto(int cod){
        boolean verificador = false;
        ArrayList<Produto> lista = carregarProdutos();
        Produto p = ProdutoController.procurarProduto(cod);
        ProdutoDAO pd = new ProdutoDAO();
        try {
            pd.excluir(p);
            verificador = true;
        } catch (Exception e) {
            
        }
        return verificador;
        
    }
    
    public boolean editarProduto(Produto produto){
        boolean verificador = false;
        ProdutoDAO p = new ProdutoDAO();
        try {
            p.editar(produto);
            verificador = true;
        } catch (Exception e) {
            
        }
        return verificador;
    }
    
    public boolean cadastrarProduto(Produto produto){
        boolean verificador = false;
        try {
            ProdutoDAO p = new ProdutoDAO();
            p.cadastrarProduto(produto);
            verificador = true;
        } catch (Exception e) {
            
        }
        return verificador;
    }
    
    public ArrayList<Produto> carregarProdutos(){
        
        
        ProdutoDAO p = new ProdutoDAO();
        return p.getProduto();
    }
    
    
    
    

}
