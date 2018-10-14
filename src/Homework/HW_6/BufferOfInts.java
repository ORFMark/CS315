package Homework.HW_6;

/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 1
 */
public class BufferOfInts {
    protected int[] arrayOfValues;
    protected int numberOfValues;
    
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

    public boolean removeAtIndex(int index) {
        if (index >= 0 && index < numberOfValues) {
            numberOfValues--;
            for (int i = index; i < numberOfValues; i++)
                arrayOfValues[i] = arrayOfValues[i + 1];
            return true;
        } else
            return false;
    }

    public void insertAtIndex(int value, int index) {
        if (numberOfValues < arrayOfValues.length 
                && index >= 0 && index <= numberOfValues) {

            for (int i = numberOfValues; i > index; i--)
                arrayOfValues[i] = arrayOfValues[i - 1];
            arrayOfValues[index] = value;
            numberOfValues++;
        }
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
    
    public int copy(BufferOfInts bufferToCopy) {
        clear();
        return addArray(bufferToCopy.arrayOfValues, 0,
                bufferToCopy.numberOfValues);
    }

    public BufferOfInts clone() {
        BufferOfInts duplicate = new BufferOfInts(arrayOfValues.length);
        duplicate.copy(this);
        return duplicate;
    }

}
