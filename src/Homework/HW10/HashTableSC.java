package Homework.HW10;

public class HashTableSC extends HashTable {

	public HashTableSC(int size) {
		super(size);
	}

	@Override
	public void insert(String name) {
		HashTableString newString = new HashTableString(name);
		int hash = newString.getHash(size);
		if (table[hash] == null) {
			table[hash] = newString;
		} else {
			HashTableString current = table[hash];
			while (current.next != null) {
				current = current.next;
			}
			current.next = newString;

		}
		numberOfItems++;
	}

	@Override
	public boolean find(String name) {
		HashTableString stringToFind = new HashTableString(name);
		int hash = stringToFind.getHash(size);
		if (table[hash] == null) {
			return false;
		} else {
			HashTableString location = table[hash];
			while (location != null) {
				if (table[hash].equals(stringToFind)) {
					return true;
				}
				else {
					location = location.next;
				}
				
			}
			return false;
		}
	}

	@Override
	public boolean remove(String name) {
		HashTableString stringToRemove = new HashTableString(name);
		int hash = stringToRemove.getHash(size);
		if (table[hash] != null) {

			if (table[hash].equals(stringToRemove)) {
				table[hash] = table[hash].next;
				return true;
			} else {
				HashTableString current = table[hash].next;
				HashTableString previous = table[hash];
				while (current != null) {
					if (current.equals(stringToRemove)) {
						previous.next = current.next;
						return true;
					}
					else {
						previous= current;
						current = current.next;
					}
				}
				return false;
			}

		} else {
			return false;
		}
	}

}
