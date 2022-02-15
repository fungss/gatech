import java.util.Arrays;

public class TestSorting {

    public static void main(String args[]){
        Integer[] testArr;
        IntComparator testComparator = new IntComparator();

        // System.out.println("-----Test Selection Sort-----");
        // testArr = new Integer[]{4, 3, 1, 5, 2, 6, 7};
        // Sorting.selectionSort(testArr, testComparator);
        // System.out.println(Arrays.toString(testArr));

        // System.out.println("-----Test Insertion Sort-----");
        // testArr = new Integer[]{4, 3, 1, 5, 2, 6, 7};
        // Sorting.insertionSort(testArr, testComparator);
        // System.out.println(Arrays.toString(testArr));

        System.out.println("-----Test Bubble Sort-----");
        // testArr = new Integer[]{4, 3, 1, 5, 2, 6, 7};
        testArr = new Integer[]{1, 2, 6, 5, 3, 4, 7, 8, 9};
        Sorting.bubbleSort(testArr, testComparator);
        // System.out.println(Arrays.toString(testArr));
    }
}
