package leetcode;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
class LeetCode3Solution {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口[l, r]求不重复的最长子串
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int longestLen = 0;
        while (l < s.length()){
            if(r + 1 < s.length() && freq[s.charAt(r + 1)] == 0){
                //该元素不重复,右指针继续看下一个元素
                freq[s.charAt(r + 1)] ++;
                r ++;
            }else {
                //右指针已经到头，或者r+1元素已经重复
                freq[s.charAt(l)] --;
                l ++;
            }
            longestLen = Math.max(longestLen, r - l + 1);
        }
        return longestLen;
    }

    public static void main(String[] args) {
//        输入: s = "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        String s = " ";
        int i = new LeetCode3Solution().lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }
}