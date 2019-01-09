package test;
import bst.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBinaryTreeSearch {
	BinarySearchTree<Student> bst;

	@BeforeEach
	void setUp() throws Exception {
		bst = new BinarySearchTree<Student>();
	}

	@AfterEach
	void tearDown() throws Exception {
		bst = null;
	}

	@Test
	void testEmpyTreeSize() {
		assertEquals(0, bst.size());
	}
	
	@Test
	void testEmpyTreeHeight() {
		assertEquals(0, bst.height());

	}
	
	
	@Test
	void testNonEmpyTreeSize() {
		bst.add(new Student("Mark",10,"Math"));
		bst.add(new Student("Peter", 5, "Literature"));
		bst.add(new Student("Johan", 8, "Chemistry"));
		assertEquals(3, bst.size());
	}
	
	@Test
	void testNonEmpyTreeHeight() {
		bst.add(new Student("Mark",10,"Math"));
		bst.add(new Student("Peter", 5, "Literature"));
		bst.add(new Student("Johan", 11, "Chemistry"));
		assertEquals(2, bst.height());

	}
	
	@Test
	void testAddDuplicate() {
		bst.add(new Student("Mark",10,"Math"));
		bst.add(new Student("Peter", 5, "Literature"));
		assertFalse(bst.add(new Student("Peter", 5, "Literature")));

	}
	

}
