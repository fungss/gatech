import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (data == null) {
    		throw new IllegalArgumentException("Data is null.");
    	} else {
    		if (size == 0) {
    			backingArray[front] = data;
    			size++;
    		} else {
    			if (size == backingArray.length) {
    				T[] newBackingArray = (T[]) new Object[backingArray.length*2];
    				for (int i=0; i < size; i++) {
    					newBackingArray[i] = backingArray[(front+i)%backingArray.length];
    				}
    				front = 0;
    				backingArray = newBackingArray;
        			backingArray[(front+size)%backingArray.length] = data;
        			size++;
    			} else {
        			backingArray[(front+size)%backingArray.length] = data;
        			size++;
    			}

    		}
    	}
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (size == 0) {
    		throw new NoSuchElementException("Queue is empty");
    	} else if (size == 1) {
    		T removed = backingArray[front];
    		backingArray[front] = null;
    		front = (front + 1)%backingArray.length;
    		size--;
    		return removed;
    	} else {
    		T removed = backingArray[front];
    		backingArray[front] = null;
    		front = (front + 1)%backingArray.length;
    		size--;
    		return removed;
    	}
    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	ArrayQueue<Integer> x = new ArrayQueue<>();
    	for (int i = 1; i < 12; i++) {
    		x.enqueue(i);
    	}
    	x.dequeue();
    	x.dequeue();
    	x.dequeue();
    	Object[] y = x.getBackingArray();
    	for (Object element : y) {
    		System.out.println(element);
    	}
    	
    	System.out.println(x.size);
    }
}