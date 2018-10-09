package Homework.HW_5;
public class StackOfInts {
    BufferOfInts stackBuffer;
    
    public StackOfInts(int size) {
        stackBuffer = new BufferOfInts(size);
    }

    public boolean push(int value) {
        return stackBuffer.add(value);
    }
    
    public int pop() {
        // TODO: code to get the last added value,
        int end = stackBuffer.getNumberOfValues() - 1;
    	int value = stackBuffer.getValueAtIndex(end);
    	stackBuffer.removeAtIndex(end);
        return value;
    }

}

