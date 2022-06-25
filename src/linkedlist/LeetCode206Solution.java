package linkedlist;

/**
 * Definition for singly-linked list.
 * 翻转链表
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode206Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        return reverse(head);
    }

    public ListNode reverse(ListNode node) {
        if(node == null){
            return null;
        }
        ListNode listNode = reverse(node.next);
        node.next = listNode;
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode listNode = (new LeetCode206Solution()).reverseList(head);
        System.out.println(listNode);
    }
}