package Homework.HW_5;
public class QueueOfInts {
    BufferOfInts queueBuffer;

    public QueueOfInts(int size) {
        queueBuffer = new BufferOfInts(size);
    }

    public boolean enqueue(int value) {
        // TODO: code to add value to buffer so that dequeue() does
        // ... the right thing.
        // ... Return true if added, false if could not be added
        return queueBuffer.add(value);
    }
    
    public int dequeue() {
        // TODO: code to get the first added value,
        // ... remove it from the buffer, and then return it.
    	int value = queueBuffer.getValueAtIndex(0);
    	queueBuffer.removeAtIndex(0);
        return value;
    }
}
