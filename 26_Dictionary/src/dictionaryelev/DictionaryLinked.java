package dictionaryelev;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

	private Node start;
	private int size;

	/**
	 * HashingMap constructor comment.
	 */

	public DictionaryLinked() {
		// Sentinel (tomt listehoved - der ikke indeholder data)
		start = new Node();
		size = 0;
	}

	@Override
	public V get(K key) {
		Node current = start.next;
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		Node current = start;
		while (current.next != null) {
			if (current.next.key.equals(key)) {
				V oldValue = current.next.value;
				current.next.value = value;
				return oldValue;
			}
			current = current.next;
		}
		Node node = new Node();
		node.key = key;
		node.value = value;
		current.next = node;
		size++;
		return null;
	}

	@Override
	public V remove(K key) {
		Node current = start;
		while (current.next != null) {
			if (current.next.key.equals(key)) {
				V oldValue = current.next.value;
				current.next = current.next.next;
				size--;
				return oldValue;
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public int size() {

		return size;
	}

	private class Node {
		Node next;
		K key;
		V value;
	}

}
