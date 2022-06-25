package leetcode;

import java.util.HashMap;

class LeetCode454Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        //先把C和D所有组合结果放到一个查找表中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int result = nums3[i] + nums4[j];
                if(!map.containsKey(result)){
                    map.put(result, 1);
                }else {
                    map.put(result, map.get(result) + 1);
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int target = 0 - nums1[i] - nums2[j];
                if(map.containsKey(target)){
                    count += map.get(target);
                }
            }
        }

        return count;
    }
}