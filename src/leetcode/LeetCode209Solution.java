package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode209Solution {
    //时间复杂度O(n)，空间复杂度O(1)
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口解决该问题
        int l = 0;
        int r = -1;
        int minLength = nums.length + 1;
        int sum = 0;
        while (l < nums.length){
            if(r + 1 < nums.length && sum < target){
                r ++;
                //如果当前值小于target，右指针向前移，则给当前的sum加上num[++r]的值
                sum += nums[r];
            }else{
                //如果当前值大于target，则给当前的sum减去num[l]的值，左指针向前移，l++
                sum -= nums[l];
                l ++;
            }

            if(sum >= target){
                minLength = Math.min((r - l + 1), minLength);
            }
        }

        if(minLength == nums.length + 1){
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
//        输入：target = 7, nums = [2,3,1,2,4,3]
//        输出：2
//        解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        int[] nums = {1, 2, 3, 4, 5};
        int i = new LeetCode209Solution().minSubArrayLen(15, nums);
        System.out.println("i = " + i);
    }
}