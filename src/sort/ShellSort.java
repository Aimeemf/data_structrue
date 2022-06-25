package sort;

public class ShellSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int h = arr.length / 2; h > 0; h = h / 2) {
            for (int i = h; i < arr.length; i ++) {
                for (int j = i - h; j >= 0 && arr[j].compareTo(arr[j + h]) > 0; j -= h) {
                    swap(arr, j, j + h);
                }
            }
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        Integer[] arr = {6, 3, 7, 8, 1, 2, 5, 4};
//        sort(arr);
//        for (Integer num : arr) {
//            System.out.print(num + ",");
//        }
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        SortingHelper.sortTest("shellSort", arr);
    }
}
