public class TestBST {
    public static void main(String[] args) {
		BST<Integer> tree1 = new BST<>();
		
		// test remove
		int[] ar = {50, 15, 5, 25, 20, 75, 100};
		for (int i: ar) {
			tree1.add(i);
		}
		System.out.println(tree1.size());
//		System.out.println(tree1.getRoot().getData());
//		System.out.println(tree1.getRoot().getRight().getData());
//		System.out.println(tree1.getRoot().getRight().getRight().getData());
//		System.out.println(tree1.getRoot().getLeft().getData());
//		System.out.println(tree1.getRoot().getLeft().getLeft().getData());
//		System.out.println(tree1.getRoot().getLeft().getRight().getData());
//		System.out.println(tree1.getRoot().getLeft().getRight().getLeft().getData());
		
		
		System.out.println(tree1.remove(1));
		System.out.println(tree1.getRoot().getLeft().getData());
		System.out.println(tree1.getRoot().getLeft().getRight().getData());
		System.out.println(tree1.getRoot().getLeft().getRight().getLeft());
		System.out.println(tree1.size());
		
//		// test add
//		tree1.add(10);
//		System.out.println(tree1.size());
//		System.out.println(tree1.getRoot().getData());
//		tree1.add(5);
//		System.out.println(tree1.size());
//		System.out.println(tree1.getRoot().getLeft().getData());
//		tree1.add(20);
//		System.out.println(tree1.size());
//		System.out.println(tree1.getRoot().getRight().getData());
//		tree1.add(1);
//		System.out.println(tree1.size());
//		System.out.println(tree1.getRoot().getLeft().getLeft().getData());
	}
}

