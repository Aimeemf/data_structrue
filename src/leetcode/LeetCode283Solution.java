package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
class LeetCode283Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;  //在[0...k)中保存所有当前遍历过的非零元素
        for (int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0){
                nums[k] = nums[i];
                k ++;
            }
        }

        for (int i = k; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int k = 0;  //在[0...k)中保存所有当前遍历过的非零元素
        for (int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0){
                if(i != k) {
                    swap(nums, k, i);
                }
                k ++;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        输入: nums = [0,1,0,3,12]
//        输出: [1,3,12,0,0]
        int[] nums = {1,3,12};
        new LeetCode283Solution().moveZeroes1(nums);
        System.out.println(nums);
    }
}