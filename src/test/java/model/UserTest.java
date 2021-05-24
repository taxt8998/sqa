/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author ASUS
 */
public class UserTest {
    
    public UserTest() {
    }

    @Test
    public void testGetId() {
        User u = new User();
        int expected = 0;
        int res = u.getId();
        assertEquals(expected, res);
    }

    @Test
    public void testSetId() {
        int i = 1;
        User u = new User();
        u.setId(i);
        int expected = 1;
        assertEquals(expected, u.getId());
    }
    @Test
    public void testSetIdIllegal() {
        int i = -1;
        User u = new User();
        Exception ex = Assertions.assertThrows(Exception.class,()->u.setId(i));
    }

    @Test
    public void testGetName() {
        User u = new User();
        String expected = null;
        String result = u.getName();
        assertEquals(expected, result);
        
    }

    @Test
    public void testSetName() {
        String name = "abc";
        User u = new User();
        u.setName(name);
        String expected = "abc";
        assertEquals(expected, u.getName());
    }


    @Test
    public void testGetRole() {
        User u = new User();
        String expected = null;
        String result = u.getRole();
        assertEquals(expected, result);
    }

    @Test
    public void testSetRole() {
        String role = "abc";
        User u = new User();
        u.setRole(role);
        String expected = "abc";
        assertEquals(expected, u.getRole());
    }

    @Test
    public void testGetAddress() {
        User u = new User();
        String expected = null;
        String result = u.getRole();
        assertEquals(expected, result);
    }

    @Test
    public void testSetAddress() {
        String add = "abc";
        User u = new User();
        u.setAddress(add);
        String expected = "abc";
        assertEquals(expected, u.getAddress());
    }

    @Test
    public void testGetUsername() {
        User u = new User();
        String expected = null;
        String result = u.getUsername();
        assertEquals(expected, result);
    }

    @Test
    public void testSetUsername() {
        String add = "tt2";
        User u = new User();
        u.setUsername(add);
        String expected = "tt2";
        assertEquals(expected, u.getUsername());
    }

    @Test
    public void testGetPassword() {
        User u = new User();
        String expected = null;
        String result = u.getPassword();
        assertEquals(expected, result);
    }

    @Test
    public void testSetPassword() {
        String pwd = "123456";
        User u = new User();
        u.setPassword(pwd);
        String expected = "123456";
        assertEquals(expected, u.getPassword());
    }
    @Test
    public void testSetPasswordIllegal() {
        String pwd = "@123456";
        User u = new User();
        Exception ex = Assertions.assertThrows(Exception.class,()->u.setPassword(pwd));
    }
    
}
