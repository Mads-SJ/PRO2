package queueopgaver;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a array.
 */
public class ArrayQueue implements QueueI {
	private int head;
	private int tail;
	private Object[] queue = new Object[10];
	private int size;

	/**
	 * Constructs an empty queue.
	 */
	public ArrayQueue() {
		head = 0;
		tail = 0;
		size = 0;
	}

	/**
	 * Checks whether this queue is empty.
	 *
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds an element to the tail of this queue.
	 *
	 * @param newElement
	 *            the element to add
	 */
	@Override
	public void enqueue(Object newElement) {
		if (size == queue.length) {
			grow();
		}
		queue[tail] = newElement;
		tail++;
		size++;
	}

	/**
	 * Removes an element from the head of this queue.
	 *
	 * @return the removed element
	 */
	@Override
	public Object dequeue() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Object o = queue[head];
		queue[head] = null;
		head++;
		size--;
		return o;
	}

	/**
	 * Returns the head of this queue. The queue is unchanged.
	 *
	 * @return the head element
	 */
	@Override
	public Object getFront() {
		return queue[head];
	}

	/**
	 * The number of elements on the queue.
	 *
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {
		return size;
	}

	private void grow() {
		Object[] newQueue = new Object[size * 2];
		for (int i = 0; i < size; i++) {
			newQueue[i] = queue[i];
		}
		queue = newQueue;
	}
}
