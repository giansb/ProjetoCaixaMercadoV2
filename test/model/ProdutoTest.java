/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


/**
 *
 * @author gianb
 */
@FixMethodOrder(MethodSorters.JVM)
public class ProdutoTest {
    
    Produto p;
    
    public ProdutoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        p = new Produto();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of cadastrarProduto method, of class Produto.
     */
   
    
    /**
     * Test of editarProduto method, of class Produto.
     */
    
    @Test
    public void testCadastrarProduto() {
        System.out.println("cadastrarProduto");
        Produto produto = new Produto(999, "produto teste", 39);
        assertEquals(true, p.cadastrarProduto(produto));
        
    }
    
    @Test
    public void testEditarProduto() {
        System.out.println("editarProduto");
        Produto produto = new Produto(999, "produto teste", 200);
        assertEquals(true, p.editarProduto(produto));
    }

   @Test
    public void testRemoverProduto() {
        System.out.println("RemoverProduto");
        
        assertEquals(true, p.RemoverProduto(999));
    }
    
     

    

    

    
    
}
