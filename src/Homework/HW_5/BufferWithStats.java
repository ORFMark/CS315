package Homework.HW_5;
public class BufferWithStats extends BufferOfInts {

    public BufferWithStats(int size) {
        super(size);
    }
    
    public double getMean() {
        return  (getSum() / (double) numberOfValues);
    }
    
    public int getSum() {
        int sumOfValues = 0;
        for(int i = 0; i < numberOfValues; i++) {
        	sumOfValues += i;
        }
        return sumOfValues;
    }
    
    public int getMax() {
        int maxValue = 0;
        for(int i = 0; i < numberOfValues; i++) {
        	if (i == 0 || arrayOfValues[i] > maxValue) {
        		maxValue = arrayOfValues[i];
        	}
        }
        return maxValue;
    }
    
    public int getMin() {
        // TODO: determine the max value in the array
        // Note that the best solution sets max to 0, and
        // ... replaces it if i is 0, or if a lower value found
        // ... That way it returns 0 if buffer is empty.
        int minValue = 0;
        for(int i = 0; i < numberOfValues; i++) {
        	if (i == 0 || arrayOfValues[i] < minValue) {
        		minValue = arrayOfValues[i];
        	}
        }
        return minValue;
    }
    
    public int getFrequencyOfValue(int value) {
        int frequency = 0;
        // TODO: count up the number of times value appear in the array.
        // ... This function is needed for a "brute force" getMode
        for(int i = 0; i < numberOfValues; i++) {
        	if (arrayOfValues[i] == value) {
        		frequency++;
        	}
        }
        return frequency;
    }
    
    public int getMode() {
        int modeFrequency = 0;
        int modeValue = 0;
        int valueFrequency = 0;
        int value = 0;
        // TODO: for each array value, get its frequency, and if the new
        // ... frequency is higher, replace the two mode variables.
        // This approach is called "brute force" because
        // ... you just go through and test all possibilities.
        for(int i = 0; i < numberOfValues; i++) {
        	value = arrayOfValues[i];
        	valueFrequency = getFrequencyOfValue(value);
        	if (modeFrequency < valueFrequency) {
        		modeFrequency = valueFrequency;
        		modeValue = value;
        	}
        }
        return modeValue;
    }

}
