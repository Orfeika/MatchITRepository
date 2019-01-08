package bst;

import java.util.Comparator;

import bst.BinarySearchTree.BinaryNode;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;
	private Comparator<E> comp;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree(Comparator<E> comp) {
		root = null;
		comp = this.comp;
		size = 0;

	}

	public BinarySearchTree() {
		root = null;
		size = 0;

	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}

		return addNode(root, x);

	}

	private boolean addNode(BinaryNode<E> node, E x) {
		if (node.element.compareTo(x) > 0) {
			if (node.left == null) {
				node.left = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return addNode(node.left, x);
		} else if (node.element.compareTo(x) < 0) {
			if (node.right == null) {
				node.right = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return addNode(node.right, x);
		}
		return false;
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return (root != null) ? getHeight(root) : 0;

	}

	private int getHeight(BinaryNode<E> node) {
		int rHeight = (node.right != null) ? getHeight(node.right) : 0;
		int lHeight = (node.left != null) ? getHeight(node.left) : 0;
		return 1 + Math.max(rHeight, lHeight);
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		if (root == null) {
			return;
		} else {

			printNodeInorder(root);
			// printNodePreorder(root);
			// printNodePostOrder(root);
		}

	}

	private void printNodeInorder(BinaryNode<E> node) {
		if (node.left != null) {
			printNodeInorder(node.left);
		}
		System.out.println(node.element.toString());
		if (node.right != null) {
			printNodeInorder(node.right);
		}
	}

	private void printNodePreorder(BinaryNode<E> node) {
		System.out.println(node.element);
		if (node.left != null) {
			printNodePreorder(node.left);
		}
		if (node.right != null) {
			printNodePreorder(node.right);
		}

	}

	private void printNodePostOrder(BinaryNode<E> node) {
		if (node.left != null) {
			printNodePostOrder(node.left);
		}
		if (node.right != null) {
			printNodePostOrder(node.right);
		}

		System.out.println(node.element);
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
			/// How to create an array of generics?
		
		
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1 (the
	 * first empty position in a).
	 */
	private int toArray(BinaryNode<E> node, E[] a, int index) {
		if (node.left != null) {
			toArray(node.left, a, index++);
		}
		a[index] = node.element;
		System.out.println("Index " + index + "value" + a[index]);
		if (node.right != null) {
			toArray(node.right, a, index++);
		}

		return index + 1;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in the
	 * array a are assumed to be in ascending order. Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		int middle = (first + last) / 2;
		
		if (middle>=first) {
			BinaryNode<E> root = new BinaryNode<E>(a[middle]);
			root.left = buildTree(a,middle-1, first);

		}

		BinaryNode<E> root = new BinaryNode<E>(a[middle + 1]);
		return root.right = buildTree(a, middle + 1, last);

	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}

//	public static void main(String [] args) {
//		BSTVisualizer bstv = new BSTVisualizer(" ", 700, 700);
//		///How we can sort tree? pg31  https://fileadmin.cs.lth.se/cs/Education/MatchIT/Prog_ADV/AP_Lecture10.pdf 
//		
//		BinarySearchTree<Student> bst = new BinarySearchTree<Student>((st1,st2) -> st1.getName().compareTo(st2.getName()));
//		bst.add(new Student("Mark",10,"Math"));
//		bst.add(new Student("Peter", 5, "Literature"));
//		bst.add(new Student("Johan", 8, "Chemistry"));
//		bst.add(new Student("Marry", 3, "Literature"));
//		bst.add(new Student("Tom",1,"Architecture"));
//		bst.add(new Student("Sandy",4, "Art"));
//		bst.add(new Student("Ann",12,"Architecture"));
//		bst.add(new Student("Zed",11, "Art"));
//		bst.add(new Student("Rick",14, "Chemistry"));
//		bst.add(new Student("Yuki",14, "Art"));
//		bst.printTree();
//		bstv.drawTree(bst);
//		
//		
//	}

}
