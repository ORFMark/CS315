package Homework.HW_6;
public class SubMerge extends OrderedBuffer {

    public SubMerge(int size) {
        super(size);
    }
    private boolean unorderedAdd(int value) {
    	 if (numberOfValues < arrayOfValues.length) {
             arrayOfValues[numberOfValues] = value;
             numberOfValues++;
             return true;
         } else
             return false;
    }
    public void copyMerge1(OrderedBuffer left, OrderedBuffer right) {
        int left_i = 0;
        int leftEnd = left.numberOfValues - 1;
        int right_i = 0;
        int rightEnd = right.numberOfValues - 1;
        int i = 0;
        // while there is data available from both sources
            // if next data in left is less or same
                // copy next value from left source
                // increment left_i
            // else (data in right is less)
                // copy next value from right source
                // increment right_i
            // increment i
        // now that one source has no more data, copy other's remaining data
        // while there is more data in left source
            // copy from left, increment left_i, increment i
        // while there is data in right source, copy from right
            // copy from right, increment right_i, increment i
        // finally set numberOfValues to i
        while(left_i <= leftEnd && right_i <= rightEnd) {
        	if(left.getValueAtIndex(left_i) <= right.getValueAtIndex(right_i)) {
        		unorderedAdd(left.getValueAtIndex(left_i));
        		left_i++;
        	}
        	else {
        		unorderedAdd(right.getValueAtIndex(right_i));
        		right_i++;
        	}
        	i++;
        }
        if(left_i > leftEnd) {
        	for(int j = right_i; j <= rightEnd; j++) {
        		unorderedAdd(right.getValueAtIndex(j));
        		i++;
        	}
        }
        else {
        	for(int j = left_i; j <= leftEnd; j++) {
        		unorderedAdd(left.getValueAtIndex(j));
        		i++;
        	}
        }
        //numberOfValues = i;
    }

    public void copyMerge2(OrderedBuffer left, OrderedBuffer right) {
        int left_i = 0;
        int leftEnd = left.numberOfValues - 1;
        int right_i = 0;
        int rightEnd = right.numberOfValues - 1;
        int i = 0;
        // while there is data to copy in at least one source
            // if no more data to copy in right source 
                // copy next value from left source
                // increment left_i
            // else if no more data to copy in left source
                // copy next value from right source
                // increment right_i
            // else if next value on left is less or same as next right
                // copy next value from left source
                // increment left_i
            // else (next data on right less than on left)
                // copy next value from right source
                // increment right_i
            // increment i
        // finally set numberOfValues to i
        while (right_i <= rightEnd || left_i <= leftEnd) {
        	if (right_i > rightEnd) {
        		unorderedAdd(left.getValueAtIndex(left_i));
        		left_i++;
        	}
        	else if (left_i > leftEnd) {
        		unorderedAdd(right.getValueAtIndex(right_i));
        		right_i++;
        	}
        	else if (left.getValueAtIndex(left_i) <= right.getValueAtIndex(right_i)) {
        		unorderedAdd(left.getValueAtIndex(left_i));
        		left_i++;
        	}
        	else {
        		unorderedAdd(right.getValueAtIndex(right_i));
        		right_i++;
        	}
        }
    }

    public void copyMerge3(OrderedBuffer left, OrderedBuffer right) {
        int left_i = 0;
        int leftEnd = left.numberOfValues - 1;
        int right_i = 0;
        int rightEnd = right.numberOfValues - 1;
        int i = 0;
        // while there is data left to copy in at least one source
            // while data on left, and right has none or left data is less or same
                // copy next value from left source
                // increment left_i
                // increment i
            // while data on right, and left has none or right data is less or same
                // copy next value from right source
                // increment right_i
                // increment i
        // finally set numberOfValues to i
        while(left_i <= leftEnd || right_i <= rightEnd) {
        	while(left_i <= leftEnd && ((right_i > rightEnd) || left.getValueAtIndex(left_i) <= right.getValueAtIndex(right_i))) {
        		unorderedAdd(left.getValueAtIndex(left_i));
        		left_i++;
        	}
        	while ((right_i <= rightEnd && (left_i > leftEnd || right.getValueAtIndex(right_i) <= left.getValueAtIndex(left_i)))) {
        		unorderedAdd(right.getValueAtIndex(right_i));
        		right_i++;
        	}
        }
    }

}
