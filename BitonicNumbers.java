import java.util.Arrays;

public class BitonicNumbers{

    // Define class attributes
    private Boolean mode; // mode defines whether checking for ascending (T) or desceding (F) numbers
    private int arrayLength; // Length of the input array (for knowing how many times to run while loop)

    private int currentStartIndex; // Start index of currently explored sub-array
    private int currentEndIndex; // End index of currently explored sub-array

    private int[] bitonicNumbers; // Array to store bitonic numbers
    private int bestStartIndex; // Start index of best explored sub-array
    private int bestEndIndex; // End index of best explored sub-array
    private int bestLength; // Length of the best explored sub-array

    /**
     * Takes an array of numbers and finds the bitonic point/array. On each iteration 
     * of the outer while loop, a different number within the array is used as the
     * start index, and we check whether it is the start of the (longest) bitonic array.
     * @param numbers The array of input numbers
     * @return Bitonic numbers array
     */
    public int[] runAlgorithm(int[] numbers){
        
        arrayLength = numbers.length; 
        bestLength = 0;
        bestStartIndex = -1;
        bestEndIndex = -1;

        int startIndexCounter = 0;
        int i = 0; 

        /* Iterate over the input array, using each number as a possible start to 
        the bitonic array */

        while (startIndexCounter < arrayLength -1){
            currentStartIndex = startIndexCounter;
            currentEndIndex = 0;
            i = startIndexCounter;
            mode = true;

            /* Repeatedly check if subsequent number ascends, if one is lower, check subsequent numbers decrease */

            while (i < arrayLength -1){
                // Check next element in array is greater than the previous
                if (numbers[i+1] > numbers[i] && mode ==true) {
                    currentEndIndex = i+1;
                   
                // Check the next element is less than the previous
                }else if (numbers[i+1] < numbers[i]){
                    mode = false; // We are now checking for descreasing elements
                    currentEndIndex = i+1;
                    
                }else{
                    // If next number is not following the bitonic array rules, break the while loop
                    break;
                }
                i+=1;
            }

            // Check whether bitonic array is the longest
            if ((currentEndIndex - currentStartIndex) >= bestLength && mode == false){
                bestLength = currentEndIndex - currentStartIndex;
                bestStartIndex = currentStartIndex;
                bestEndIndex = currentEndIndex;  
            }

            startIndexCounter += 1;
        }

        // Copy bitonic array to a new array and return it
        if (bestStartIndex == -1 && bestEndIndex == -1){
            bitonicNumbers = new int[]{-1};
        }else{
            bitonicNumbers = Arrays.copyOfRange(numbers, bestStartIndex, bestEndIndex + 1);
        }

        return bitonicNumbers;
    }
}