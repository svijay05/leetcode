package linkedlist;

import model.ListNode;

public class AddTwoNumberLL {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0, null);
        ListNode head = temp;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int sum = 0;
            if (l1 != null) {
                sum = sum+ l1.val;
            }
            if (l2 != null) {
                sum = sum +  l2.val;
            }
            sum= sum + carry;

            int digit = sum % 10;
            carry = sum / 10;


            if (temp == null) {
                temp.next = new ListNode(digit, null);

            } else {

                temp.next = new ListNode(digit , null);
            }
            temp = temp.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if(l2!=null) {
                l2 = l2.next;
            }

        }

        if (carry != 0) {
            temp.next = new ListNode(carry, null);
        }

        return head.next;

    }


    private static void printLL(ListNode head) {
        System.out.println("");
        while (head != null) {

            System.out.print(head.val + "->");
            head = head.next;

        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9, null);
        ListNode l2 = new ListNode(9, l1);
        ListNode l3 = new ListNode(9, l2);
        ListNode l4 = new ListNode(9, l3);

        ListNode l7 = new ListNode(9, null);
        ListNode l8 = new ListNode(9, l7);
        ListNode l9 = new ListNode(5, l8);

        printLL(l4);
        printLL(l8);
        ListNode res = addTwoNumbers(l4, l8);
        printLL(res);


    }

}
