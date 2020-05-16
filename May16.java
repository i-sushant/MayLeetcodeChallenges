import java.util.*;

public class May16 {
    static class ListNode {
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

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = null;
        ListNode curr = evenAfterOdd(ln);
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

    public static ListNode evenAfterOdd(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenstart = null;
        ListNode evenend = null;
        ListNode oddstart = null;
        ListNode oddend = null;
        ListNode curr = head;
        int i = 1;
        while (curr != null) {
            if (i % 2 != 0) {
                if (oddstart == null) {
                    oddstart = curr;
                    oddend = oddstart;
                } else {
                    oddend.next = curr;
                    oddend = curr;
                }
            } else {
                if (evenstart == null) {
                    evenstart = curr;
                    evenend = evenstart;
                } else {
                    evenend.next = curr;
                    evenend = curr;
                }
            }
            curr = curr.next;
            i++;
        }
        oddend.next = evenstart;
        evenend.next = null;
        return oddstart;
    }

}
