package sort;

import java.util.Arrays;
import java.util.Random;

class Offer40Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[]{};
        }
        int i = getLeastNumber(arr, k - 1 , 0, arr.length - 1);
        int[] res = Arrays.copyOfRange(arr, 0, k);
        return res;
    }

    public int getLeastNumber(int[] arr, int k, int l, int r) {
        int p = partition(arr, l, r);
        if(p == k){
            return p;
        }else if(p < k){
            return getLeastNumber(arr, k, p + 1, r);
        }else {
            return getLeastNumber(arr, k, l, p-1);
        }
    }

    public int partition(int[] arr, int l, int r){
        int p = l + new Random().nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l]){
                i ++;
            }

            while (j >= i && arr[j] > arr[l]){
                j --;
            }

            if(i >= j){
                break;
            }

            swap(arr, i , j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,6,1,8,2};
        nums = new Offer40Solution().getLeastNumbers(nums, 5);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ",");
        }
    }
}