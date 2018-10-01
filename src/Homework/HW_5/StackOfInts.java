package Homework.HW_5;
public class StackOfInts {
    BufferOfInts stackBuffer;
    
    public StackOfInts(int size) {
        stackBuffer = new BufferOfInts(size);
    }

    public boolean push(int value) {
        if(stackBuffer.getNumberOfValues() < stackBuffer.getArrayLength()) {
        	stackBuffer.insertAtIndex(value, 0);
        	return true;
        }
        return false;
    }
    
    public int pop() {
        // TODO: code to get the last added value,
        // ... remove it from the buffer, and then return it.
    	int value = stackBuffer.getValueAtIndex(0);
    	stackBuffer.removeAtIndex(0);
        return value;
    }

}

