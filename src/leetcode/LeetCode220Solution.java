package leetcode;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode220Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //要满足题意，set中应该存在的元素的取值范围为[v-t, v+t].如果set中存在一个值大于等于v-t的最小值（ceiling）
            //并且小于v+t,则返回true
            if(set.ceiling((long)nums[i] - t) != null && set.ceiling((long)nums[i] - t) <= (long)nums[i] + t){
                return true;
            }else {
                set.add((long)nums[i]);
                if(set.size() == k + 1){
                    set.remove((long)nums[i - k]);
                }
            }
        }
        return false;
    }
}