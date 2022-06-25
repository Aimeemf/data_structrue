package sort;

import java.util.Random;

class LeetCode215Solution {
    public int findKthLargest(int[] nums, int k) {
       return findKthLargest(nums, nums.length - k , 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k, int l ,int r) {
        //生成[l,r]之间的随机索引
        int p = l + (new Random().nextInt(r - l + 1));
        swap(nums, l, p);

//        //arr[l+1,lt] < v, [lt+1, i-1] = v, arr[gt, r] > v
//        int lt = l, i = l + 1, gt = r + 1;
//        while (i < gt){
//            if(nums[i] < nums[l]){
//                lt ++;
//                swap(nums, i, lt);
//                i++;
//            }else if(nums[i] == nums[l]){
//                i ++;
//            }else {
//                gt --;
//                swap(nums, i, gt);
//            }
//        }
//        swap(nums, l, lt);
        int lt = partition(nums, l, r);
        if(lt == k){
            return nums[lt];
        }else if(lt < k){
            return findKthLargest(nums, k, lt + 1, r);
        }else {
            return findKthLargest(nums, k, l, lt - 1);
        }
    }

    private int partition(int[] arr, int l, int r){
        //生成[l,r]之间的随机索引
//        int p = l + (new Random().nextInt(r - l + 1));
//        swap(arr, l, p);

        //arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l]){
                i++;
            }

            while (j >= i && arr[j] > arr[l]){
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

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 6, 1, 8, 2};
        int kthLargest = new LeetCode215Solution().findKthLargest(nums, 4);
        System.out.print(kthLargest);

    }
}