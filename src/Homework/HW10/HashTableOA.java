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
		int startHash = hash;
		if (table[hash] == null) {
			table[hash] = nameToInsert;
			numberOfThingies++;
		}
		else {
			do {
				hash++; 
				if (hash >= size) {
					hash = 0;
				} 
				if (table[hash] == null) {
					table[hash] = nameToInsert;
					numberOfThingies++;
					return;
				}

			} while (table[hash] != null);
		}
	}
	/*
	public void insert(String name) {
		// Protect against filling table, leaving at least 1 null
		if (numberOfThingies >= (size - 1))
			return;
		// TODO Auto-generated method stub
		NameThingy nameToInsert = new NameThingy(name);
		int hash = nameToInsert.getHash(size);
		int startHash = hash;
		if (table[hash] == null) {
			table[hash] = nameToInsert;
			numberOfThingies++;
		} else {
			while (table[hash] != null) {
				if (hash >= size) {
					hash = 0;
				} else if (hash == startHash) {
					return;
				}
				else {
					hash++;
				}
			}
			table[hash] = nameToInsert;
			numberOfThingies++;
		}
	}
	 */

	@Override
	public boolean find(String name) {
		NameThingy stringToFind = new NameThingy(name);
		int hash = stringToFind.getHash(size);
		int startHash = hash;
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
				else if (hash == startHash) {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	/*
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
		index++;
		while(table[index] != null) {
			index++;
			if (index >= size) {
				index = 0;
			}
			else if (index == hole) {
				return;
			}
			if (table[index] != null && table[index].getHash(size) <= hole && table[index].getHash(size)  != index) {
				table[hole] = table[index];
				remove(index);
				return;
			}
		}
	}
	 */	

	public boolean remove(String name) {
		NameThingy nameToRemove = new NameThingy(name);
		int hash = nameToRemove.getHash(size);
		int startHash = hash;
		while (table[hash] != null)  {
			if (table[hash].equals(nameToRemove)) {
				numberOfThingies--;
				remove(hash);
				return true;
			}
			else if (hash >= size) {
				hash = 0;
			}
			else if (hash == startHash) {
				return false;
			}


		}
		return false;
	}

	private void remove(int index) {
		// set index location to empty
		int startIndex = index;
		table[index] = null;
		// look for contiguous entry that hashed to index or earlier
		// move entry to just vacated index location
		// recurse to do same check for new location
		int hole = index;
		do {
			index++;
			if (index >= size) {
				index = 0;
			} 
			if (index == startIndex) {
				return;
			}
			if (table[index] != null && table[index].getHash(size) <= hole && table[index].getHash(size) != index) {
				table[hole] = table[index];
				remove(index);
				return;
			}

		} while (table[index] != null);
	}

}
