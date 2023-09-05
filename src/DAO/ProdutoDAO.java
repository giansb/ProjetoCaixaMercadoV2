/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import model.Produto;
import DAO.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gianb
 */
public class ProdutoDAO {
    
    public void cadastrarProduto(Produto produto){
        
            String sql = "INSERT INTO produto (idproduto, nome, preco) VALUES ("
                + "'" + produto.getCodigo() + "',"
                + "'" + produto.getNome()+ "',"
                + "" + produto.getPreco() + ")";
      
            Conexao.executar(sql);
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        
    }
    
    public void  editar(Produto produto){
        String sql = "UPDATE produto SET"
                + " nome = '" + produto.getNome() + "',"
                + "preco = " +produto.getPreco() + ""
                + "WHERE idproduto = " +produto.getCodigo();
        
        Conexao.executar(sql);
    }
    
    public ArrayList<Produto> getProduto(){
        ArrayList<Produto> lista = new ArrayList();
        String sql = "SELECT idproduto,nome, preco FROM produto ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        if(rs != null){
            try{
                while(rs.next()){
                    int codigo = rs.getInt("idproduto");
                    String nome = rs.getString("nome");
                    double preco = rs.getDouble("preco");
                    Produto prod = new Produto(codigo, nome, preco);
                    lista.add(prod);
                }
            } catch(Exception e){
                
            }
        }
        return lista;
    }
    
    public  void excluir(Produto p){
        String sql = "DELETE FROM produto WHERE idproduto = " + p.getCodigo();
        Conexao.executar(sql);
    }
}
