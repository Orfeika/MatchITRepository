package testqueue;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {
	FifoQueue<Integer> myFirstIntQueue;
	FifoQueue<Integer> mySecondIntQueue;

	@Before
	public void setUp() throws Exception {
		myFirstIntQueue = new FifoQueue<Integer>();
		mySecondIntQueue = new FifoQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		myFirstIntQueue = null;
		mySecondIntQueue = null;
	}

	@Test
	public void testTwoEmptyQueue() {
		myFirstIntQueue.append(mySecondIntQueue);
		assertTrue(myFirstIntQueue.isEmpty());
	}

	@Test
	public void testConcatEmptyQueueAndNonEmpty() {
		mySecondIntQueue.offer(1);
		mySecondIntQueue.offer(2);
		mySecondIntQueue.offer(3);
		myFirstIntQueue.append(mySecondIntQueue);
		assertTrue(myFirstIntQueue.size() == 3);
		for (int i = 1; i <= 3; i++) {
			int k = myFirstIntQueue.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
		assertTrue("Queue not empty", myFirstIntQueue.isEmpty());
		assertTrue("Queue not empty", mySecondIntQueue.isEmpty());

	}

	@Test
	public void testConcatNonEmptyQueueAndEmpty() {
		myFirstIntQueue.offer(1);
		myFirstIntQueue.offer(2);
		myFirstIntQueue.offer(3);
		myFirstIntQueue.append(mySecondIntQueue);
		assertTrue(myFirstIntQueue.size() == 3);
		for (int i = 1; i <= 3; i++) {
			int k = myFirstIntQueue.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
		assertTrue("Queue not empty", myFirstIntQueue.isEmpty());
	}

	@Test
	public void testTwoNonEmptyQueue() {
		myFirstIntQueue.offer(1);
		myFirstIntQueue.offer(2);
		myFirstIntQueue.offer(3);
		mySecondIntQueue.offer(4);
		mySecondIntQueue.offer(5);
		mySecondIntQueue.offer(6);
		myFirstIntQueue.append(mySecondIntQueue);
		assertTrue(myFirstIntQueue.size() == 6);

		for (int i = 1; i <= 6; i++) {
			int k = myFirstIntQueue.poll();
			assertEquals("poll returns incorrect element", i, k);
		}
		assertTrue("Queue not empty", myFirstIntQueue.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testQueueMergeWithItself() {
		myFirstIntQueue.append(myFirstIntQueue);
	}

}
