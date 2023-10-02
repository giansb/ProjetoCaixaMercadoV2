/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ItemPedidoDAO;
import DAO.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class ItemPedido {
    static int cont = 0;
    private int id_has;
    private int id;
    private int idPedido;
    private int idProduto;
    private int qntd;
    private String produto_nome;
    private double precoTotal;

    public ItemPedido(int id_has,  int idPedido, int idProduto, int qntd, String produto_nome, double precoTotal) {
        this.id_has = id_has;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.qntd = qntd;
        this.produto_nome = produto_nome;
        this.precoTotal = precoTotal;
        boolean verificador;
        
        
    }
    
    public ItemPedido(){
        
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
    

    
    public void AtualizarItemPedido(ItemPedido ip){
        ItemPedidoDAO ipd = new ItemPedidoDAO();
        ipd.editarItemPedido(ip);
        
    }
    
    public int indiceItemPedido(){
        ItemPedidoDAO ip = new ItemPedidoDAO();
        ArrayList<ItemPedido> lista = ip.carregarItensPedido();
        
        int indice = lista.size();
        int ind =0;
        if(indice<1) {
            ind = 0;
        } else {
            for(ItemPedido ipl : lista){
                
                    ind = ipl.getId_has()+1;
                
            }
        }
        return ind;
        
    }
    
        public void registrarItemPedido(Produto p1){
        ItemPedido ip = new ItemPedido();
        Pedido p = new Pedido();
        int ind = this.indiceItemPedido();
        
        
        ip.setIdPedido(p.pedidoAtual());
        ip.setPrecoTotal(p1.getPreco());
        ip.setIdProduto(p1.getCodigo());
        ip.setQntd(1);
        ip.setId_has(ind);
        ip.setId(cont);
        ItemPedidoDAO ipd = new ItemPedidoDAO();
        ipd.cadastrarItemPedido(ip);
        cont++;
    }
        
        public boolean VerificarItemPedido(int cod){
            boolean verificador = false;
            ProdutoDAO pd = new ProdutoDAO();
            ArrayList<Produto> lista = pd.getProduto();
            for(Produto p: lista){
                if(p.getCodigo() == cod){
                    verificador = true;
                }
            }
            if(verificador == false){
                JOptionPane.showMessageDialog(null, "Produto não registrado");
            }
            
            
            return verificador;
            
            
        }
        
        
        
        
        public void removerLinhas(DefaultTableModel model){
        cont = 0;
        
            while(model.getRowCount()>0){
                model.removeRow(0);
            }
    }
        
        public double removerItemPedido(int cod, ArrayList<ItemPedido> array, DefaultTableModel model){
            ItemPedido selecionado = array.get(cod);
            double valor = selecionado.getPrecoTotal();
            array.remove(cod);
            ItemPedidoDAO ipd = new ItemPedidoDAO();
            ipd.excluirItemPedido(selecionado.getId_has());
            
            return valor;
        }
    
}
