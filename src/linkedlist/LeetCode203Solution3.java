package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode203Solution3 {
    public ListNode removeElements(ListNode head, int val) {
       if(head == null){
           return null;
       }

//       ListNode res = removeElements(head.next, val);
//       if(head.val == val){
//           return res;
//       }else {
//           head.next = res;
//           return head;
//       }

       head.next = removeElements(head.next, val);
       return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println((new LeetCode203Solution3()).removeElements(head, 6));
    }
}