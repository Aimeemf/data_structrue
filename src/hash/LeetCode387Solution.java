package hash;

import java.util.HashMap;
import java.util.Map;

class LeetCode387Solution {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j != i) {
                    if (s.charAt(j) == s.charAt(i)) {
                        break;
                    }
                }
                if (j == s.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == null){
                map.put(c, 1);
            }else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

        public static void main(String[] args) {
        String s = "dddccdbba";
        s = "loveleetcode";
//        s = "aabb";
//        s = "a";
        System.out.println(new LeetCode387Solution().firstUniqChar(s));
    }
}