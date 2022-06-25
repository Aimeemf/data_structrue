package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode438Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }

        //初始化前p.length()个数据,初始化完并比较
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a'] ++;
            pCount[p.charAt(i) - 'a'] ++;
        }

        if(Arrays.equals(pCount, sCount)){
            list.add(0);
        }


        int l = 0;
        //滑动窗口的大小每次固定是p.length，每次左边少一个，右边加一个，不断考察新的窗口
        while (l + p.length() < s.length()){
            sCount[s.charAt(l) - 'a'] --;
            sCount[s.charAt(l + p.length()) - 'a'] ++;
            if(Arrays.equals(sCount, pCount)){
                list.add(l + 1);
            }
            l ++;
        }
        return list;
    }

    public static void main(String[] args) {
//        输入: s = "cbaebabacd", p = "abc"
//        输出: [0,6]
//        解释:
//        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

        String  s = "cbaebabacd", p = "abc";
        List<Integer> list = new LeetCode438Solution().findAnagrams(s, p);
        System.out.println("list = " + list);


    }
}