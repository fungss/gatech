import java.util.List;

//import sun.jvm.hotspot.opto.Node_List;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
	private void preLoopHelper(TreeNode<T> node, List<T> list) {
		if (node == null) {
			return;
		} else {
			list.add(node.getData());
			preLoopHelper(node.getLeft(), list);
			preLoopHelper(node.getRight(), list);
		}
	}
	
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	List<T> ls = new ArrayList<>();
    	if (root != null) {
    		preLoopHelper(root, ls);
    		return ls;
    	} else {
    		return ls;
    	}
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    
    private void inLoopHelper(TreeNode<T> node, List<T> list) {
		if (node == null) {
			return;
		} else {
			inLoopHelper(node.getLeft(), list);
			list.add(node.getData());
			inLoopHelper(node.getRight(), list);
		}
	}
    
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	List<T> ls = new ArrayList<>();
    	if (root != null) {
    		inLoopHelper(root, ls);
    		return ls;
    	} else {
    		return ls;
    	}
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    
    private void postLoopHelper(TreeNode<T> node, List<T> list) {
		if (node == null) {
			return;
		} else {
			postLoopHelper(node.getLeft(), list);
			postLoopHelper(node.getRight(), list);
			list.add(node.getData());
		}
	}
    
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    	List<T> ls = new ArrayList<>();
    	if (root != null) {
    		postLoopHelper(root, ls);
    		return ls;
    	} else {
    		return ls;
    	}
    }
}