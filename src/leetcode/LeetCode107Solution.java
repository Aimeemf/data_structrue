package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * Definition for a binary tree node. //自底向上的层序遍历
 */
class LeetCode107Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()){
            TreeNode node = queue.peek().getKey();
            int level = queue.peek().getValue();
            queue.poll();
            if(level == res.size()){
                //用linkedList每次在头部插入一个元素
                res.add(0, new ArrayList<>(Arrays.asList(node.val)));
            }else {
                res.get(0).add(node.val);
            }

            if(node.left != null){
                queue.add(new Pair<>(node.left, level + 1));
            }

            if(node.right != null){
                queue.add(new Pair<>(node.right, level + 1));
            }
        }
        return res;
    }
}