package sort;

import java.util.Arrays;

public class MergeSort {
    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0 ,arr.length-1);
    }
    //自顶向下
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //自底向上的归并排序
    public static <E extends Comparable<E>> void sortBu(E[] arr, int l, int r){
        int n = arr.length;

        //遍历合并的区间长度
        for(int sz = 1; sz < n; sz += sz){
            //遍历合并的两个区间的起始位置
            for(int i = 0; i + sz < n; i+= sz + sz){
                merge(arr, i, i+sz -1, Math.min(i + sz + sz -1, n-1));
            }
        }
    }

    //合并两个有序的区间：arr[l,mid] 和 arr[mid+1, r];
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
        E[] temp = Arrays.copyOfRange(arr, l, r+1);
        int i = l, j = mid + 1;
        //每轮循环为arr[k]赋值
        for(int k = l; k <= r; k++){
            if(i > mid){
                arr[k] = temp[j-l];
                j++;
            }else if(j > r){
                arr[k] = temp[i - l];
                i++;
            }else{
                if(temp[i-l].compareTo(temp[j-l]) <= 0) {
                    arr[k] = temp[i-l];
                    i++;
                }else {
                    arr[k] = temp[j-l];
                    j++;
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("mergeSort", arr);
    }
}
