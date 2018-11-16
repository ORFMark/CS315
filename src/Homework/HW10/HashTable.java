package Homework.HW10;

public abstract class HashTable {
    protected NameThingy table[];
    protected int size;
    protected int numberOfThingies;
    
    public HashTable(int size) {
        table = new NameThingy[size];
        this.size = size;
        numberOfThingies = 0;
    }
    
    public int getNumberOfThingies() {
        return numberOfThingies;
    }
    
    public abstract void insert(String name);
    public abstract boolean find(String name);
    public abstract boolean remove(String name);
    // public abstract int reportMaxChain();
    // public abstract void displayChain(int index);
}
