/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vboxuser
 */
public class PourcentageServiceImplTest {
    
    public PourcentageServiceImplTest() {
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
     * Test of DivisionEntier method, of class PourcentageServiceImpl.
     */
    @Test
    public void testDivisionEntier() {
        System.out.println("DivisionEntier");
        Integer Dividende = 10;
        Integer Diviseur = 2;
        PourcentageServiceImpl instance = new PourcentageServiceImpl();
        Integer expResult = 5;
        Integer result = instance.DivisionEntier(Dividende, Diviseur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Pourcentage method, of class PourcentageServiceImpl.
     */
    @Test
    public void testPourcentage() {
        System.out.println("Pourcentage");
        Integer MontantDepart = 100;
        Integer Pourcentage = 50;
        PourcentageServiceImpl instance = new PourcentageServiceImpl();
        String expResult = "Le resultat de " + 100 + " % " + 50 +" est " + 50.0f + ". La difference est de : "+ 50.0f; 
        String result = instance.Pourcentage(MontantDepart, Pourcentage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
