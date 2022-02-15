public class TestAVL {

	/* function to print level order traversal of tree*/
    public static void printLevelOrder(AVLNode<Integer> root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printCurrentLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    public static int height(AVLNode<Integer> root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = height(root.getLeft());
            int rheight = height(root.getRight());
 
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    /* Print nodes at the current level */
    public static void printCurrentLevel(AVLNode<Integer> node, int level) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.getData() + " ");
        else if (level > 1) {
            printCurrentLevel(node.getLeft(), level - 1);
            printCurrentLevel(node.getRight(), level - 1);
        }
    }


    public static void main(String args[]){
        AVL<Integer> tree1 = new AVL<>();
		
		// test remove
		int[] ar = {21, 13, 32, 1, 19, 29, 9, 16, 20};
		// int[] ar = {14, 5, 17, 4, 10, 24, 7, 12};
		for (int i: ar) {
			tree1.add(i);
		}
		System.out.println(tree1.size());
		printLevelOrder(tree1.getRoot());
		System.out.println();
        System.out.println(tree1.remove(18));
		printLevelOrder(tree1.getRoot());
		System.out.println();
		// System.out.println(tree1.getRoot().getLeft().getData());
		// System.out.println(tree1.getRoot().getLeft().getRight().getData());
		// System.out.println(tree1.getRoot().getLeft().getRight().getLeft());
		// System.out.println(tree1.size());
    }
}
