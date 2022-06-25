package leetcode;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode205Solution {
    public boolean isIsomorphic(String s, String t) {
        //保证两个字符串中每个字母的关系是一对一的
        if (s.length() != t.length()){
            return false;
        }

        //双映射比较
        HashMap<Character, Character> smap = new HashMap<>();
        HashMap<Character, Character> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(smap.get(sc) != null && !smap.get(sc).equals(tc)){
                return false;
            }
            if(tmap.get(tc) != null && !tmap.get(tc).equals(sc)){
                return false;
            }
            smap.put(sc, tc);
            tmap.put(tc, sc);
        }
        return true;
    }

    public static void main(String[] args) {
//        输入：s = "egg", t = "add"
//        输出：true
        String s = "paper", t = "aaaaa";
        boolean isomorphic = new LeetCode205Solution().isIsomorphic(s, t);
        System.out.println("isomorphic = " + isomorphic);
    }
}