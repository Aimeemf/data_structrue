package map;

import java.util.ArrayList;
import java.util.HashMap;

class LeetCode350Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i1 : nums1) {
            if(!map.containsKey(i1)){
                map.put(i1, 1);
            }else {
                map.put(i1, map.get(i1) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i2 : nums2) {
            if(map.containsKey(i2)){
                list.add(i2);
                map.put(i2, map.get(i2) -1);
                if(map.get(i2) == 0){
                    map.remove(i2);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};

    }
}