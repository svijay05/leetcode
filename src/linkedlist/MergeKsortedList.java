package linkedlist;

import java.util.PriorityQueue;
import model.ListNode;

public class MergeKsortedList {

    public class ListNode {

        public int getVal() {
            return val;
        }

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

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode  head =  new ListNode();
        ListNode curr = head ;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((x,y)->x.getVal() - y.getVal());
        for(ListNode node: lists){
            pq.add(node);
        }

        while(!pq.isEmpty()){

            ListNode n =   pq.poll();
            curr .next= n; 
            curr = curr.next;

            if(n.next!=null){
                n = n.next;
                pq.offer(n);
            }

        }

        return head.next;
    }

}
