package Homework.HW10;

/*
 * mostly Generated on my own, refined with the help 
 */
public class HashTableOA extends HashTable {

	public HashTableOA(int size) {
		super(size);
	}

	@Override
	public void insert(String name) {
		// Protect against filling table, leaving at least 1 null
		if (numberOfThingies >= (size - 1))
			return;
		// TODO Auto-generated method stub
		NameThingy nameToInsert = new NameThingy(name);
		int hash = nameToInsert.getHash(size);
		if (table[hash] == null) {
			table[hash] = nameToInsert;
			numberOfThingies++;
		} else {
			hash++;
			while (table[hash] != null) {
				if (hash > size) {
					hash = 0;
				} else {
					hash++;
				}
			}
			table[hash] = nameToInsert;
			numberOfThingies++;
		}
	}



	@Override
	public boolean find(String name) {
		NameThingy stringToFind = new NameThingy(name);
		int hash = stringToFind.getHash(size);
		//System.out.println(name + " Should be found at or near " + hash + "Which is " + table[hash]);
		if (table[hash] != null) {
			while (table[hash] != null) {
				if (table[hash].equals(stringToFind)) {
					return true;
				}
				hash++;
				if (hash >= size) {
					hash = 0;
				}
			}
		}
		return false;
	}

	@Override
	public boolean remove(String name) {
		NameThingy nameToRemove = new NameThingy(name);
		int hash = nameToRemove.getHash(size);
		while (table[hash] != null)  {
			if (table[hash].equals(nameToRemove)) {
				numberOfThingies--;
				remove(hash);
				return true;
			}
			else {
				hash++;
			}
		}
		return false;
	}

	private void remove(int index) {
		// set index location to empty
		table[index] = null;
		// look for contiguous entry that hashed to index or earlier
		// move entry to just vacated index location
		// recurse to do same check for new location
		int hole = index;
		while(table[++index] != null) {
			if (table[index].getHash(size) <= hole && table[index].getHash(size)  != index) {
				table[hole] = table[index];
				remove(index);
				return;
			}
		}
	}

}
