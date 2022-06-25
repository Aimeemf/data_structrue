package sort;

public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1].compareTo(arr[i]) > 0){
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr){
        long sTime = System.nanoTime();
        if(sortName.equals("selectSort")) {
            SelectSort.selectSort(arr);
        }else  if(sortName.equals("insertSort")) {
            InsertSort.sort(arr);
        }else  if(sortName.equals("mergeSort")) {
            MergeSort.sort(arr);
        }else  if(sortName.equals("quickSort")) {
            QuickSort.sort(arr);
        }else  if(sortName.equals("quickSort2")) {
            QuickSort.sort2ways(arr);
        }else  if(sortName.equals("quickSort3")) {
            QuickSort.sort3ways(arr);
        }else  if(sortName.equals("heapSort")) {
            HeapSort.sort(arr);
        }else  if(sortName.equals("heapSort2")) {
            HeapSort.sort2(arr);
        }else  if(sortName.equals("bubbleSort")) {
            BubbleSort.sort2(arr);
        }else  if(sortName.equals("shellSort")) {
            ShellSort.sort(arr);
        }
        long eTime = System.nanoTime();
        double time = (eTime - sTime) / 1000000000.0;
        if(!SortingHelper.isSorted(arr)){
            throw new RuntimeException(sortName + " failed!");
        }
        System.out.println(String.format("%s, n = %d: %f s", sortName, arr.length, time));
    }
}
