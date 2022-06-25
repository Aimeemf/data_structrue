package sort;

public class BubbleSort {
    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i = arr.length - 1; i > 0; i --){
            boolean isSwapped = false;
            for (int j = 0; j < i; j++){
                  if(arr[j].compareTo(arr[j + 1]) > 0){
                     swap(arr, j, j + 1);
                     isSwapped = true;
                 }
            }
            if(!isSwapped){
                break;
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        for (int i = 0; i < arr.length; i ++){
            for (int j = arr.length - 1; j > i; j --){
                if(arr[j - 1].compareTo(arr[j]) > 0){
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 5, 4, 6, 1, 3};
        sort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
//        int n = 100;
//        Integer[] arr = ArrayGenerator.generateOrderedArray(n);
//        SortingHelper.sortTest("bubbleSort", arr);
    }
}
