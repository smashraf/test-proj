package rohan.ds;

import rohan.ds.MyList.ListNode;

public class ListQue {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode rest = head.next;
        // understand this 10->20->30->40
        // here it is like 10, 40->30->20
        head  = reverseList(rest);
        first.next.next = first;
        first.next = null;
        return head;
    }

    public ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrone(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode mid = getMiddle(head);
        ListNode midNext = mid.next;
        ListNode revHead = reverseList(midNext);
        mid.next = null;
        while (revHead != null) {
            if (head.x != revHead.x)
                return false;
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }

    public ListNode reversePairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head,second = head.next;
        ListNode temp = reversePairs(second.next);
        first.next.next = first;
        first.next = temp;
        return second;
    }

    public ListNode reverseK(ListNode head, int k) {
        int temp = k;
        if (head == null)
            return head;
        ListNode c = head, p = null, n = null;
        while (c != null && k-- > 0) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        head.next = reverseK(c, temp);
        return p;
    }
}
