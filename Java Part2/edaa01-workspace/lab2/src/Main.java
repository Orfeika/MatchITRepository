import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import queue_singlelinkedlist.FifoQueue;

public class Main {

	public static void main(String[] args) {
		FifoQueue<Integer> myFirstIntQueue = new FifoQueue<>();
		FifoQueue<Integer> mySecondIntQueue = new FifoQueue<>();


		myFirstIntQueue.offer(1);
		myFirstIntQueue.offer(2);
		myFirstIntQueue.offer(3);
		mySecondIntQueue.offer(4);
		mySecondIntQueue.offer(5);
		mySecondIntQueue.offer(6);
		myFirstIntQueue.append(mySecondIntQueue);
		assertTrue(myFirstIntQueue.size() == 6);

		for (int i = 1; i <= 6; i++) {
			System.out.println(myFirstIntQueue.poll());

		}

	}

}
