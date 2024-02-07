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
public class DynamicArrayListRandomTests {

    public DynamicArrayListRandomTests() {
    }


    /**
     * Test of lastIndexOf method with information in the list.
     */
    @Test
    public void testLastIndexOf_TextInListOnce() {
        System.out.println("Testing the lastIndexOf method with information in the list once.");
        String text = "Entry Two";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        int expResult = 2;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with multiple instances of the information in the list.
     */
    @Test
    public void testLastIndexOf_TextInList_MultipleInstances() {
        System.out.println("Testing the lastIndexOf method with information in the list multiple times.");
        String text = "Alpha";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Alpha");
        instance.add("Entry Zero");
        instance.add("Alpha");
        instance.add("Entry One");
        instance.add("Alpha");
        instance.add("Beta");

        int expResult = 4;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with multiple instances of the information in the list,
     * where the case is not the same as the requested case in some of the matches.
     */
    @Test
    public void testLastIndexOf_TextInList_MultipleInstances_ConfirmingCaseSensitivity() {
        System.out.println("Testing the lastIndexOf method with information in the list multiple times, where the " +
                "case is different" +
                ".");
        String text = "Alpha";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Alpha");
        instance.add("Entry Zero");
        instance.add("Alpha");
        instance.add("Entry One");
        instance.add("alpha");
        instance.add("Beta");

        int expResult = 2;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with information not in the list.
     */
    @Test
    public void testLastIndexOf_TextNotInList(){
        System.out.println("Testing the lastIndexOf method with information not in the list.");
        String text = "Entry five";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        int expResult = -1;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of lastIndexOf method with information not in the list, where null is parameter.
     */
    @Test
    public void testLastIndexOf_NullParameter(){
        System.out.println("Testing the lastIndexOf method with null supplied as parameter.");

        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        assertThrows(IllegalArgumentException.class, () -> {
            int result = instance.lastIndexOf(null);
        });
    }

    /**
     * Test of lastIndexOf method with multiple instances of the information in the list and the list contains nulls.
     */
    @Test
    public void testLastIndexOf_TextInList_ListContainsNulls() {
        System.out.println("Testing the lastIndexOf method with information in the list multiple times, where the " +
                "list also contains nulls" +
                ".");
        String text = "Alpha";
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Alpha");
        instance.add(null);
        instance.add("Alpha");
        instance.add("Entry One");
        instance.add(null);

        int expResult = 2;
        int result = instance.lastIndexOf(text);
        assertEquals(expResult, result);
    }
}