import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (data==null) {
    		throw new IllegalArgumentException();
    	} else {
    		root = rAdd(root, data);
    	}
    }
    
    private BSTNode<T> rAdd(BSTNode<T> curr, T data) {
    	if (curr==null) {
    		size++;
    		BSTNode<T> newNode = new BSTNode<T>(data);
    		return newNode;
    	} else if (curr.getData().compareTo(data)<0) {
    		curr.setRight(rAdd(curr.getRight(), data));
    	} else if (curr.getData().compareTo(data)>0) {
    		curr.setLeft(rAdd(curr.getLeft(), data));
    	}
		return curr;
    }
    
    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	if (data == null) {
    		throw new IllegalArgumentException();
    	} else {
    		BSTNode<T> dummy = new BSTNode<T>(null);
    		root = rRemove(root, data, dummy);
    		if (dummy.getData()==null) {
    			throw new NoSuchElementException();
    		} else {
    			size--;
    		}
    		return dummy.getData();
    	}
    }

    private BSTNode<T> rRemove(BSTNode<T> curr, T data, BSTNode<T> dummy) {
    	if (curr==null) {
    		return curr;
    	} else if (curr.getData().compareTo(data)<0) {
    		curr.setRight(rRemove(curr.getRight(), data, dummy));
    	} else if (curr.getData().compareTo(data)>0) {
    		curr.setLeft(rRemove(curr.getLeft(), data, dummy));
    	} else {
    		dummy.setData(curr.getData());
    		// begin to remove node
    		if (curr.getLeft() == null && curr.getRight() == null) {
    			return null;
    		} else if (curr.getLeft() != null && curr.getRight() == null) {
    			return curr.getLeft();
    		} else if (curr.getLeft() == null && curr.getRight() != null) {
    			return curr.getRight();
    		} else {
    			// replace curr.value with successor.value, which is the smallest of the larger(s)
    			BSTNode<T> successor = getNodeSuccessor(curr);
    			BSTNode<T> dummyS = new BSTNode<T>(null);
    			curr.setData(successor.getData());
    			curr.setRight(rRemove(curr.getRight(), successor.getData(), dummyS));
    			return curr;
    		}
    	}
    	return curr;
    }
    
    private BSTNode<T> getNodeSuccessor(BSTNode<T> curr) {
    	curr = curr.getRight();
    	while (curr.getLeft() != null) {
    		curr = curr.getLeft();
    	}
    	return curr;
    }
    
    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
    
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		BST<Integer> tree1 = new BST<>();
//		
//		// test remove
//		int[] ar = {50, 15, 5, 25, 20, 75, 100};
//		for (int i: ar) {
//			tree1.add(i);
//		}
//		System.out.println(tree1.size());
////		System.out.println(tree1.getRoot().getData());
////		System.out.println(tree1.getRoot().getRight().getData());
////		System.out.println(tree1.getRoot().getRight().getRight().getData());
////		System.out.println(tree1.getRoot().getLeft().getData());
////		System.out.println(tree1.getRoot().getLeft().getLeft().getData());
////		System.out.println(tree1.getRoot().getLeft().getRight().getData());
////		System.out.println(tree1.getRoot().getLeft().getRight().getLeft().getData());
//		
//		
//		System.out.println(tree1.remove(15));
//		System.out.println(tree1.getRoot().getLeft().getData());
//		System.out.println(tree1.getRoot().getLeft().getRight().getData());
//		System.out.println(tree1.getRoot().getLeft().getRight().getLeft());
//		System.out.println(tree1.size());
//		
////		// test add
////		tree1.add(10);
////		System.out.println(tree1.size());
////		System.out.println(tree1.getRoot().getData());
////		tree1.add(5);
////		System.out.println(tree1.size());
////		System.out.println(tree1.getRoot().getLeft().getData());
////		tree1.add(20);
////		System.out.println(tree1.size());
////		System.out.println(tree1.getRoot().getRight().getData());
////		tree1.add(1);
////		System.out.println(tree1.size());
////		System.out.println(tree1.getRoot().getLeft().getLeft().getData());
//	}

}