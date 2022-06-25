package leetcode;

/**
 * Definition for singly-linked list.
 * 删除链表倒数第n个节点
 */
class LeetCode19Solution {
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

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length += 1;
            cur = cur.next;
        }

        ListNode dummyHead = new ListNode(-1, head);
        //删除倒数第二个，先找到待删除节点的前一个元素，也就是length - n;
        ListNode pre = dummyHead;
        for (int i = 0; i < length - n; i++) {
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return dummyHead.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        //让p指向待删除节点的前一个节点，也就是要找倒数第n+1个节点。
        //于是q先走n+1步，最后p和q一块走，等q走到链表结尾，p的位置就是要找的位置
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;
        return dummyHead.next;
    }
}