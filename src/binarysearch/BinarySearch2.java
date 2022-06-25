package binarysearch;

public class BinarySearch2 {
    //非递归实现二分查找法
    public static <E extends Comparable<E>> int search(E[] arr, E k){
        int l = 0, r = arr.length;
        //在data[l,r)范围中查找target
        while (l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(k) == 0){
                return mid;
            }else if(arr[mid].compareTo(k) < 0) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        int i = search(arr, 4);
        System.out.print(i);
    }
}
