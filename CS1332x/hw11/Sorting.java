import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// =================================
// for testing purpose
import java.util.Arrays;
// =================================

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (arr.length <= 1){
            return;
        } else {
            // partitioning
            int len = arr.length;
            int midIdx = len/2;
            T[] left = (T[]) new Object[midIdx];
            T[] right = (T[]) new Object[len-midIdx];
            for (int k=0; k<midIdx;k++){
                left[k] = arr[k];
            }
            for (int k=midIdx; k<len;k++){
                right[k-midIdx] = arr[k];
            }
            mergeSort(left, comparator);
            mergeSort(right, comparator);
            
            // merging
            int i=0;
            int j=0;
            while (i<left.length && j<right.length){
                if (comparator.compare(left[i], right[j])<=0){
                    arr[i+j] = left[i];
                    i+=1;
                } else {
                    arr[i+j] = right[j];
                    j+=1;
                }
            }
            while (i<left.length){
                arr[i+j] = left[i];
                i+=1;
            }
            while (j<right.length){
                arr[i+j] = right[j];
                j+=1;
            }
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // System.out.println(Arrays.toString(arr));
        int k=0;
        for (int i=0;i<arr.length;i++){
            int len;
            // len = (int) (Math.log10(Integer.MAX_VALUE) + 1);
            len = calLen(arr[i]);
            if (len > k){
                k = len;
            }
        }
        // System.out.printf("The number of digits of the longest number is: %d", k);
        // System.out.println();
        LinkedList<Integer>[] buckets = new LinkedList[19];
        for (int i=0; i<19; i++){
            buckets[i] = new LinkedList<Integer>();
        }
        
        for (int iter=1;iter<=k;iter++){
            for (int i=0;i<arr.length;i++){
                int digit = extractDigit(arr[i], iter);
                // System.out.printf("iter %d; idx %d; value %d; digit %d", iter, digit+9, arr[i], digit);
                // System.out.println();
                buckets[digit+9].add(arr[i]);
            }
            int idx=0;
            for (int i=0; i<19; i++){
                while(buckets[i].size()!=0){
                    arr[idx]=buckets[i].removeFirst();
                    idx+=1;
                }

            }
            // System.out.println(Arrays.toString(arr));
        }

        
        
    }

    private static int calLen(int input){
        int len=0;
        long i=1;
        int val;
        if (input == Integer.MIN_VALUE){
            val=Integer.MAX_VALUE;
        } else {
            val=Math.abs(input);
        }
        while (i<=val) {
            len++;
            i*=10;
        }
        return len;
    }

    private static int extractDigit(int num, int k){
        int toBeReturned = num;
        for (int i=0;i<k-1;i++){
            toBeReturned/=10;
        }
        toBeReturned%=10;
        return toBeReturned;
    }
}