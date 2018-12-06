package queue_singlelinkedlist;

import java.util.*;

import sun.net.www.content.text.plain;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		if (size == 0) {
			last = new QueueNode<E>(e);
			last.next = last;
			size++;
			return true;

		} else {
			QueueNode<E> pLast = last;
			last = new QueueNode<E>(e);
			last.next = pLast.next;
			pLast.next = last;
			size++;
			return true;

		}
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (size > 0) {
			return last.next.element;
		}
		return null;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (size > 0) {
			QueueNode<E> head = last.next;
			last.next = head.next;
			size--;
			return head.element;

		} else {
			return null;
		}

	}
	
	public void append(FifoQueue<E> q) {
		if(q == this) {
			throw new IllegalArgumentException();
		}else if(q.isEmpty()) {
			return;
		} else if (this.isEmpty()) {
			last = q.last;
			size = q.size;
		}else {
			QueueNode<E> head = last.next;
			last.next = q.last.next;
			last = q.last;
			last.next = head;
			size +=q.size;
		}
		
		
		
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new OueueIterator();
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	private class OueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		public OueueIterator() {
			pos = last;
		}

		@Override
		public boolean hasNext() {
			if (pos != null) {
				return true;

			} else {
				return false;

			}
		}

		@Override
		public E next() {
			if (pos == null) {
				throw new NoSuchElementException();
			} else {
				QueueNode<E> prev = pos.next;
				pos = pos.next;
				if (pos == last) {
					pos = null;
				}
				return prev.element;

			}

		}

	}

}
