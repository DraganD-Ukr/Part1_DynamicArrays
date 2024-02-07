package utils;

/**
 *
 * @author michelle
 */

/*
1. Your dynamic array list should include a constructor that lets the user specify the initial capacity of the internal array.
The constructor should take in one parameter, an int that specifies the initial size to which the internal array should be initialised.
The supplied size should be validated, and invalid values handled accordingly.



2. Your list should contain a method called add() that takes two parameters:

    - A String to be added (this may be null).
    - A position at which to insert the data.
The position should be validated and invalid positions handling accordingly.
If the position is valid, the data from that position should be added to the list using shift insertion.
If there is insufficient space in the list, the internal array should be grown
(using the arraycopy method from Java’s API OR your own growArray algorithm) and the String added then.

If supplied, null values should be added.



3. Your list should contain a method called removeAll() that takes one parameter:

    - The String to be removed (this should not be null).
All instances of this String should be removed from the list.
The method should return a boolean indicating if the String was removed (if at least one instance is removed, the method should return true, otherwise it should return false).



4. Your list should contain a method called lastIndexOf() that takes one parameter:

   - The String to be found in the list (This should not be null)
The method should return an int indicating the last position at which the String could be found.
If the String could not be found, an appropriate value should be returned to indicate this.
Comparisons should be done in a case-sensitive manner, and null should not be acceptable as a parameter for this method.

 */

//    TODO Extra Tasks

public class DynamicArrayList {
    private String[] list;
    private int numElements;
    private static int defaultInitialCapacity = 10;

    public DynamicArrayList() {
        list = new String[defaultInitialCapacity];
        numElements = 0;
    }


    public DynamicArrayList(int initialCapacity) throws IllegalArgumentException {
        if (initialCapacity > 0 && initialCapacity < Integer.MAX_VALUE) {
            list = new String[initialCapacity];
        } else {
            throw new IllegalArgumentException();
        }

        numElements = 0;
    }

    public int size() {
        return this.numElements;
    }

    public String get(int index) throws IndexOutOfBoundsException {
        if (index<0 || index>=numElements){
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public int indexOf(String target) {
        for (int i = 0; i < numElements; i++) {
            if (list[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

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

    public void add(String word, int pos) throws IndexOutOfBoundsException {

        if (pos < 0 || pos > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        String[] result = new String[list.length];
        int j = 0;

        for (int i = 0; i < this.size()+1; i++) {
            if (i != pos) {
                result[j] = list[i];
            } else {
                result[j] = word;
                result[j+1] = list[i];
                j++;
            }
            j++;
        }
        list[numElements] = word;
        numElements++;

        this.list = result;

    }

    public void add(String word) {

        while (numElements >= list.length) {
            this.grow();
        }

        list[numElements] = word;
        numElements++;
    }


    private void grow() {
        int numberToGrow = 5; //Instead of defining a number to grow array when it's full
        // we can provide a user an option to choose or alternatively, make this number dynamically change,
        // based on the size of data inside the array

        String[] grownList = new String[this.list.length + numberToGrow];
        System.arraycopy(this.list, 0, grownList, 0, this.list.length);
        this.list = grownList;
    }


    public boolean isEmpty() {
        return numElements == 0;
    }




    public boolean removeAll(String text) throws IllegalArgumentException {
        if (text == null){
            throw new IllegalArgumentException();
        }

        String[] result = new String[this.size()];
        int tracker = 0;
        int countOfDeletedNums = 0;

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