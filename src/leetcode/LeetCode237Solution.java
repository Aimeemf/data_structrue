package leetcode;

/**
 * Definition for singly-linked list.(删除给定的节点)
 **/

class LeetCode237Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        //因为只知道当前节点，无法获取到链表的上一个节点是什么，因此先把当前节点的下一个节点的val赋值给当前节点，再删掉下一个节点
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}