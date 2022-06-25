package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class LeetCode71Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        //先按/分为数组
        String[] arr = path.split("/");
        for (String s : arr) {
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if(!s.equals(".") && s.length() > 0){
                stack.addLast(s);
            }
        }

        StringBuffer res = new StringBuffer();
        if(!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                res.append('/').append(stack.pollFirst());
            }
        }else {
            res.append("/");
        }

        return res.toString();
    }

    public static void main(String[] args) {
//        输入：path = "/a/./b/../../c/"
//        输出："/c"
        String path = "/home//foo/"; // a . b .. .. c
//        path = "/home/"; // a . b .. .. c
        String s = new LeetCode71Solution().simplifyPath(path);
        System.out.println("s = " + s);
        //  /a/b
    }
}