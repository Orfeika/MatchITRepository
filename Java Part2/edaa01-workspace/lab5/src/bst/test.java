package bst;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(10);
		bst.add(5);
		bst.add(8);
		bst.add(3);
		bst.add(1);
		bst.add(4);
		bst.add(12);
		bst.add(11);
		bst.add(14);
		bst.add(14);

		
		bst.printTree();
		

	}

}
