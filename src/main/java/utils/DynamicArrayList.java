package utils;

import java.util.Arrays;

/**
 *
 * @author michelle
 *
 */



public class DynamicArrayList {
    /**
     * List to hold String Objects.
     */
    private String[] list;
    /**
     * Numbers of elements in the ArrayList.
     */
    private int numElements;
    /**
     * Default number of initial capacity when creating an ArrayList using default constructor.
     */
    private static int defaultInitialCapacity = 10;


    /**
     * Default Constructor
     */
    public DynamicArrayList() {
        list = new String[defaultInitialCapacity];
        numElements = 0;
    }

    /**
     * Constructor with specifying initial capacity of ArrayList.
     *
     * @param initialCapacity new initial capacity
     * @throws IllegalArgumentException
     */
    public DynamicArrayList(int initialCapacity) throws IllegalArgumentException {
        if (initialCapacity > 0 && initialCapacity < Integer.MAX_VALUE) {
            list = new String[initialCapacity];
        } else {
            throw new IllegalArgumentException();
        }

        numElements = 0;
    }

    /**
     * Gets a number of elements stored in ArrayList.
     * @return number of elements stored
     */
    public int size() {
        return this.numElements;
    }

    /**
     * Gets a String at specified index in ArrayList.
     *
     * @param index position of String to return
     * @return String
     * @throws IndexOutOfBoundsException
     */
    public String get(int index) throws IndexOutOfBoundsException {
        if (index<0 || index>=numElements){
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    /**
     * Gets a first index of specified String in ArrayList.
     *
     * @param target specified String to search in ArrayList
     * @return -1 if there is no such specified String, otherwise the index of first match
     */
    public int indexOf(String target) {
        for (int i = 0; i < numElements; i++) {
            if (list[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets a last index of specified String in ArrayList.
     *
     * @param target specified String to search in ArrayList
     * @return -1 if there is no such specified String, otherwise the index of last match
     * @throws IllegalArgumentException
     */
    public int lastIndexOf(String target) throws IllegalArgumentException {
        if (target==null){
            throw new IllegalArgumentException();
        }
        for (int i = numElements-1; i >= 0; i--) {
            if (list[i]!=null && list[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds a String at specified index with shifting other elements to right.
     *
     * @param word a String to be added
     * @param pos an index to be added at
     * @throws IndexOutOfBoundsException
     */
    public void add(String word, int pos) throws IndexOutOfBoundsException {
        // Check if the position is valid
        if (pos < 0 || pos > numElements) {
            throw new IndexOutOfBoundsException("Invalid index: " + pos);
        }

        //Grow array if needed
        if (numElements == list.length){
            this.grow();
        }

        String[] result = new String[list.length];

        // Copy elements before the specified position
        System.arraycopy(list, 0, result, 0, pos);

        // Insert the new word at the specified position
        result[pos] = word;

        // Copy elements after the specified position
        System.arraycopy(list, pos, result, pos + 1, numElements - pos);

        // Update the list with the new elements
        list = result;

        numElements++;
    }




    /**
     * Adds a specified String to the end of ArrayList.
     *
     * @param word a String to be added
     */
    public void add(String word) {
        //Grow array if needed
        if (numElements == list.length){
            this.grow();
        }



        list[numElements] = word;
        numElements++;
    }


    /**
     * Helper method to grow array(creating new array with bigger size and copying elements over to new resized array).
     */
    private void grow() {
        int numberToGrow = 5; //Instead of defining a number to grow array when it's full
        // we can provide a user an option to choose or alternatively, make this number dynamically change,
        // based on the size of data inside the array

        String[] grownList = new String[this.list.length + numberToGrow];
        System.arraycopy(this.list, 0, grownList, 0, this.list.length);
        this.list = grownList;
    }

    /**
     * Removes all matches of a specified String in ArrayList. Shifts elements to the left after removing.
     *
     * @param text a String(s) to be removed from ArrayList
     * @return true if at least one element was removed, false otherwise
     * @throws IllegalArgumentException
     */
    public boolean removeAll(String text) throws IllegalArgumentException {
        if (text == null){
            throw new IllegalArgumentException();
        }

        String[] result = new String[this.size()];
        int tracker = 0;
        int countOfDeletedNums = 0;

        //Simply copying over elements if they don't equal to specified word and counting number of removals.
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(text)){
                countOfDeletedNums++;

            } else {
                result[tracker] = this.get(i);
                tracker++;
            }
        }

        this.numElements -= countOfDeletedNums;
        if (countOfDeletedNums>0){
            this.list = result;
        }
        return countOfDeletedNums>0;
    }
}