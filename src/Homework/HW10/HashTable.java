package Homework.HW10;

public abstract class HashTable {
    protected HashTableString table[];
    protected int size;
    protected int numberOfItems;
    
    public HashTable(int size) {
        table = new HashTableString[size];
        this.size = size;
        numberOfItems = 0;
    }
    
    public int getNumberOfThingies() {
        return numberOfItems;
    }
    
    public abstract void insert(String name);
    public abstract boolean find(String name);
    public abstract boolean remove(String name);
    // public abstract int reportMaxChain();
    // public abstract void displayChain(int index);
}
