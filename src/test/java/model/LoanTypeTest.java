/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author ASUS
 */
public class LoanTypeTest {
    
    public LoanTypeTest() {
    }


    @Test
    public void testGetId() {
        LoanType instance = new LoanType();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetId() {
        int id = 0;
        LoanType instance = new LoanType();
        instance.setId(id);

    }
//    @Test
//    public void testSetIdIllegal() {
//        int i = -1;
//        LoanType instance = new LoanType();
//        Exception ex = Assertions.assertThrows(Exception.class,()->instance.setId(i));
//    }

    @Test
    public void testGetName() {
        LoanType instance = new LoanType();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetName() {
        String name = "";
        LoanType instance = new LoanType();
        instance.setName(name);
        String expected = "";
        assertEquals(expected, instance.getName());

    }

    @Test
    public void testGetDescription() {
        LoanType instance = new LoanType();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetDescription() {
        String description = "";
        LoanType instance = new LoanType();
        instance.setDescription(description);
        String expected = "";
        assertEquals(expected, instance.getDescription());

    }

    @Test
    public void testGetRate() {
        LoanType instance = new LoanType();
        double expResult = 0.0;
        double result = instance.getRate();
        assertEquals(expResult, result, 0.0);
 
    }

    @Test
    public void testSetRate() {
        double rate = 0.0;
        LoanType instance = new LoanType();
        instance.setRate(rate);
        double expected = 0.0;
        assertEquals(expected, instance.getRate(), 0.0);
    
    }
    @Test
    public void testSetRateIlegal() {
        double rate = -5;
        LoanType instance = new LoanType();
        Exception ex = Assertions.assertThrows(Exception.class,()->instance.setRate(rate));
        
    }

    @Test
    public void testGetDuration() {
        LoanType instance = new LoanType();
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
   
    }

    @Test
    public void testSetDuration() {
        int duration = 0;
        LoanType instance = new LoanType();
        instance.setDuration(duration);
        int expected = 0;
        assertEquals(expected, instance.getDuration());
       
    }
    @Test
    public void testSetDurationIlegal() {
        int duration = -5;
        LoanType instance = new LoanType();
        Exception ex = Assertions.assertThrows(Exception.class,()->instance.setDuration(duration));
        
    }

    

   
    
}
