package leetcode;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode290Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        //双map处理映射
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> strMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            //一个c对应多个word
            if(charMap.containsKey(c) && !charMap.get(c).equals(word)){
                return false;
            }
            //一个word对应多个c,类似 pattern = "abba", str = "dog dog dog dog";
            if(strMap.containsKey(word) && !strMap.get(word).equals(c)){
                return false;
            }
            charMap.put(c, word);
            strMap.put(word, c);
        }
        return true;
    }

    public static void main(String[] args) {
//        String pattern = "abba", str = "dog cat cat dog";
        String pattern = "bbbb", str = "dog dog dog dog";
        boolean b = new LeetCode290Solution().wordPattern(pattern, str);
        System.out.println("b = " + b);
    }
}