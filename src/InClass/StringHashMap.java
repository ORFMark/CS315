package InClass;



public class StringHashMap {
	LinkedList table[];
	int sizeOfTable;
	StringHashMap(int size) {
		table = new LinkedList[size];
		sizeOfTable = size;
	}
	
	
	private int hashFunction(String value) {
		int key = 0;
		for (int i = 0; i <value.length(); i++) {
			key += (int) value.charAt(i) * (i+1);
		}
		return key % sizeOfTable;
	}
	
	public void insert(String name) {
		int index = hashFunction(name);
		table[index].insertAsHead(new SingleLink(name));
	}
	
	public boolean hasName(String name) {
		int index = hashFunction(name);
		return table[index].hasValue(name);
	}
}
