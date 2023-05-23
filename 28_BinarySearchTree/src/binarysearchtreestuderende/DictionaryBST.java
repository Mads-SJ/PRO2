package binarysearchtreestuderende;

public class DictionaryBST<K extends Comparable<K>, V> implements
Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
		Node node = find(key);
		V value = null;
		if (node != null) {
			value = node.value;
		}
		return value;

	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return found ? current : null;

	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public V put(K key, V value) {
		/*V oldValue = null;
		Node currentsParent = null;
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			currentsParent = current;
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			oldValue = current.value;
			current.value = value;
		} else {
			Node newNode = new Node(key, value);
			if (currentsParent == null) {
				root = newNode;
			}
			else {
				currentsParent.addNode(newNode);
			}
		}*/
		Node oldNode = find(key);
		V oldValue = null;
		if (oldNode != null) {
			oldValue = oldNode.value;
		}

		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
		}
		else {
			root.addNode(newNode);
		}
		return oldValue;
	}

	@Override
	public V remove(K key) {
		Node toBeRemoved = root;
		Node parent = null;
		V toReturn = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int d = toBeRemoved.key.compareTo(key);
			if (d == 0) {
				found = true;
				toReturn = toBeRemoved.value;
			} else {
				parent = toBeRemoved;
				if (d > 0) {
					toBeRemoved = toBeRemoved.left;
				} else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}

		if (found) {

			// toBeRemoved contains obj

			// If one of the children is empty, use the other

			if (toBeRemoved.left == null || toBeRemoved.right == null) {
				Node newChild;
				if (toBeRemoved.left == null) {
					newChild = toBeRemoved.right;
				} else {
					newChild = toBeRemoved.left;
				}

				if (parent == null) // Found in root
				{
					root = newChild;
				} else if (parent.left == toBeRemoved) {
					parent.left = newChild;
				} else {
					parent.right = newChild;
				}

			} else {

				// Neither subtree is empty

				// Find smallest element of the right subtree

				Node smallestParent = toBeRemoved;
				Node smallest = toBeRemoved.right;
				while (smallest.left != null) {
					smallestParent = smallest;
					smallest = smallest.left;
				}

				// smallest contains smallest child in right subtree

				// Move contents, unlink child

				toBeRemoved.key = smallest.key;
				toBeRemoved.value = smallest.value;
				if (smallestParent == toBeRemoved) {
					smallestParent.right = smallest.right;
				} else {
					smallestParent.left = smallest.right;
				}
			}
		}
		return toReturn;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		/**
		 * Inserts a new node as a descendant of this node.
		 *
		 * @param newNode
		 *            the node to insert
		 */
		private void addNode(Node newNode) {
			int comp = newNode.key.compareTo(key);
			if (comp < 0) {
				if (left == null) {
					left = newNode;
				}
				else {
					left.addNode(newNode);
				}
			}
			else if (comp > 0) {
				if (right == null) {
					right = newNode;
				}
				else {
					right.addNode(newNode);
				}
			}
			else {
				value = newNode.value;
			}
		}
	}
}
