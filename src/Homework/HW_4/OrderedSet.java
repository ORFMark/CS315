package Homework.HW_4;
/**
 * @author Mark Burrell burrelm1@my.erau.edu;
 * @version version? Homework assignment 4 (9/27/2018)
 */
public class OrderedSet extends BufferOfInts {

    public OrderedSet(int size) {
        super(size);
    }
    private int recursiveSearch(int value, int low, int high) {
    	int middle = (high + low) / 2;
    	if (low > high) {
    		return -1;
    	}
    	else if (arrayOfValues[middle] < value) {
    		return recursiveSearch(value, middle+1, high);
    	}
    	else if (arrayOfValues[middle] > value) {
    		return recursiveSearch(value, low, middle-1);
    	}
    	else {
    		return middle;
    	}
    }
    public boolean removeQuick(int index) {
        // Do not change: removeQuick is not permitted on OrderedSet
        return false;
    }
    
    private int indexToPutInOrder(int value) {
    	for(int i = 0; i < numberOfValues; i++) {
    		if(arrayOfValues[i] > value)
    		{
    			return i;
    		}
    	}
        return numberOfValues;
    }
    
    private void insertAtIndex(int value, int index) {
    	for (int i = numberOfValues; i > index; i--) {
			arrayOfValues[i] = arrayOfValues[i - 1];
		}
    	arrayOfValues[index] = value;
    	numberOfValues++;
    }
    
    public boolean add(int value) {
    	if (binarySearch(value) != -1) {
    		return false;
    	}
        if(numberOfValues != 0 && numberOfValues < arrayOfValues.length) {
        	insertAtIndex(value, indexToPutInOrder(value));	
        	return true;
        }
        else if (numberOfValues == 0){
        	arrayOfValues[0] = value;
        	numberOfValues++;
        	return true;
        }
        else
        	return false;
    }

    public int binarySearch(int value) {
        return recursiveSearch(value, 0, numberOfValues-1);
    }

}
