package linkedlist;

/**
 * Definition for singly-linked list.
 * 翻转链表(递归实现)
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode206Solution1 {
    public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }

        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode listNode = (new LeetCode206Solution1()).reverseList(head);
        System.out.println(listNode);
    }
}