package binarysearch;

public class BinarySearch {

    public static <E extends Comparable<E>> int searchR(E[] arr, E k){
        return searchR(arr, k, 0, arr.length - 1);
    }

    //非递归实现二分查找法
    public static <E extends Comparable<E>> int search(E[] arr, E k){
        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(k) == 0){
                return mid;
            }else if(arr[mid].compareTo(k) < 0) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private static <E extends Comparable<E>> int searchR(E[] arr, E k, int l, int r){
        if(l > r){
            return -1;
        }

        int mid = l + (r - l) / 2;
        if(arr[mid].compareTo(k) == 0){
            return mid;
        }else if(arr[mid].compareTo(k) < 0){
            return searchR(arr, k, mid + 1, r);
        }else {
            return searchR(arr, k, l, mid - 1);
        }
    }

    //查找大于target的最小索引
    private static <E extends Comparable<E>> int upper(E[] arr, E k) {
        int l = 0, r = arr.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(k) <= 0){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    //查找小于target的最大索引
    private static <E extends Comparable<E>> int lower(E[] arr, E k) {
        int l = -1, r = arr.length - 1;
        while (l < r){
            int mid = l + (r - l + 1) / 2;
            if(arr[mid].compareTo(k) < 0){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return r;
    }

    //查找小于target的最大索引
    //如果数组中存在元素，返回最小索引
    //如果数组中不存在元素，返回lower
    private static <E extends Comparable<E>> int lowerFloor(E[] arr, E k) {
       int lower = lower(arr, k);
       if(lower + 1 < arr.length && arr[lower + 1].compareTo(k) == 0){
           return lower + 1;
       }else {
           return lower;
       }
    }

    //查找小于target的最大索引
    //如果数组中存在元素，返回最大索引
    //如果数组中不存在元素，返回lower
    private static <E extends Comparable<E>> int upperFloor(E[] arr, E k) {
        int l = -1, r = arr.length - 1;
        while (l < r){
            int mid = l + (r - l + 1) / 2;
            if(arr[mid].compareTo(k) <= 0){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return r;
    }

    //查找大于等于target的最小索引
    // > target，返回最小值索引
    // == target，返回最小值索引
    private static <E extends Comparable<E>> int lowerCeil(E[] arr, E k) {
        int l = 0, r = arr.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(arr[mid].compareTo(k) < 0){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    // > target，返回最小值索引
    // == target，返回最大值索引
    public static <E extends Comparable<E>> int upperCeil(E[] arr, E k) {
        int upper = upper(arr, k);
        if(upper - 1 >= 0 && arr[upper-1] == k){
            return upper - 1;
        }else {
            return upper;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,3,3,5,5};
        int i = upper(arr, 6);
        System.out.println(i);

        int j = upperCeil(arr, 6);
        System.out.println(j);

        int k = lowerCeil(arr, 6);
        System.out.println(k);

        int m = lower(arr, 0);
        System.out.println(m);


        int n = lowerFloor(arr, 5);
        System.out.println(n);

        int l = upperFloor(arr, 5);
        System.out.println(l);
    }
}
