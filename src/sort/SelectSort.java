package sort;

public class SelectSort {
    public static <E extends Comparable<E>> void selectSort(E[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[minIndex].compareTo(arr[j]) < 0 ? minIndex : j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("selectSort", arr);


//        Student[] students = {new Student("Alice", 98), new Student("Bobo", 100), new Student("Charles", 66)};
//        selectSort(students);
//        for (int i = 0; i < students.length; i++){
//            System.out.print(students[i].toString() + ",");
//        }
    }
}
