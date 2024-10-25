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
public class RomanConverterServiceImplTest {
    
    public RomanConverterServiceImplTest() {
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
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDateYears() {
        System.out.println("convertDateYears");
        String nbr = "01/02/1994";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "I/II/MCMXCIV";
        String result = instance.convertDateYears(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
        System.out.println("convertRomanToArabe");
        String nbr = "XX";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        Integer expResult = 20;
        Integer result = instance.convertRomanToArabe(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertArabeToRoman() {
        System.out.println("convertArabeToRoman");
        Integer nbr = 134;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "CXXXIV";
        String result = instance.convertArabeToRoman(nbr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
