package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 *
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode451Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else {
                map.put(c, map.get(c) + 1);
            }
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());
        //先把字母排好序，再按出现的frequency拼
        Collections.sort(list, (c1, c2) -> map.get(c2) - map.get(c1));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            int fre = map.get(list.get(i));
            for (int j = 0; j < fre; j++) {
                sb.append(list.get(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        输入: s = "tree"
//        输出: "eert"
//        解释: 'e'出现两次，'r'和't'都只出现一次。
//        因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
        String s = "tree";
        String s1 = new LeetCode451Solution().frequencySort(s);
        System.out.println("s1 = " + s1);

    }
}