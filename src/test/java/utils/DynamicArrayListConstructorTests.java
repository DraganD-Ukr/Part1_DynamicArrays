/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author michelle
 */
public class DynamicArrayListConstructorTests {

    public DynamicArrayListConstructorTests() {
    }

    /**
     * Testing the one int parameter constructor, with an invalid list size/growth factor (less
     * than 0).
     */
    @Test
    public void testIntConstructor_InvalidValue_LessThanZero(){
        System.out.println("testing parameterised constructor with an invalid value (less than 0).");
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicArrayList newList = new DynamicArrayList(-1);
        });
    }
    
    /**
     * Testing the one int parameter constructor, with a valid list size/growth factor.
     */
    @Test
    public void testIntConstructor_ValidValue(){
        System.out.println("testing parameterised constructor with a valid capacity value.");
        DynamicArrayList newList = new DynamicArrayList(5);
        int expResult = 0;
        int result = newList.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing the one int parameter constructor, with an invalid list size/growth factor
     * (equal to 0).
     */
    @Test
    public void testIntConstructor_InvalidValue_EqualToZero(){
        System.out.println("testing parameterised constructor with an invalid value (equal to 0).");
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicArrayList newList = new DynamicArrayList(0);
        });
    }
}