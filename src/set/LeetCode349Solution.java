package set;

import java.util.ArrayList;
import java.util.HashSet;

class LeetCode349Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i1 : nums1) {
            set1.add(i1);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int i2 : nums2) {
            if (set1.contains(i2)) {
                set2.add(i2);
            }
        }


        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer num : set2) {
            res[i] = num;
            i++;
        }

        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i1 : nums1) {
            set.add(i1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i2 : nums2) {
            if (set.contains(i2)) {
                list.add(i2);
                set.remove(i2);
            }
        }


        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}