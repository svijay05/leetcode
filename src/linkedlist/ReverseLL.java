package linkedlist;

public class ReverseLL {

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


    public static ListNode reverseList(ListNode head) {

        ListNode res = rev(head, null);

        printLL(res);

        return res;
    }

    private static ListNode rev(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }

        ListNode saved = curr.next;
        curr.next = prev;
        prev= curr;

        return rev(saved, prev);
    }

    public static void printLL(ListNode head) {
        System.out.println("");
        while (head != null) {

            System.out.print(head.val + "->");
            head = head.next;

        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);

        printLL(l3);
        reverseList(l3);

    }
}
