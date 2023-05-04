package hashsetstudent;

/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetLinearProbing {
	private Object[] buckets;
	private int currentSize;
	private static final String DELETED = "DELETED";

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSetLinearProbing(int bucketsLength) {
		buckets = new Object[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 *
	 * @param x
	 *            an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		int h = hashValue(x);
		Object object = buckets[h];
		boolean found = false;
		while (!(found || object == null)) {
			if (object.equals(x)) {
				found = true;
			} else {
				h = (h + 1) % buckets.length;
				object = buckets[h];
			}
		}
		return found;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		if (contains(x)) { return false; }

		double loadFactor = (double) currentSize / buckets.length;
		if (loadFactor > 0.5) {
			rehash();
		}

		int h = hashValue(x);
		Object object = buckets[h];

		while (!(object == null || object == DELETED)) {
			h = (h + 1) % buckets.length;
			object = buckets[h];
		}
		buckets[h] = x;
		currentSize++;
		return true;
	}

	/**
	 * Removes an object from this set.
	 *
	 * @param x
	 *            an object
	 * @return true if x was removed from this set, false if x was not an
	 *         element of this set
	 */
	public boolean remove(Object x) {
		int h = hashValue(x);
		boolean removed = false;
		Object object = buckets[h];
		while (!(removed || object == null)) {
			if (object.equals(x)) {
				buckets[h] = DELETED;
				currentSize--;
				removed = true;
			} else {
				h = (h + 1) % buckets.length;
				object = buckets[h];
			}
		}
		return removed;
	}

	private void rehash() {
		currentSize = 0;
		Object[] oldBuckets = buckets;
		buckets = new Object[oldBuckets.length * 2 + 1];
		for (Object o : oldBuckets) {
			if (!(o == null || o == DELETED)) {
				add(o);
			}
		}
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	private int hashValue(Object x) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % buckets.length;
		return h;
	}

	// method only for test purpose
	public void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			System.out.println(i + "\t" + buckets[i]);
		}
	}
}
