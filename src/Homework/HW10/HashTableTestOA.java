package Homework.HW10;

public class HashTableTestOA extends HashTableOA implements ChainTest {

    public HashTableTestOA(int size) {
        super(size);
    }

    public int reportMaxChain() {
        if (numberOfItems >= size)
            return size;
        int maxChainLength = 0;
        int maxChainLocation = 0;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = i; table[j] != null; count++) {
                j++;
                if (j >= size)
                    j = 0;
            }
            if (count > maxChainLength) {
                maxChainLength = count;
                maxChainLocation = i;
            }
        }
        System.out.println("Max Chain length is: " + maxChainLength);
        return maxChainLocation;
    }

    public void displayChain(int i) {
        while (table[i] != null) {
            System.out.println("  hash: " + table[i].getHash(size)
                    + " at [" + i + "]: " + table[i].getName());
            i++;
            if (i >= size)
                i = 0;
        }
    }

}
