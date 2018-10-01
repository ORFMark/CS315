package Homework.HW_4;
/**
 * @author Mark Burrell burrelm1 @ my.erau.edu
 * @version 1.0 Homework assignment 4 (9/27/2018)
 */
public class BufferOfInts {
    protected int[] arrayOfValues;
    protected int numberOfValues;

    // constructor
    public BufferOfInts(int size) {
        arrayOfValues = new int[size];
        numberOfValues = 0;
    }

    public int getArrayLength() {
        return arrayOfValues.length;
    }

    public int getNumberOfValues() {
        return numberOfValues;
    }

    public int getValueAtIndex(int index) {
        if (index >= 0 && index < numberOfValues)
            return arrayOfValues[index];
        else
            return 0;
    }

    public boolean add(int value) {
        if (numberOfValues < arrayOfValues.length) {
            arrayOfValues[numberOfValues] = value;
            numberOfValues++;
            return true;
        } else
            return false;
    }

    public int addArray(int[] array, int firstIndex, int lastIndex) {
        int count = 0;
        for (int i = firstIndex; i <= lastIndex; i++)
            if (i >= 0 && i < array.length && add(array[i]))
                count++;
        return count;
    }

    public int findFirstOccurence(int value) {
        for (int i = 0; i < numberOfValues; i++)
            if (arrayOfValues[i] == value)
                return i;
        return -1;
    }

    public int findLastOccurence(int value) {
        for (int i = numberOfValues - 1; i >= 0; i--)
            if (arrayOfValues[i] == value)
                return i;
        return -1;
    }

    public boolean removeStable(int index) {
        if (index >= 0 && index < numberOfValues) {
            numberOfValues--;
            for (int i = index; i < numberOfValues; i++)
                arrayOfValues[i] = arrayOfValues[i + 1];
            return true;
        } else
            return false;
    }

    public boolean removeQuick(int index) {
        if (index >= 0 && index < numberOfValues) {
            numberOfValues--;
            arrayOfValues[index] = arrayOfValues[numberOfValues];
            return true;
        } else
            return false;
    }

    public void clear() {
        numberOfValues = 0;
    }

    public void displayAsTable(int numberOfColumns) {
        for (int i = 0; i < numberOfValues; i++) {
            if (i > 0 && i % numberOfColumns == 0)
                System.out.println();
            System.out.format("%6d", arrayOfValues[i]);
        }
        System.out.println();
    }

    public int copyByDirectAssignment(BufferOfInts bufferToCopy) {
        int count = 0;
        for(int i = 0; i < bufferToCopy.numberOfValues && i < arrayOfValues.length; i++) {
        	arrayOfValues[i] = bufferToCopy.arrayOfValues[i];
        	count++;
        }
        numberOfValues = count;
        return count;
    }

    public int copyUsingAddArray(BufferOfInts bufferToCopy) {
        clear();
        return addArray(bufferToCopy.arrayOfValues, 0, bufferToCopy.getNumberOfValues() - 1);
    } 

    public BufferOfInts clone() {
       BufferOfInts buff = new BufferOfInts(arrayOfValues.length);
       buff.copyUsingAddArray(this);
       return buff;
    }

}
