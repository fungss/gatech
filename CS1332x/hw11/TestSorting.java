import java.util.Arrays;

public class TestSorting {

    public static void main(String args[]){
        IntComparator testComparator = new IntComparator();

        // System.out.println("-----Test Merge Sort-----");
        // Integer[] testArr1 = new Integer[]{8, 7, 6, 5, 4, 3, 2, 1};
        // Sorting.mergeSort(testArr1, testComparator);
        // System.out.println(Arrays.toString(testArr1));

        System.out.println("-----Test LSD Radix Sort-----");
        int[] testArr2 = new int[]{780, 281, 672, 432, 743, 743, 623, 288, 432, 281, 76};
        // int[] testArr2 = new int[]{1000, 2014, 231, 53, -1, -92, -9403, 634, -207, Integer.MIN_VALUE};
        // int[] testArr2 = new int[]{Integer.MAX_VALUE, 1147483647};
        Sorting.lsdRadixSort(testArr2);
        System.out.println(Arrays.toString(testArr2));
    }
}
