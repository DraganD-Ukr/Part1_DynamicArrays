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
public class DynamicArrayListAddTests {

    public DynamicArrayListAddTests() {
    }

    /**
     * Test of add method at valid position.
     */
    @Test
    public void testAddAtPos_ValidPosition() {
        System.out.println("Testing adding a String to a valid position within a list.");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        String newValue = "Blue";
        int pos = 4;
        instance.add(newValue, pos);
        String [] expListContents = {"Yellow", "Leather", "Yellow", "Leather", "Blue", "Red", "Balloon"};
        for(int i = pos; i < instance.size(); i++){
            String expResult = expListContents[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of add method at valid position.
     */
    @Test
    public void testAddAtPos_ValidPosition_SizeOfList() {
        System.out.println("Testing adding a String to a valid position within a list (The slot after the end of the " +
                "list)" +
                ".");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        String newValue = "Blue";
        int pos = 6;
        instance.add(newValue, pos);
        String [] expListContents = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon", "Blue"};
        for(int i = pos; i < instance.size(); i++){
            String expResult = expListContents[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of add method at valid position (where list is empty).
     */
    @Test
    public void testAddAtPos_ValidPosition_SizeOfList_EmptyList() {
        System.out.println("Testing adding a String to a valid position within a list (where the list is empty)" +
                ".");
        String [] data = {};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        String newValue = "Blue";
        int pos = 0;
        instance.add(newValue, pos);
        String [] expListContents = {"Blue"};
        for(int i = pos; i < instance.size(); i++){
            String expResult = expListContents[i];
            String result = instance.get(i);
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of add method at invalid position (negative number).
     */
    @Test
    public void testAddAtPos_InvalidPosition_Negative() {
        System.out.println("Testing adding a String to an invalid position within a list (negative number).");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.add("Blue", -1);
        });
    }
    /**
     * Test of add method at invalid position (longer than length of list).
     */
    @Test
    public void testAddAtPos_InvalidPosition_TooBig() {
        System.out.println("Testing adding a String to an invalid position within a list (number is greater than the " +
                "length of the list)" +
                ".");
        String [] data = {"Yellow", "Leather", "Yellow", "Leather", "Red", "Balloon"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String text : data){
            instance.add(text);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.add("Blue", 7);
        });
    }

}