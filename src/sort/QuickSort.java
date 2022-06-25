package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length -1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r){
        //生成[l,r]之间的随机索引
        int p = l + (new Random().nextInt(r - l + 1));
        swap(arr, l, p);

        int j = l;      //j为小于区域的最后一个元素
        for (int i = l + 1; i <= r; i ++){
            if(arr[i].compareTo(arr[l]) < 0){
                swap(arr, i, ++j);   //将i和j的下一个元素，也就是大于区域的第一个元素交换
            }
        }
        //将l放到小于区域的最后一位
        swap(arr, l ,j);
        return j;
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr){
        sort2ways(arr, 0, arr.length -1);
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int p = partition2(arr, l, r);
        sort2ways(arr, l, p - 1);
        sort2ways(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr){
        sort3ways(arr, 0, arr.length -1);
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r){
        if(l >= r){
            return;
        }
        //生成[l,r]之间的随机索引
        int p = l + (new Random().nextInt(r - l + 1));
        swap(arr, l, p);

        //arr[l+1,lt] < v, [lt+1, i-1] = v, arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt){
            if(arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, i, lt);
                i++;
            }else if(arr[i].compareTo(arr[l]) == 0){
                i ++;
            }else {
                gt --;
                swap(arr, i, gt);
            }
        }
        swap(arr, l, lt);

        sort3ways(arr, l, lt - 1);
        sort3ways(arr, gt, r);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r){
        //生成[l,r]之间的随机索引
        int p = l + (new Random().nextInt(r - l + 1));
        swap(arr, l, p);

        //arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i].compareTo(arr[l]) < 0){
                i++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(arr, i , j);
            i ++;
            j --;
        }
        //将l放到小于区域的最后一位
        swap(arr, l ,j);
        return j;
    }

    public static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 1000;
        Integer[] array = ArrayGenerator.generateRandomArray(n, n);
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);
        SortingHelper.sortTest("quickSort", array);
        SortingHelper.sortTest("quickSort2", array2);
        SortingHelper.sortTest("quickSort3", array3);

        array = ArrayGenerator.generateRandomArray(n, 1);
        array2 = Arrays.copyOf(array, array.length);
        array3 = Arrays.copyOf(array, array.length);
        SortingHelper.sortTest("quickSort", array);
        SortingHelper.sortTest("quickSort2", array2);
        SortingHelper.sortTest("quickSort3", array3);
    }
}
