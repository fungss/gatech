import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (data == null) {
            throw new IllegalArgumentException("Input is null.");
        } else {
        	if (size==0) {
        		head = new SinglyLinkedListNode<T>(data);
        		tail = head;
        		size++;
        	} else {
        		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data, head);
        		head = newNode;
        		size++;
        	}
        }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (data == null) {
            throw new IllegalArgumentException("Input is null.");
        } else {
        	if (size==0) {
        		tail = new SinglyLinkedListNode<T>(data);
        		head = tail;
        		size++;
        	} else {
        		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data);
        		tail.setNext(newNode);
        		tail = newNode;
        		size++;
        	}       
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (size==0) {
    		throw new NoSuchElementException("The list is empty.");
    	} else if (size==1) {
    		T removed = head.getData();
    		head = null;
    		tail = null;
    		size--;
    		return removed;
    	} else {
    		T removed = head.getData();
    		head = head.getNext();
    		size--;
    		return removed;
    	}
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (size==0) {
    		throw new NoSuchElementException("The list is empty.");
    	} else if (size==1) {
    		T removed = tail.getData();
    		head = null;
    		tail = null;
    		size--;
    		return removed;
    	} else if (size==2) {
    		T removed = tail.getData();
    		tail = head;
    		size--;
    		return removed;
    	} else {
    		T removed = tail.getData();
    		tail = null;
    		size--;
    		SinglyLinkedListNode<T> current = head;
    		while (current.getNext().getNext() != null) {
    			current = current.getNext();
    		}
    		tail = current;
    		tail.setNext(null);
    		return removed;
    	}
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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
    
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SinglyLinkedList<Integer> x = new SinglyLinkedList<>();
//		x.addToFront(2);
//		x.addToFront(1);
//		x.addToBack(3);
//		x.addToBack(4);
//		x.removeFromFront();
//		x.removeFromBack();
//		System.out.println(x.size()); // 2
//		System.out.println(x.getHead().getData()); // 2
//		System.out.println(x.getTail().getData()); // 3
//	}
}