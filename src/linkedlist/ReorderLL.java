package linkedlist;

import java.util.List;
import model.ListNode;

public class ReorderLL {

    public static void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("mid=" + slow.val);

        ListNode second = slow.next;
        second = rev(second);
        slow.next = null;

        printLL(second);
        printLL(head);

        ListNode first = head;
        while (second != null) {

            ListNode savedLink = first.next;
            first.next = second;
            ListNode savedLinkSecond = second.next;
            second.next = savedLink;
            second = savedLinkSecond;

            first = first.next.next;

        }

        printLL(head);

    }

    public static ListNode rev(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode savedLink = curr.next;
            curr.next = prev;
            prev = curr;
            curr = savedLink;

        }
        return prev;
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
        ListNode l4 = new ListNode(4, l3);

        printLL(l4);
        reorderList(l4);

    }

}
