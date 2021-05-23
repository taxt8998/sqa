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
public class DepositTypeTest {
    
    public DepositTypeTest() {
    }

    

    @Test
    public void testGetId() {      
        DepositType instance = new DepositType();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetId() {
        int id = 0;
        DepositType instance = new DepositType();
        instance.setId(id);
        int expected = 0;
        assertEquals(expected, instance.getId());
        
    }

    @Test
    public void testGetName() {
        DepositType instance = new DepositType();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetName() {
        String name = "";
        DepositType instance = new DepositType();
        instance.setName(name);
        
    }

    @Test
    public void testGetDescription() {
        DepositType instance = new DepositType();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetDescription() {
        String description = "";
        DepositType instance = new DepositType();
        instance.setDescription(description);
        String expected = "";
        assertEquals(expected, instance.getDescription());
        
    }

    @Test
    public void testGetRate() {
        DepositType instance = new DepositType();
        double expResult = 0.0;
        double result = instance.getRate();
        assertEquals(expResult, result, 0.0);
        
    }

    @Test
    public void testSetRate() {
        double rate = 0.0;
        DepositType instance = new DepositType();
        instance.setRate(rate);
        double expected = 0.0;
        assertEquals(expected, instance.getRate(),0.0);
        
    }
    @Test
    public void testSetRateIlegal() {
        double rate = -5;
        DepositType instance = new DepositType();
        Exception ex = Assertions.assertThrows(Exception.class,()->instance.setRate(rate));
        
    }

    @Test
    public void testGetDuration() {
        DepositType instance = new DepositType();
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetDuration() {
        int duration = 0;
        DepositType instance = new DepositType();
        instance.setDuration(duration);
        int expected = 0;
        assertEquals(expected, instance.getDuration());
        
    }
    @Test
    public void testSetDurationIlegal() {
        int duration = -5;
        DepositType instance = new DepositType();
        Exception ex = Assertions.assertThrows(Exception.class,()->instance.setDuration(duration));
        
    }

  

    
    
}
