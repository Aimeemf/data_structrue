package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * Definition for a binary tree node.自顶向下的层序遍历
 */
class LeetCode102Solution {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
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
                res.add(new ArrayList<>(Arrays.asList(node.val)));
            }else {
                res.get(level).add(node.val);
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