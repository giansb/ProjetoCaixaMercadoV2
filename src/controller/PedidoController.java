/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.Pedido;



public class PedidoController {
    
    public int quantidadePedidos(){
        PedidoDAO pd = new PedidoDAO();
        ArrayList<Pedido> lista = new ArrayList();
        lista = pd.carregarPedidos();
        return lista.size();
    }
    
    public void criarPedido(){
        // caso o ultimo pedido tenha o total 0, ele atualiza a data e usa ele, ao inves de criar um do zero; se não existir nenhum pedido no banco, ele cria um com id 0
        int cont =0;
        if(this.quantidadePedidos()<1){
            cont = 0;
            Pedido p = new Pedido();
            p.setId(cont);
            PedidoDAO pd = new PedidoDAO();
            pd.cadastrarPedido(p);
            
        }else{
            cont = this.quantidadePedidos();
            PedidoDAO pd = new PedidoDAO();
            ArrayList<Pedido> lista = pd.carregarPedidos();
            Pedido p = lista.get(lista.size()-1);
            if(p.getTotal() == 0){
                
            }else{
                Pedido pe = new Pedido();
                p.setId(cont);

                pd.cadastrarPedido(pe);       
            }
        
            
        }
        
        
        
    }
    
}
