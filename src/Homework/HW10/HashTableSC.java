package Homework.HW10;

public class HashTableSC extends HashTable {

	public HashTableSC(int size) {
		super(size);
	}

	@Override
	public void insert(String name) {
		NameThingy newString = new NameThingy(name);
		int hash = newString.getHash(size);
		if (table[hash] == null) {
			table[hash] = newString;
		} else {
			NameThingy current = table[hash];
			while (current.next != null) {
				current = current.next;
			}
			current.next = newString;

		}
		numberOfThingies++;
	}

	@Override
	public boolean find(String name) {
		NameThingy stringToFind = new NameThingy(name);
		int hash = stringToFind.getHash(size);
		NameThingy current = table[hash];
		while (current != null) {
			if (current.equals(stringToFind)) {
				return true;
			}
			else {
				current = current.next;
			}
		}
		return false;
		
	}

	@Override
	public boolean remove(String name) {
		NameThingy stringToRemove = new NameThingy(name);
		int hash = stringToRemove.getHash(size);
		if (table[hash] != null) {
			if (table[hash].equals(stringToRemove)) {
				table[hash] = table[hash].next;
				numberOfThingies--;
				return true;
			} else {
				NameThingy current = table[hash].next;
				NameThingy previous = table[hash];
				while (current != null) {
					if (current.equals(stringToRemove)) {
						previous.next = current.next;
						numberOfThingies--;
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
