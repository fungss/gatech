import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // 1. check IllegalArgumentException
        if (data == null) {
            throw new IllegalArgumentException();
        } else {
            // 2. resize backingArray if it is full
            if (size == backingArray.length-1){
                // System.out.printf("---- new array of length %d is created.", backingArray.length*2);
                // System.out.println();
                T[] newBackingArray = (T[]) new Comparable[backingArray.length*2];
                for (int i=1; i < backingArray.length; i++){
                    newBackingArray[i] = backingArray[i];
                }
                backingArray = newBackingArray;
            }
            // 3. add data to backingArray
            backingArray[size+1] = data;
            size++;
            // System.out.printf("data added at position %d", size);
            // System.out.println();
            // System.out.printf("size after data added: %d", size);
            // System.out.println();
            // 4. begin point reinforcement
            int curr = size;
            boolean swapSwitch;
            swapSwitch = true;
            while (swapSwitch) {
                // edge case: reached root
                if (curr/2 == 0) {
                    swapSwitch = false;
                // edge case: parent is smaller than child
                } else if (backingArray[curr/2].compareTo(backingArray[curr]) < 0){
                    swapSwitch = false;
                // swap if parent bigger than child
                } else {
                    if (backingArray[curr/2].compareTo(backingArray[curr]) > 0){
                        T tmp =  backingArray[curr/2];
                        backingArray[curr/2] = backingArray[curr];
                        backingArray[curr] = tmp;
                    }
                }
                // move pointer from child to parent
                curr = curr/2;
            }

        }
    }

    // helper method
    private void downHeap(int n){
        // begin downHeap comparison only if child exists
        if (n <= size/2){
            int parent = n;
            int child = 0;
            // check number of children
            // 1 child case
            if (backingArray[n*2] != null && backingArray[n*2+1] == null){
                child = n*2;
            // 2 children case
            } else if (backingArray[n*2] != null && backingArray[n*2+1] != null){
                // compare the children, find the smaller child
                if (backingArray[n*2].compareTo(backingArray[n*2+1]) < 0){
                    child = n*2;
                } else {
                    child = n*2+1;
                }
            }
            if (child != 0){
                // swap if parent is bigger than the smaller child
                if (backingArray[parent].compareTo(backingArray[child]) > 0) {
                    // System.out.printf("swap parent %d with smaller child %d", backingArray[parent],backingArray[child]);
                    // System.out.println();
                    T tmp = backingArray[parent];
                    backingArray[parent] = backingArray[child];
                    backingArray[child] = tmp;
                } 
            }
            downHeap(child);
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // check NoSuchElementException 
        if (backingArray[1]==null){
            throw new NoSuchElementException();
        } else {
            // remove root element
            T removed = backingArray[1];
            backingArray[1] = backingArray[size];
            backingArray[size] = null;
            size--;
            // begin downheap
            downHeap(1);
            return removed;
        }
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String args[]){
        System.out.println("-------------testing begin-------------");
        MinHeap<Integer> testMinHeap = new MinHeap<>();
        // ------------------------------------------
        // test add null

        // testMinHeap.add(null);
        // ------------------------------------------
        // test add method
        System.out.println("-------------test add method-------------");
        //
        // add 13 elements to testMinHeap
        // for (int i = 0; i < 14; i++){
        //     testMinHeap.add(i);
        // }
        // unsorted 13 elements
        testMinHeap.add(1);
        testMinHeap.add(3);
        testMinHeap.add(5);
        testMinHeap.add(13);
        testMinHeap.add(8);
        testMinHeap.add(2);
        testMinHeap.add(4);
        testMinHeap.add(9);
        testMinHeap.add(10);
        testMinHeap.add(12);
        testMinHeap.add(11);
        testMinHeap.add(7);
        testMinHeap.add(6);

        // ------------------------------------------
        // print backingArray
        System.out.printf("Current array size is: %d", testMinHeap.size());
        System.out.println();
        Object[] addRes = testMinHeap.getBackingArray();
        System.out.printf("The length of the res array is %d", addRes.length);
        System.out.println();
        for (int i=1; i<=testMinHeap.size(); i++) {
            System.out.printf("Postition %d: ", i);
            System.out.printf("%d", (int) addRes[i]);
            System.out.println();
        }
        // ------------------------------------------
        // test remove method
        System.out.println("-------------test remove method-------------");
        System.out.printf("Removed root: %d", testMinHeap.remove());
        System.out.println();
        Object[] reMoveRes = testMinHeap.getBackingArray();
        for (int i=1; i<=testMinHeap.size(); i++) {
            System.out.printf("Postition %d: ", i);
            System.out.printf("%d", (int) reMoveRes[i]);
            System.out.println();
        }
    }
}