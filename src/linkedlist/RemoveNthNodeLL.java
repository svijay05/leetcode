package linkedlist;

import model.ListNode;

public class RemoveNthNodeLL {


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int l = len(head);

        int dele = l-n+1 ;

        int c = 0;
        ListNode temp = head;
        ListNode prev = null;
        while(head!=null){
            c++ ;
            if(c==dele){

                if(c==1) temp = null;
                else if(c==l) {prev.next=null;}
                else {prev.next=head.next;}
                break;
            }
            prev = head;
            head = head.next;
        }


        return temp;
    }


    private static int len(ListNode head) {

        int l = 0;

        while (head != null) {

            l++;
            head = head.next;
        }
        return l;

    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(4, null);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);

        ReorderLL.printLL(l4);
        ListNode res = removeNthFromEnd(l1, 1);
        ReorderLL.printLL(res);

    }


}
