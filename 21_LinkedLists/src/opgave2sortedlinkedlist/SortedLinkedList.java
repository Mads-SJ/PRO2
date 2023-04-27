package opgave2sortedlinkedlist;

import opgave3sortedlinkelistdouble.SortedLinkedListDouble;
import org.w3c.dom.Node;

public class SortedLinkedList {
	private Node first;

	public SortedLinkedList() {
		first = null;
	}

	/**
	 * Tilføjer e til listen, så listen fortsat er sorteret i henhold til den
	 * naturlige ordning på elementerne
	 */
	public void addElement(String e) {
		// Første forsøg
		/*Node node = new Node();
		node.data = e;
		if (first == null) {
			first = node;
		} else if (first.next == null) {
			if (first.data.compareTo(e) <= 0) {
				first.next = node;
			} else {
				node.next = first;
				first = node;
			}
		} else {
			boolean inserted = false;
			Node temp = first;
			while (!inserted && temp.next != null) {
				if (temp.data.compareTo(e) <= 0 && e.compareTo(temp.next.data) <= 0) {
					node.next = temp.next;
					temp.next = node;
					inserted = true;
				}
				temp = temp.next;
			}
			if (!inserted) {
				temp.next = node;
			}
		}*/
		Node node = new Node();
		node.data = e;
		if (first == null) {
			first = node;
		} else if (e.compareTo(first.data) <= 0) {
			node.next = first;
			first = node;
		} else {
			Node temp = first;
			while (temp.next != null
					&& e.compareTo(temp.next.data) > 0) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
		}
	}

	/**
	 * Udskriver elementerne fra listen i sorteret rækkefølge
	 */
	public void udskrivElements() {
		Node temp = first;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Returnerer antallet af elementer i listen
	 */
	public int countElements() {
		Node temp = first;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}


	/**
	 * Fjerner det sidste (altså det største) element i listen. Listen skal fortsat være
	 * sorteret i henhold til den naturlige ordning på elementerne.
	 *
	 * @return true hvis der blev fjernet fra listen ellers returneres false.
	 */
	public boolean removeLast() {
		if (first == null) {
			return false;
		} else if (first.next == null) {
			first = null;
		} else {
			Node temp = first;
			Node prev = null;
			while(temp.next != null) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = null;
		}
		return true;
	}

	/**
	 * Fjerner den første forekomst af e i listen. Listen skal fortsat være
	 * sorteret i henhold til den naturlige ordning på elementerne.
	 *
	 * @return true hvis e blev fjernet fra listen ellers returneres false.
	 */
	public boolean removeElement(String e) {
		/*boolean removed = false;
		if (first == null) {
			removed = false;
		} else if (first.data.equals(e)) {
			first = first.next;
			removed = true;
		}else {
			Node temp = first;
			while (!removed && temp.next != null) {
				if (temp.next.data.equals(e)) {
					temp.next = temp.next.next;
					removed = true;
				}
			}
		}
		return removed;*/

		if (first == null) {
			return false;
		} else if (first.data.equals(e)) {
			first = first.next;
		} else {
			Node temp = first;
			while (temp.next != null && !temp.next.data.equals(e)) {
				temp = temp.next;
			}
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
		}
		return true;
	}

	/**
	 * Tilføjer alle elementerne fra list til den aktuelle liste.
	 * Listen er fortsat sorteret i henhold til den naturlige ordning på
	 * elementerne.
	 */
	public void addAll(SortedLinkedList list) {
		Node temp = list.first;
		while (temp != null) {
			addElement(temp.data);
			temp = temp.next;
		}
	}

	private int countElementsRecursive(Node node) {
		if (node == null) {
			return 0;
		}
		else {
			return countElementsRecursive(node.next) + 1;
		}
	}

	public int countElementsRecursive() {
		return countElementsRecursive(first);
	}

	// Privat indre klasse der modellerer en node i listen
	private class Node {
		public String data;
		public Node next;
	}
}
