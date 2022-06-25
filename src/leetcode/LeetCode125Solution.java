package leetcode;

import com.sun.xml.internal.fastinfoset.stax.events.Util;

import java.util.Locale;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
class LeetCode125Solution {
    public boolean isPalindrome(String s) {
        if(Util.isEmptyString(s)){
            return true;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString().toLowerCase();
        //对撞指针法
        int l = 0, r = s.length() - 1;
        while (l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        new LeetCode125Solution().isPalindrome(s);
    }
}