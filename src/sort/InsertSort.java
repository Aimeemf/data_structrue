package sort;

public class InsertSort {
    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i = 1; i < arr.length; i++){
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--){
                swap(arr, j, j-1);
            }
        }
    }

    public static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,63,22,1,45};
        sort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }

        int n = 10000;
        arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("insertSort", arr);
    }
}
