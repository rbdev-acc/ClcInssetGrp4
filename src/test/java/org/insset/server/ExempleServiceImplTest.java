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
public class ExempleServiceImplTest {
    
    public ExempleServiceImplTest() {
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
     * Test of inverserChaine method, of class ExempleServiceImpl.
     */
    @Test
    public void testInverserChaine() {
        System.out.println("inverserChaine");
        String input = "allo";
        ExempleServiceImpl instance = new ExempleServiceImpl();
        String expResult = "olla";
        String result = instance.inverserChaine(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
