package opgave3sortedlinkelistdouble;

public class SortedLinkedListDouble {

	private Node first;
	private Node last;
	private int size;

	public SortedLinkedListDouble() {
		first = new Node();
		last = new Node();
		first.next = last;
		last.prev = first;
		size = 0;
	}

	/**
	 * Tilføjer e til listen, så listen fortsat er sorteret i henhold til den
	 * naturlige ordning på elementerne
	 */
	public void addElement(String e) {
		Node node = new Node();
		node.data = e;
		if (first.next == null) {
			node.prev = first;
			node.next = last;
			first.next = node;
			last.prev = node;
		} else {
			Node temp = first;
			while (temp.next != last && e.compareTo(temp.next.data) > 0) {
				temp = temp.next;
			}
			node.prev = temp;
			node.next = temp.next;
			temp.next.prev = node;
			temp.next = node;
		}
		size++;
	}

	/**
	 * Fjerner den første forekomst af e i listen. Listen skal fortsat være
	 * sorteret i henhold til den naturlige ordning på elementerne.
	 *
	 * @return true hvis e blev fjernet fra listen ellers returneres false.
	 */
	public boolean removeElement(String e) {
		if (first.next == last) {
			return false;
		} else {
			Node temp = first;
			while (temp.next != last && !temp.next.data.equals(e)) {
				temp = temp.next;
			}
			if (temp.next != last) {
				temp.next = temp.next.next;
				temp.next.prev = temp;
			}
		}
		size--;
		return true;
	}

	/**
	 * Udskriver elementerne fra listen i sorteret rækkefølge
	 */
	public void udskrivElements() {
		Node temp = first.next;
		while (temp != last) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Udskriver elementerne fra listen i sorteret rækkefølge bagfra
	 */
	public void udskrivBagfra() {
		Node temp = last.prev;
		while (temp != first) {
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}

	/**
	 * Returnerer antallet af elementer i listen
	 */
	public int countElements() {
		return size;
	}

	// Privat indre klasse der modellerer en node i en dobbeltkædet liste
	class Node {
		public String data;
		public Node next;
		public Node prev;
	}
}
