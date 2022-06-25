package leetcode;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 */
class LeetCode345Solution {
    public String reverseVowels(String s) {
        if(s.length() <= 1){
            return s;
        }
        char[] chars = s.toCharArray();
        //对撞指针法反转元音字母
        int l = 0, r = s.length() - 1;
        while (l < r){
            if(!isVowel(chars[l])){
                //如果不是元音字母，跳过
                l ++;
                continue;
            }

            if(!isVowel(chars[r])){
                //如果不是元音字母，跳过
                r --;
                continue;
            }

            if(isVowel(chars[l]) && isVowel(chars[r])){
                swap(chars, l, r);
                l ++;
                r --;
            }
        }
        return new String(chars);
    }

    public void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public static void main(String[] args) {
//        输入：s = "hello"
//        输出："holle"
        String s = "hello";
    }
}