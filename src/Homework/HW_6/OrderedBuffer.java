package Homework.HW_6;

public class OrderedBuffer extends BufferOfInts {

    public OrderedBuffer(int size) {
        super(size);
    }
    
    private int indexToPutInOrder(int value) {
        for (int i = 0; i < numberOfValues; i++)
            if (arrayOfValues[i] > value)
                return i;
        return numberOfValues;
    }
        
    public boolean add(int value) {
        if (numberOfValues < arrayOfValues.length) {
            insertAtIndex(value, indexToPutInOrder(value));
            return true;
        } else
            return false;
    }

}
