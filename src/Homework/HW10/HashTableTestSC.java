package Homework.HW10;

public class HashTableTestSC extends HashTableSC implements ChainTest {

    public HashTableTestSC(int size) {
        super(size);
    }

    @Override
    public int reportMaxChain() {
        int maxChainLength = 0;
        int maxChainLocation = 0;
        NameThingy link;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (link = table[i]; link != null; link = link.next)
                count++;
            if (count > maxChainLength) {
                maxChainLength = count;
                maxChainLocation = i;
            }
        }
        System.out.println("Max Chain length is: " + maxChainLength);
        return maxChainLocation;
    }

    @Override
    public void displayChain(int i) {
        for (NameThingy link = table[i]; link != null; link = link.next)
            System.out.println(
                    "  hash [" + link.getHash(size) + "]: " + link.getName());
    }


}
