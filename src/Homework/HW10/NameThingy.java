package Homework.HW10;

public class NameThingy implements Comparable<NameThingy> {
    private String name;
    // next pointer to support separate chaining
    protected NameThingy next;

    public NameThingy(String name) {
        this.name = name;
        next = null;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(NameThingy other) {
        return name.compareTo(other.name);
    }

    public boolean equals(NameThingy other) {
        return name.equals(other.name);
    }

    public boolean equals(String other) {
        return name.equals(other);
    }

    public int getHash(int size) {
        return getHash(name, size);
    }

    @Override
    public String toString() {
        return name;
    }

    public static int getHash(String name, int tableSize) {
        return (Math.abs(name.hashCode()) % tableSize);
    }
}
