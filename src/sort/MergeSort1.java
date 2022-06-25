package sort;

import java.util.Arrays;

public class MergeSort1 {
    public static void sort(int[] arr){
        sortBU(arr, 0 ,arr.length-1);
    }

    public static void sort(int[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sortBU(int[] arr, int l, int r){
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
    private static void merge(int[] arr, int l, int mid, int r){
       int[] help = new int[r-l+1];
       int p1 = l;
       int p2 = mid + 1;
       int i = 0;
       while (p1 <= mid && p2 <= r){
           help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
       }

       while (p1 <= mid){
           help[i++] = arr[p1++];
       }

        while (p2 <= r){
            help[i++] = arr[p2++];
        }

        //把help数字的数据copy回arr
        for (i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 4, 2};
        sort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }
    }
}
