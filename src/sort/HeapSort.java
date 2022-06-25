package sort;

import maxheap.MaxHeap;

import java.util.Arrays;

public class HeapSort {
    public static <E extends Comparable<E>> void sort(E[] data) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : data) {
            maxHeap.add(e);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            data[i] = maxHeap.extractMax();
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {
        if (data.length <= 1){
            return;
        }

        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }

        for(int i = data.length - 1; i >= 0; i--){
            swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    private static <E extends Comparable<E>> void siftDown( E[] arr, int k, int n) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if(j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0){
                j ++;
            }
            if(arr[k].compareTo(arr[j]) >= 0) {
                break;
            }else {
                swap(arr, k, j);
                k = j;
            }
        }
    }

    public static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);
        Integer[] array4 = Arrays.copyOf(array, array.length);
        Integer[] array5 = Arrays.copyOf(array, array.length);
        SortingHelper.sortTest("quickSort", array);
        SortingHelper.sortTest("quickSort2", array2);
        SortingHelper.sortTest("quickSort3", array3);
        SortingHelper.sortTest("heapSort", array4);
        SortingHelper.sortTest("heapSort2", array5);
    }
}
