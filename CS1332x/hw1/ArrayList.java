import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        } else {
        	if  (size == 0) {
        		backingArray[size] = data;
        		size++;
        	} else {
	        		if ((size % INITIAL_CAPACITY == 0)){
	        			T[] newArray = (T[]) new Object[2*size];
	        			int newSize = 0;
	                    newArray[0] = data;
	                    newSize++;
	                    for (int i = 0; i < backingArray.length; i ++) {
	                        newArray[i+1] = backingArray[i];
	                        newSize++;
	                    }
	                    backingArray = (T[]) newArray;
	                    size = (int) newSize;       
		        	} else if (size < INITIAL_CAPACITY) {
		        		T[] newArray = (T[]) new Object[INITIAL_CAPACITY];
		        		int newSize = 0;
		        		newArray[0] = data;
		        		newSize++;
                        for (int i = 0; i < size; i ++) {
                            newArray[i+1] = backingArray[i];
                            newSize++;
                        }
                        backingArray = (T[]) newArray;
                        size = (int) newSize;
		        	} else {
		        		int sizepara = size/INITIAL_CAPACITY + 1;
	                       T[] newArray = (T[]) new Object[sizepara*INITIAL_CAPACITY];
	                       int newSize = 0;
	                       newArray[0] = data;
	                       newSize++;
	                       for (int i = 0; i < size; i ++) {
	                           newArray[i+1] = backingArray[i];
	                           newSize++;
	                       }
                           backingArray = (T[]) newArray;
                           size = (int) newSize;
	                       }
		        	}
	                
        	}
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        } else {
            if  ((size % INITIAL_CAPACITY == 0) && (size != 0)) {
                T[] newArray = (T[]) new Object[2*size];
                int newSize = 0;
                for (int i = 0; i < size; i ++) {
                    newArray[i] = backingArray[i];
                    newSize++;
                }
                newArray[size] = data;
                newSize++;
                backingArray = (T[]) newArray;
                size = (int) newSize;
            } else {
                backingArray[size] = data;
                size++;
            }
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("The list is empty."); 
        } else {
            if (size > INITIAL_CAPACITY){
               int sizepara = size/INITIAL_CAPACITY + 1;
               T[] newArray = (T[]) new Object[sizepara*INITIAL_CAPACITY];
               int newSize = 0;
               for (int i = 1; i < size; i ++) {
                   newArray[i-1] = backingArray[i];
                   newSize++;
               }
               T removed = backingArray[0];
               backingArray = (T[]) newArray;
               size = (int) newSize;
               return removed; 
            } else {
               T[] newArray = (T[]) new Object[INITIAL_CAPACITY];
               int newSize = 0;
               for (int i = 1; i < size; i ++) {
                   newArray[i-1] = backingArray[i];
                   newSize++;
               }
               T removed = backingArray[0];
               backingArray = (T[]) newArray;
               size = (int) newSize;
               return removed; 
            }

        }
    }


    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0){
            throw new NoSuchElementException("The list is empty."); 
        } else{
            T removed = backingArray[size-1];
            backingArray[size-1] = null;
            size--;
            return removed;
        }
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    
	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			x.addToBack(i);
		}
		x.removeFromFront();
		x.removeFromBack();
		Object[] y = x.getBackingArray();
		for (int i = 0; i < y.length; i++) {
			System.out.println(y[i]);
		}
		System.out.println(x.size());
		System.out.println(y.length);
		
	}

}