/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.obraesperta.maven.si.entities;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class BancoTest {
    
    public BancoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Banco.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Banco instance = new Banco();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Banco.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Banco instance = new Banco();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodigo method, of class Banco.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Banco instance = new Banco();
        String expResult = "";
        String result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class Banco.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        String codigo = "";
        Banco instance = new Banco();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Banco.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Banco instance = new Banco();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Banco.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Banco instance = new Banco();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSite method, of class Banco.
     */
    @Test
    public void testGetSite() {
        System.out.println("getSite");
        Banco instance = new Banco();
        String expResult = "";
        String result = instance.getSite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSite method, of class Banco.
     */
    @Test
    public void testSetSite() {
        System.out.println("setSite");
        String site = "";
        Banco instance = new Banco();
        instance.setSite(site);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgencias method, of class Banco.
     */
    @Test
    public void testGetAgencias() {
        System.out.println("getAgencias");
        Banco instance = new Banco();
        Collection<BancoAgencia> expResult = null;
        Collection<BancoAgencia> result = instance.getAgencias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgencias method, of class Banco.
     */
    @Test
    public void testSetAgencias() {
        System.out.println("setAgencias");
        Collection<BancoAgencia> agencias = null;
        Banco instance = new Banco();
        instance.setAgencias(agencias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Banco.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Banco instance = new Banco();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Banco.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Banco instance = new Banco();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Banco.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Banco instance = new Banco();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCnpjBase method, of class Banco.
     */
    @Test
    public void testGetCnpjBase() {
        System.out.println("getCnpjBase");
        Banco instance = new Banco();
        String expResult = "";
        String result = instance.getCnpjBase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCnpjBase method, of class Banco.
     */
    @Test
    public void testSetCnpjBase() {
        System.out.println("setCnpjBase");
        String cnpjBase = "";
        Banco instance = new Banco();
        instance.setCnpjBase(cnpjBase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
