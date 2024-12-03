package sorting;
import java.util.Random;
public class SortingDemo {
    public static void main(String[] args) {
        int[] array = generateRandomArray(10000);

        // Test Bubble Sort
        int[] bubbleArray = array.clone();
        long bubbleStart = System.currentTimeMillis();
        BubbleSort.bubbleSort(bubbleArray);
        long bubbleEnd = System.currentTimeMillis();
        System.out.println("Bubble Sort Time: " + (bubbleEnd - bubbleStart) + " ms");

        // Test Quick Sort
        int[] quickArray = array.clone();
        long quickStart = System.currentTimeMillis();
        QuickSort.quickSort(quickArray, 0, quickArray.length - 1);
        long quickEnd = System.currentTimeMillis();
        System.out.println("Quick Sort Time: " + (quickEnd - quickStart) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }
}


