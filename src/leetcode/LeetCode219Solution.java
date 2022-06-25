package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode219Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean res = false;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                res = Math.abs(map.get(nums[i]) - i) <= k;
                if (res) {
                    break;
                }else {
                    map.put(nums[i], i);
                }
            }
        }
        return res;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        //滑动窗口解决该问题，窗口大小固定为K+1，每次在[L, L+K]范围内查找
        HashSet<Integer> set = new HashSet<>(); //set中每次最多放k个元素
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                if(set.size() == k + 1){
                    set.remove(nums[i - k]);   //把当前元素加进来，删掉最左边的元素
                }
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        输入：nums = [1,2,3,1], k = 3
//        输出：true
        int[] nums = {1,0,1,1};
        boolean b = new LeetCode219Solution().containsNearbyDuplicate(nums, 1);
        System.out.println("b = " + b);
    }
}