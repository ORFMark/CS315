package Homework.HW_4;
/**
 * @author Your Name? youremail? @ my.erau.edu
 * @version version? Homework assignment 4 (date?)
 */
public class BubbleVariants extends BufferOfInts {

    public BubbleVariants(int size) {
        super(size);
    }

    private void swap(int indexA, int indexB) {
        int temp = arrayOfValues[indexA];
        arrayOfValues[indexA] = arrayOfValues[indexB];
        arrayOfValues[indexB] = temp;
        moveCount += 3;
    }

    private void bubble(int lengthOverWhichToBubble) {
        // TODO: single pass of bubbling, returns nothing
    }

    private boolean ifBubble(int lengthOverWhichToBubble) {
        // TODO: single pass of bubbling, returns true if anything swapped
        return false;
    }

    private int lastBubble(int lengthOverWhichToBubble) {
        // TODO: single pass of bubbling, returns index of last thing swapped
        return 0;
    }

    public void bubbleSort1() {
        // TODO: original simple bubble sort, bubbles one less each time
    }

    public void bubbleSort2() {
        // TODO: more efficient bubble sort, stops when nothing changed
    }

    public void bubbleSort3() {
        // TODO: even more efficient bubble sort, stops at last thing changed
    }

    public void shuffle() {
        for (int i = 0; i < numberOfValues; i++)
            swap(i, HW4.getRandBetween(0, numberOfValues - 1));
    }

    public void reverseOrder() {
        for (int i = 0, j = numberOfValues - 1; i < j; i++, j--)
            swap(i, j);
    }

    public void startTest(String testName) {
        moveCount = 0;
        compareCount = 0;
        System.out.println("Starting " + testName + " test.");
        displayAsTable(10);
    }

    public void finishTest() {
        System.out.println("Finished test.");
        System.out.printf("%4d/%-4d compares/moves\n", compareCount, moveCount);
        displayAsTable(10);
    }

    protected int compareCount;
    protected int moveCount;

}
