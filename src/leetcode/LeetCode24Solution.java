package leetcode;

/**
 * Definition for singly-linked list.
 * 交换链表中相邻的两个元素
 */

class LeetCode24Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null){
            ListNode node1 =  p.next;
            ListNode node2 =  node1.next;
            ListNode next =  node2.next;
            node2.next = node1;   //node2指向node1
            node1.next = next;   //node1指向node2的next
            p.next = node2;     //p指向node2

            p = node1;
        }
        return dummyHead.next;
    }
}