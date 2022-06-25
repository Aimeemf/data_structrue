package leetcode;

import java.util.Stack;

class LeetCode150Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+")) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.push(a1 + a2);
            } else if (token.equals("-")) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.push(a2 - a1);
            } else if (token.equals("*")) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.push(a1 * a2);
            } else if (token.equals("/")) {
                int a1 = stack.pop();
                int a2 = stack.pop();
                stack.push(a2 / a1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        输入：tokens = ["2","1","+","3","*"]
//        输出：9
//        解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
        String[] tokens = {"2", "1", "+", "3", "*"};
        int i = new LeetCode150Solution().evalRPN(tokens);
        System.out.println("i = " + i);
    }
}