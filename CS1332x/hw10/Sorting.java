import java.util.Comparator;
import java.util.Arrays;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int stopIdx = arr.length -1;
        // int compareCount = 0;
        // int swapCount = 0;
        // int iterCount = 0;
        while (stopIdx!=0 && iterCount < 2){
            int lastSwapped=-1;
            // begin sorting elements in the inner array and record lastSwapped idx
            for (int i=0; i<stopIdx; i++){
                // System.out.printf("Comparing %s and %s", arr[i].toString(), arr[i+1].toString());
                // System.out.println();
                if (comparator.compare(arr[i],arr[i+1])>0){
                    T tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    // System.out.printf("Swapped %d and %d", i, i+1);
                    // System.out.println();
                    lastSwapped = i;
                    // swapCount+=1;
                }
                // compareCount+=1;
                // System.out.println(Arrays.toString(arr));
            }
            // reducing stopIdx directly to lastSwapped or the sorting is finished if no swap occur
            if (lastSwapped!=-1){
                stopIdx = lastSwapped;
                // System.out.printf("stopIdx updated to %d", stopIdx);
                // System.out.println();
            } else {
                break;
                // System.out.printf("stopIdx updated to %d", stopIdx);
                // System.out.println();
            }
            // iterCount+=1;
        }
        // System.out.printf("total number of comparisons is: %d", compareCount);
        // System.out.println();
        // System.out.printf("total number of swaps is: %d", swapCount);
        // System.out.println();
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // outer loop, from n -> 0
        // int compareCount = 0;
        for (int i = arr.length-1; i >= 0; i--){
            int maxIdx=0; 
            // inner loop from 0 -> i, to find maximum
            for (int j=1; j<=i; j++){
                if (comparator.compare(arr[j], arr[maxIdx])>0){
                    maxIdx = j;
                }
                // compareCount+=1;
            }
            // place max value at the end of the reducing, outer loop array
            T tmp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = tmp;
        }
        // System.out.printf("total number of comparison is: %d", compareCount);
        // System.out.println();
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int i=1; i<arr.length;i++){
            // inner loop, compare outer loop value to inner array from i-1 to 0
            // inner array is assumed to be presorted
            for (int j=i;j>=1;j--){
                if (comparator.compare(arr[j-1],arr[j])>0){
                    T tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else {
                    // System.out.printf("Early exit of outer loop %d at idx: %d", i, j);
                    // System.out.println();
                    break;
                }
            }
            // System.out.printf("Outer loop at idx %d is finished.", i);
            // System.out.println();
        }
    }
}